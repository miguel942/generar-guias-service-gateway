package com.assertsolutions.camel.springboot.restdsl.dto;

import java.util.Map;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author Assert Solutions. S.A.S
 *
 */
@XmlRootElement
@JsonAutoDetect
@JsonSerialize
@ApiModel(description = "Request DTO Object")
public class Request {

    @JsonProperty
    @ApiModelProperty(dataType = "String", required = true)
    @Size(min = 10, max = 45)
    private String param;

    @JsonProperty
    @ApiModelProperty(dataType = "String", required = true)
    @Size(min = 10, max = 45)
    private Map<String, Object> params;

    /*
     * non-argument constructor
     */
    public Request() {
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

}
