package com.assertsolutions.camel.springboot.restdsl.dto;

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
public class RequestAnularGuias {

    @JsonProperty
    @ApiModelProperty(dataType = "String", required = true)
    private String idguia;

    @JsonProperty
    @ApiModelProperty(dataType = "String", required = true)
    private String username;
    
    @JsonProperty
    @ApiModelProperty(dataType = "String", required = true)
    private String tipoguia;
    
    /*
     * non-argument constructor
     */
    public RequestAnularGuias() {
    }
    
    
	public String getIdguia() {
		return idguia;
	}


	public void setIdguia(String idguia) {
		this.idguia = idguia;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getTipoguia() {
		return tipoguia;
	}


	public void setTipoguia(String tipoguia) {
		this.tipoguia = tipoguia;
	}


	
    
   

}
