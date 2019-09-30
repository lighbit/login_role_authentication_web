package com.zulkarnaen.login.model;

public class Form9Model {

	//
	private Integer jmlAgent, femaleCustmerCount, maleCustmerCount, agentMale, agentFemale, jmlCustomer;
	private String branchCode, city, bankCode;

	
	
	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public Integer getJmlAgent() {
		jmlAgent= getAgentFemale()+getAgentMale();
		return jmlAgent;
	}

	public void setJmlAgent(Integer jmlAgent) {
		this.jmlAgent = jmlAgent;
	}

	public Integer getFemaleCustmerCount() {
		return femaleCustmerCount;
	}

	public void setFemaleCustmerCount(Integer femaleCustmerCount) {
		this.femaleCustmerCount = femaleCustmerCount;
	}

	public Integer getMaleCustmerCount() {
		return maleCustmerCount;
	}

	public void setMaleCustmerCount(Integer maleCustmerCount) {
		this.maleCustmerCount = maleCustmerCount;
	}

	public Integer getAgentMale() {
		
		return agentMale;
	}

	public void setAgentMale(Integer agentMale) {
		this.agentMale = agentMale;
	}

	public Integer getAgentFemale() {
		return agentFemale;
	}

	public void setAgentFemale(Integer agentFemale) {
		this.agentFemale = agentFemale;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getJmlCustomer() {
		jmlCustomer=getMaleCustmerCount()+getFemaleCustmerCount();
		return jmlCustomer;
	}

	public void setJmlCustomer(Integer jmlCustomer) {
		this.jmlCustomer = jmlCustomer;
	}
	
	

}
