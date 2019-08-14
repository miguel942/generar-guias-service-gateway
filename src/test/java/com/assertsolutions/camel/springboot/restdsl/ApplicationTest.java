package com.assertsolutions.camel.springboot.restdsl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.assertsolutions.camel.springboot.restdsl.dto.ResponseConsultarGuias;

/**
 * 
 * @author Assert Solutions S.A.S
 * 
 */
@RunWith(SpringRunner.class)
@Configuration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, properties = { "server.port=8081" })
public class ApplicationTest {

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private TestRestTemplate restTemplate;

      
    
    @Test
    public void testGet() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-MESSAGE-ID", String.valueOf(Calendar.getInstance().getTimeInMillis()));
        HttpEntity<String> httpEntity = new HttpEntity<String>(null, headers);
        // Call the REST API
        ResponseEntity<ResponseConsultarGuias> response = restTemplate.exchange("http://localhost:8081/api/guias/consultarRangosGuias",
                HttpMethod.GET, httpEntity, ResponseConsultarGuias.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getResultado().contains(("Hello")));
    }


}