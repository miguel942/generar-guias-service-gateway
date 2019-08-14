package com.assertsolutions.camel.springboot.restdsl.beans;

import org.apache.camel.Handler;
import org.springframework.stereotype.Component;

import com.assertsolutions.camel.springboot.restdsl.dto.ResponseConsultarGuias;

import io.swagger.annotations.ApiModelProperty;

@Component
public class ResponseGuias {

	@Handler
    @ApiModelProperty(notes = "Parametro De Salida")
    public ResponseConsultarGuias guias() {
        ResponseConsultarGuias dto = new ResponseConsultarGuias();
        dto.setResultado("numero de guias");
        return dto;
    }
}
