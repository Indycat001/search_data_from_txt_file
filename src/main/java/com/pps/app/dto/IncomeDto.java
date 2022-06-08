package com.pps.app.dto;

import java.io.Serializable;
import java.util.List;



public class IncomeDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7149340354959746512L;
	
	private String codeIncome;
	private String nameIncome;
	private List<IncomeTb1Dto> IncomeTb1;
	private List<IncomeTb2Dto> IncomeTb2;
	public String getCodeIncome() {
		return codeIncome;
	}
	public void setCodeIncome(String codeIncome) {
		this.codeIncome = codeIncome;
	}
	public String getNameIncome() {
		return nameIncome;
	}
	public void setNameIncome(String nameIncome) {
		this.nameIncome = nameIncome;
	}
	public List<IncomeTb1Dto> getIncomeTb1() {
		return IncomeTb1;
	}
	public void setIncomeTb1(List<IncomeTb1Dto> incomeTb1) {
		IncomeTb1 = incomeTb1;
	}
	public List<IncomeTb2Dto> getIncomeTb2() {
		return IncomeTb2;
	}
	public void setIncomeTb2(List<IncomeTb2Dto> incomeTb2) {
		IncomeTb2 = incomeTb2;
	}
	
}
