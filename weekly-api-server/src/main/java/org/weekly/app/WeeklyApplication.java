package org.weekly.app;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.feature.AbstractFeature;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.openapi.OpenApiFeature;
import org.apache.cxf.jaxrs.validation.JAXRSBeanValidationInInterceptor;
import org.apache.cxf.jaxrs.validation.JAXRSBeanValidationOutInterceptor;
import org.apache.cxf.jaxrs.validation.ValidationExceptionMapper;
import org.apache.cxf.validation.BeanValidationFeature;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.weekly.api.CalendarApi;
import org.weekly.api.impl.CalendarApiServiceImpl;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@SpringBootApplication
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)
public class WeeklyApplication extends WebSecurityConfigurerAdapter {

    @Autowired
    private Bus bus;

    @Bean
    public JacksonJsonProvider getJacksonJsonProvider() {
        return new JacksonJsonProvider();
    }

    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
        JdbcTemplate template = new JdbcTemplate(dataSource);
        template.setFetchSize(1024);
        return template;
    }

    @Bean
    public OpenApiFeature getOpenApiFeature() {
        OpenApiFeature feature = new OpenApiFeature();
        feature.setVersion("3.0.0");
        feature.setPrettyPrint(true);
        feature.setResourcePackages(Set.of("org.weekly.api"));
        feature.setDescription("Weekly Rest API");
        feature.setSupportSwaggerUi(true);
        feature.setSwaggerUiMavenGroupAndArtifact("org.webjars.swagger-ui");
        feature.setSwaggerUiVersion("3.25.0");
        return feature;
    }

    @Bean("features")
    public List<AbstractFeature> getFeatures(OpenApiFeature feature) {
        return List.of(feature, new BeanValidationFeature());
    }

    @Bean
    public CalendarApi getCalendarApi() {
        return new CalendarApiServiceImpl();
    }

    @Bean("serviceBeans")
    public List<Object> getServiceBeans(CalendarApi calendarApi) {
        return Arrays.asList(calendarApi);
    }

    @Bean
    public Server jaxRsServer(JacksonJsonProvider provider,
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
                .oauth2Login();
    }

    public static void main(String[] args) {
        SpringApplication.run(WeeklyApplication.class, args);
    }
}
