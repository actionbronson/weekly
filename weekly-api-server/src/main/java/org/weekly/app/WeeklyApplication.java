package org.weekly.app;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.apache.cxf.Bus;
import org.apache.cxf.feature.AbstractFeature;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.openapi.OpenApiFeature;
import org.apache.cxf.jaxrs.validation.JAXRSBeanValidationInInterceptor;
import org.apache.cxf.jaxrs.validation.JAXRSBeanValidationOutInterceptor;
import org.apache.cxf.jaxrs.validation.ValidationExceptionMapper;
import org.apache.cxf.validation.BeanValidationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.endpoint.DefaultAuthorizationCodeTokenResponseClient;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
import org.weekly.api.CalendarApi;
import org.weekly.api.TasksApi;
import org.weekly.store.UserRepository;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@SpringBootApplication
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)
@OpenAPIDefinition(
    info = @Info(version = "3.0.1", description = "Weekly API Server"),
    servers = {
        @Server(url = "https://localhost:8443/api/rest/v1", description = "Local development server"),
        @Server(url = "https://weekplanner.app/api/rest/v1", description = "Production Azure server")
    }
)
@EnableMongoRepositories(basePackageClasses={UserRepository.class})
@EnableCaching
@ComponentScan(basePackages = {"org.weekly.store", "org.weekly.api.impl", "org.weekly.security"})
public class WeeklyApplication extends WebSecurityConfigurerAdapter {

    @Autowired
    private Bus bus;

    @Autowired
    private OAuth2AuthorizedClientService oAuth2ClientService;

    @Autowired
    private ClientRegistrationRepository registrationRepository;

    @Autowired
    private OAuth2AuthorizedClientRepository clientRepository;

    @Bean
    public JacksonJsonProvider getJacksonJsonProvider() {
        return new JacksonJsonProvider();
    }

    @Bean
    public CacheManager getCacheManager(@Value("${spring.cache.names}") List<String> cacheNames) {
        return new ConcurrentMapCacheManager(cacheNames.toArray(new String [] {}));
    }

    @Bean
    public OpenApiFeature getOpenApiFeature() {
        OpenApiFeature feature = new OpenApiFeature();
        feature.setPrettyPrint(true);
        feature.setResourcePackages(Set.of("org.weekly"));
        feature.setSupportSwaggerUi(true);
        feature.setUseContextBasedConfig(true);
        feature.setSwaggerUiMavenGroupAndArtifact("org.webjars.swagger-ui");
        feature.setSwaggerUiVersion("3.38.0");
        return feature;
    }

    @Bean("features")
    public List<AbstractFeature> getFeatures(OpenApiFeature feature) {
        return List.of(feature, new BeanValidationFeature());
    }

    @Bean("serviceBeans")
    public List<Object> getServiceBeans(@Autowired CalendarApi calendarApi, @Autowired TasksApi tasksApi) {
        return Arrays.asList(calendarApi, tasksApi);
    }

    @Bean
    public org.apache.cxf.endpoint.Server jaxRsServer(JacksonJsonProvider provider,
                              @Qualifier("serviceBeans") List<Object> serviceBeans,
                              @Qualifier("features") List<AbstractFeature> features,
                              ValidationExceptionMapper validationExceptionMapper) {
        JAXRSServerFactoryBean factory = new JAXRSServerFactoryBean();
        factory.setServiceBeans(serviceBeans);
        factory.setProvider(provider);
        factory.setProviders(Arrays.asList(provider, validationExceptionMapper));
        factory.setFeatures(features);
        factory.setInInterceptors(Arrays.asList(new JAXRSBeanValidationInInterceptor()));
        factory.setOutInterceptors(Arrays.asList(new JAXRSBeanValidationOutInterceptor()));
        factory.setBus(bus);
        return factory.create();
    }

    @Bean
    public ValidationExceptionMapper getValidationExceptionMapper() {
        ValidationExceptionMapper mapper = new ValidationExceptionMapper();
        mapper.setAddMessageToResponse(true);
        return mapper;
    }

    protected void configure(@NotNull HttpSecurity http) throws Exception {
        http
            .antMatcher("/**")
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .oauth2Login()
                .clientRegistrationRepository(registrationRepository)
                .authorizedClientRepository(clientRepository)
                .authorizedClientService(oAuth2ClientService)
                .tokenEndpoint().accessTokenResponseClient(new DefaultAuthorizationCodeTokenResponseClient());
        http.csrf().disable();
    }

    public static void main(String[] args) {
        SpringApplication.run(WeeklyApplication.class, args);
    }
}
