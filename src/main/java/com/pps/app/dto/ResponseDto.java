package com.pps.app.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.pps.enumeration.StatusText;


@JsonInclude(value = Include.NON_NULL)
public class ResponseDto<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7718442820004362480L;
	
private int status;	
	
	private StatusText statusText;
	
	private Integer total;

	private String errorCode;
	
	private String message;

	private Integer page;

	private Integer pageSize;
	
	private ResponseErrorDto responseError;

	private T data;
	

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public StatusText getStatusText() {
		return statusText;
	}

	public void setStatusText(StatusText statusText) {
		this.statusText = statusText;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public ResponseErrorDto getResponseError() {
		return responseError;
	}

	public void setResponseError(ResponseErrorDto responseError) {
		this.responseError = responseError;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}
