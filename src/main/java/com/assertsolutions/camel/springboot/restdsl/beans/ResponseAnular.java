package com.assertsolutions.camel.springboot.restdsl.beans;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

import com.assertsolutions.camel.springboot.restdsl.dto.RequestAnularGuias;
import com.assertsolutions.camel.springboot.restdsl.dto.ResponseAnularGuias;

import io.swagger.annotations.ApiModelProperty;

@Component
public class ResponseAnular {


    @ApiModelProperty(notes = "Parametro De Salida")
    public ResponseAnularGuias  responseAnular (Exchange exchange ) {
            
    	
		
		RequestAnularGuias obj = new RequestAnularGuias(); 
		 obj = (RequestAnularGuias) exchange.getIn().getBody();
				 
		 ResponseAnularGuias response = new ResponseAnularGuias();
		 
		 response.setSucces("true");
		 response.setResultado( obj );
		 response.setError(null);
		
		 	return response;
	    }
 }
    
