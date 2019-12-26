package edu.lab.back.config;

import edu.lab.back.util.converters.CustomJaxb2RootElementHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;

@Configuration
public class MessageConverterConfig {

    @Bean
    public Jaxb2RootElementHttpMessageConverter jaxb2RootElementHttpMessageConverter() {
        final Jaxb2RootElementHttpMessageConverter res = new CustomJaxb2RootElementHttpMessageConverter();
        return res;
    }

}
