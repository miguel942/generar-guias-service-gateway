package com.assertsolutions.camel.springboot.restdsl.routes;

import org.apache.camel.Endpoint;
import org.apache.camel.EndpointInject;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.assertsolutions.camel.springboot.restdsl.dto.RequestAnularGuias;
import com.assertsolutions.camel.springboot.restdsl.dto.ResponseAnularGuias;
import com.assertsolutions.camel.springboot.restdsl.dto.ResponseConsultarGuias;

/**
 * 
 * @author Assert Solutions S.A.S
 *
 */
@Component
public class CamelRestDslConfigurationRoute extends RouteBuilder {

	@EndpointInject(uri = MainRoute.DIRECT_MAIN_ROUTE_ENDPOINT)
	private Endpoint directEndpoint;

	@Autowired
	private Environment env;

	@Override
	public void configure() throws Exception {

		interceptFrom("endpointUri").when(header("X-MESSAGE-ID").isNotNull()).process(ex -> {
            MDC.put("X-MESSAGE-ID", ex.getIn().getHeader("X-MESSAGE-ID", String.class));
        });
		
		// @formatter:off

		rest(env.getProperty("camel.rest.uri"))
				.description(env.getProperty("api.description"))
				.consumes(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.produces(MediaType.APPLICATION_JSON_UTF8_VALUE)

				.get(env.getProperty("camel.rest.consultarRangosGuias"))
				.description(env.getProperty("api.description.service"))
				.outType(ResponseConsultarGuias.class).responseMessage()
				.code(200).message("All users successfully returned")
				.endResponseMessage().to("direct:ConsultarRangoGuias")

				.post(env.getProperty("camel.rest.anularguias"))
				.description(env.getProperty("api.description.service"))
				.type(RequestAnularGuias.class)
				.outType(ResponseAnularGuias.class)
				.description(env.getProperty("api.description.input.post"))
				.responseMessage().code(200)
				.message("All users successfully created").endResponseMessage()
				.to("direct:anularguias")

				.post(env.getProperty("camel.rest.carguemasivoexterno"))
				.description(env.getProperty("api.description.service"))
				.type(RequestAnularGuias.class)
				.outType(ResponseAnularGuias.class)
				.description(env.getProperty("api.description.input.post"))
				.responseMessage().code(200)
				.message("All users successfully created").endResponseMessage()
				.to("direct:anularguias")

				.post(env.getProperty("camel.rest.carguemasivoexternodetalle"))
				.description(env.getProperty("api.description.service"))
				.type(RequestAnularGuias.class)
				.outType(ResponseAnularGuias.class)
				.description(env.getProperty("api.description.input.post"))
				.responseMessage().code(200)
				.message("All users successfully created").endResponseMessage()
				.to("direct:anularguias")

				.post(env.getProperty("camel.rest.generarguiasticker"))
				.description(env.getProperty("api.description.service"))
				.type(RequestAnularGuias.class)
				.outType(ResponseAnularGuias.class)
				.description(env.getProperty("api.description.input.post"))
				.responseMessage().code(200)
				.message("All users successfully created").endResponseMessage()
				.to("direct:anularguias")

				.post(env.getProperty("camel.rest.generarguiastickermobile"))
				.description(env.getProperty("api.description.service"))
				.type(RequestAnularGuias.class)
				.outType(ResponseAnularGuias.class)
				.description(env.getProperty("api.description.input.post"))
				.responseMessage().code(200)
				.message("All users successfully created").endResponseMessage()
				.to("direct:anularguias")

				.post(env.getProperty("camel.rest.generarmanifiestos"))
				.description(env.getProperty("api.description.service"))
				.type(RequestAnularGuias.class)
				.outType(ResponseAnularGuias.class)
				.description(env.getProperty("api.description.input.post"))
				.responseMessage().code(200)
				.message("All users successfully created").endResponseMessage()
				.to("direct:anularguias")

				.post(env.getProperty("camel.rest.guiaspendientesxmanifiestos"))
				.description(env.getProperty("api.description.service"))
				.type(RequestAnularGuias.class)
				.outType(ResponseAnularGuias.class)
				.description(env.getProperty("api.description.input.post"))
				.responseMessage().code(200)
				.message("All users successfully created").endResponseMessage()
				.to("direct:anularguias");

		// @formatter:on
	};

}
