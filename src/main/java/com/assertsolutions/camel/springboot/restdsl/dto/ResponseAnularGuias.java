package com.assertsolutions.camel.springboot.restdsl.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author Assert Solutions S.A.S
 *
 */
@XmlRootElement
@JsonAutoDetect
@JsonSerialize
@ApiModel(description = "Response DTO Object")
public class ResponseAnularGuias implements Serializable {

    private static final long serialVersionUID = -6104876573750302537L;

    @JsonProperty
    @ApiModelProperty(dataType = "String")
    private String succes;
    
    @JsonProperty
    @ApiModelProperty(dataType = "Object")
    private Object resultado;
    
    @JsonProperty
    @ApiModelProperty(dataType = "String")
    private String error;

    public String getSucces() {
		return succes;
	}

	public void setSucces(String succes) {
		this.succes = succes;
	}

	public Object getResultado() {
		return resultado;
	}

	public void setResultado(Object resultado) {
		this.resultado =  resultado;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	/*
     * non-argument constructor
     */
    public ResponseAnularGuias() {
    }

    

}
