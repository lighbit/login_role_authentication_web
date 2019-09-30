package com.zulkarnaen.login.model;

import java.util.Date;

public class AgentHistoryModel {

	//
	private String agentName, agentNo;
	private Date tglAgentDaftar, tglPelaksanaan;
	private String latitude, longitude, postalCode, city, perubahanAgent, cabangAgent;

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getAgentNo() {
		return agentNo;
	}

	public void setAgentNo(String agentNo) {
		this.agentNo = agentNo;
	}

	public Date getTglAgentDaftar() {
		return tglAgentDaftar;
	}

	public void setTglAgentDaftar(Date tglAgentDaftar) {
		this.tglAgentDaftar = tglAgentDaftar;
	}

	public Date getTglPelaksanaan() {
		return tglPelaksanaan;
	}

	public void setTglPelaksanaan(Date tglPelaksanaan) {
		this.tglPelaksanaan = tglPelaksanaan;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPerubahanAgent() {
		return perubahanAgent;
	}

	public void setPerubahanAgent(String perubahanAgent) {
		this.perubahanAgent = perubahanAgent;
	}

	public String getCabangAgent() {
		return cabangAgent;
	}

	public void setCabangAgent(String cabangAgent) {
		this.cabangAgent = cabangAgent;
	}

}
