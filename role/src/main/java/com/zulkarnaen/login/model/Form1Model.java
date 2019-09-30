package com.zulkarnaen.login.model;

import java.util.Date;

public class Form1Model {

	//
	private String agentName, agentNo;
	private Date tglAgentDaftar, tglPelaksanaan;
	private String latitude, longitude, postalCode, city, perubahanAgent, cabangAgent;
	private String sandiBank, electronicDevice, statusAgent, jaringanKantor, jenisAgent, 
	klasifikasiAgent, jenisUsahaAgent, kategoriJaringanKantor, statusPerkembanganAgent;
	
	
	
	public String getJenisAgent() {
		return jenisAgent;
	}

	public void setJenisAgent(String jenisAgent) {
		this.jenisAgent = jenisAgent;
	}

	public String getKlasifikasiAgent() {
		return klasifikasiAgent;
	}

	public void setKlasifikasiAgent(String klasifikasiAgent) {
		this.klasifikasiAgent = klasifikasiAgent;
	}

	public String getJenisUsahaAgent() {
		return jenisUsahaAgent;
	}

	public void setJenisUsahaAgent(String jenisUsahaAgent) {
		this.jenisUsahaAgent = jenisUsahaAgent;
	}

	public String getKategoriJaringanKantor() {
		return kategoriJaringanKantor;
	}

	public void setKategoriJaringanKantor(String kategoriJaringanKantor) {
		this.kategoriJaringanKantor = kategoriJaringanKantor;
	}

	public String getStatusPerkembanganAgent() {
		return statusPerkembanganAgent;
	}

	public void setStatusPerkembanganAgent(String statusPerkembanganAgent) {
		this.statusPerkembanganAgent = statusPerkembanganAgent;
	}

	public String getSandiBank() {
		return sandiBank;
	}

	public void setSandiBank(String sandiBank) {
		this.sandiBank = sandiBank;
	}

	public String getElectronicDevice() {
		return electronicDevice;
	}

	public void setElectronicDevice(String electronicDevice) {
		this.electronicDevice = electronicDevice;
	}

	public String getStatusAgent() {
		return statusAgent;
	}

	public void setStatusAgent(String statusAgent) {
		this.statusAgent = statusAgent;
	}

	public String getJaringanKantor() {
		return jaringanKantor;
	}

	public void setJaringanKantor(String jaringanKantor) {
		this.jaringanKantor = jaringanKantor;
	}

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
