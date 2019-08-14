package com.assertsolutions.camel.springboot.restdsl.beans;

import org.apache.camel.Handler;
import org.springframework.stereotype.Component;

import com.assertsolutions.camel.springboot.restdsl.dto.Response;

import io.swagger.annotations.ApiModelProperty;

@Component
public class ResponseHandler {

    @Handler
    @ApiModelProperty(notes = "Parametro De Salida")
    public Response handler() {
        Response dto = new Response();
        dto.setParam("Hello");
        return dto;
    }
}
