package com.pps.app.dto;

import java.io.Serializable;

public class IncomeTb1Dto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1057060222845605707L;
	
	private String codeIncomeTb1;
	
	private String nameThIncomeTb1;

	private String nameEngIncomeTb1;

	public String getCodeIncomeTb1() {
		return codeIncomeTb1;
	}

	public void setCodeIncomeTb1(String codeIncomeTb1) {
		this.codeIncomeTb1 = codeIncomeTb1;
	}

	public String getNameThIncomeTb1() {
		return nameThIncomeTb1;
	}

	public void setNameThIncomeTb1(String nameThIncomeTb1) {
		this.nameThIncomeTb1 = nameThIncomeTb1;
	}

	public String getNameEngIncomeTb1() {
		return nameEngIncomeTb1;
	}

	public void setNameEngIncomeTb1(String nameEngIncomeTb1) {
		this.nameEngIncomeTb1 = nameEngIncomeTb1;
	}

}
