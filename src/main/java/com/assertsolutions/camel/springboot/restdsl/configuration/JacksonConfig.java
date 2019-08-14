package com.assertsolutions.camel.springboot.restdsl.configuration;

import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {

    @Bean("responseJackson")
    public JacksonDataFormat createJacksonFormat() {
        JacksonDataFormat jacksonDataFormat = new JacksonDataFormat();
        jacksonDataFormat.setPrettyPrint(true);
        jacksonDataFormat.setUnmarshalType(com.assertsolutions.camel.springboot.restdsl.dto.Response.class);
        jacksonDataFormat.setEnableJaxbAnnotationModule(true);

        return jacksonDataFormat;
    }

}
