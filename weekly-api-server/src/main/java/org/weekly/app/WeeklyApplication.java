package org.weekly.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.endpoint.EndpointImpl;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.apache.cxf.endpoint.Server;
import org.springframework.context.annotation.Configuration;
import org.weekly.api.CalendarApi;
import org.weekly.api.impl.CalendarApiServiceImpl;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class WeeklyApplication implements InitializingBean {
    @Autowired
    private Bus bus;

    @Autowired
    private ApplicationContext context;

    @Bean
    public JacksonJsonProvider getJacksonJsonProvider() {
        return new JacksonJsonProvider();
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
    public Server jaxRsServer(JacksonJsonProvider provider, @Qualifier("serviceBeans") List<Object> serviceBeans) {
        JAXRSServerFactoryBean factory = new JAXRSServerFactoryBean();
        factory.setServiceBeans(serviceBeans);
        factory.setProvider(provider);
        factory.setBus(bus);
        return factory.create();
    }

    public static void main(String[] args) {
        SpringApplication.run(WeeklyApplication.class, args);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(Arrays.asList(context.getBeanDefinitionNames()));
    }
}
