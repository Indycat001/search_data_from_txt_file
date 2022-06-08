package com.pps.app.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
public class ResponseErrorDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3005744141549218609L;
	
	private String errorTitle;

    private String errorDescription;
    
    

	public ResponseErrorDto() {
	}


	public ResponseErrorDto(String errorTitle, String errorDescription) {
		this.errorTitle = errorTitle;
		this.errorDescription = errorDescription;
	}


	public String getErrorTitle() {
		return errorTitle;
	}



	public void setErrorTitle(String errorTitle) {
		this.errorTitle = errorTitle;
	}



	public String getErrorDescription() {
		return errorDescription;
	}



	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

}
