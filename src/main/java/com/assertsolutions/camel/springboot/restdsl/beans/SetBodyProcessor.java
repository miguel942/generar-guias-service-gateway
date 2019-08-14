package com.assertsolutions.camel.springboot.restdsl.beans;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import com.assertsolutions.camel.springboot.restdsl.dto.RequestAnularGuias;

/**
 * 
 * @author Assert Solutions. S.A.S
 *
 */
@Component
public class SetBodyProcessor implements Processor {
	
	public String  requestbody;
	
	 @Override
	    public void process(Exchange exchange) throws Exception {
		 	
		 requestbody  =  String.valueOf(exchange.getIn().getBody());
		 RequestAnularGuias obj = new RequestAnularGuias(); 
		 obj = (RequestAnularGuias) exchange.getIn().getBody();
				 
		 RequestAnularGuias request = new RequestAnularGuias();
		 
			 request.setUsername(obj.getUsername());
			 request.setIdguia(obj.getIdguia());
			 request.setTipoguia(obj.getTipoguia());
		 	
			 exchange.getIn().setBody(request);
	        
	    }

}
