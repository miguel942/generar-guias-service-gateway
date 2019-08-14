package com.assertsolutions.camel.springboot.restdsl.routes;

import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.EndpointInject;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.assertsolutions.camel.springboot.restdsl.beans.ResponseAnular;
import com.assertsolutions.camel.springboot.restdsl.beans.ResponseGuias;

/**
 * 
 * @author Assert Solutions. S.A.S
 *
 */
@Component
public class MainRoute extends RouteBuilder {

	 public static final String DIRECT_MAIN_ROUTE_ENDPOINT = "direct://endpoint";

	    @EndpointInject(uri = DIRECT_MAIN_ROUTE_ENDPOINT)
	    private Endpoint directEndpoint;
	
	@Autowired
	private Logger logger;

	@Autowired
	private CamelContext camelContext;
	
	@Autowired
	private ResponseAnular reponseanularguias;

	@Autowired
	private ResponseGuias responseguias;

	@Override
	public void configure() throws Exception {

		interceptFrom(DIRECT_MAIN_ROUTE_ENDPOINT).when(header("X-REQUEST-ID").isNotNull()).process(ex -> {
            MDC.put("X-REQUEST-ID", ex.getIn().getHeader("X-REQUEST-ID", String.class));
        });
		
		// @formatter:off
		
		camelContext.setUseMDCLogging(Boolean.TRUE);
		
		from("direct:ConsultarRangoGuias").doTry().bean(responseguias)
				.log(LoggingLevel.INFO, logger, "Response: ${body}").endDoTry()
				.doCatch(Exception.class)
				.log(LoggingLevel.ERROR, logger, "${exception.stacktrace}")
				.end();

		from("direct:anularguias").doTry().bean(reponseanularguias)
				.log(LoggingLevel.INFO, logger, "Response: ${body}").endDoTry()
				.doCatch(Exception.class)
				.log(LoggingLevel.ERROR, logger, "${exception.stacktrace}")
				.end();

		// @formatter:on

	}

}
