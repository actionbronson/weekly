package org.weekly.app;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import io.vavr.collection.Array;
import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.feature.AbstractFeature;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
//import org.apache.cxf.jaxrs.swagger.Swagger2Feature;
import org.apache.cxf.jaxrs.swagger.Swagger2Feature;
import org.apache.cxf.jaxrs.validation.JAXRSBeanValidationInInterceptor;
import org.apache.cxf.jaxrs.validation.JAXRSBeanValidationOutInterceptor;
import org.apache.cxf.jaxrs.validation.ValidationExceptionMapper;
import org.apache.cxf.validation.BeanValidationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.weekly.api.CalendarApi;
import org.weekly.api.impl.CalendarApiServiceImpl;


import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class WeeklyApplication {

    @Autowired
    private Bus bus;

    @Autowired
    private ApplicationContext context;

    @Bean
    public JacksonJsonProvider getJacksonJsonProvider() {
        return new JacksonJsonProvider();
    }

    @Bean
    public Swagger2Feature getSwagger2Feature() {
        Swagger2Feature feature = new Swagger2Feature();
        feature.setBasePath("/swagger");
        feature.setPrettyPrint(true);
        feature.setSchemes(new String [] {"http"});
        feature.setDescription("Weekly Rest API");
        feature.setSupportSwaggerUi(true);
        return feature;
    }

    @Bean("features")
    public List<AbstractFeature> getFeatures(Swagger2Feature feature) {
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
//
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                    .apis(RequestHandlerSelectors.basePackage("org.weekly"))
//                    .paths(PathSelectors.any())
//                .build()
//                .apiInfo(
//                        new ApiInfoBuilder()
//                                .version("1.0")
//                                .title("Calendar API")
//                                .description("Calendar API v1.0").build());
//    }

    public static void main(String[] args) {
        SpringApplication.run(WeeklyApplication.class, args);
    }
}
