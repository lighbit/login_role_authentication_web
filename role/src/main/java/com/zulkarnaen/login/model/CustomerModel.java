package com.zulkarnaen.login.model;

import java.util.Date;

public class CustomerModel {
	
	//
	
	private String branchCode;
	private Date tanggalDibuat;
	private String nomorKartu;
	private String nomorRekening;
	private Date tanggalUpdate;
	private String alamat,CIF;
	private Date tanggalLahir;
	private String email;
	private String name;
	private String phoneNo;
	private String sex,status,agentNo;
	
	
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	public Date getTanggalDibuat() {
		return tanggalDibuat;
	}
	public void setTanggalDibuat(Date tanggalDibuat) {
		this.tanggalDibuat = tanggalDibuat;
	}
	public String getNomorKartu() {
		return nomorKartu;
	}
	public void setNomorKartu(String nomorKartu) {
		this.nomorKartu = nomorKartu;
	}
	public String getNomorRekening() {
		return nomorRekening;
	}
	public void setNomorRekening(String nomorRekening) {
		this.nomorRekening = nomorRekening;
	}
	public Date getTanggalUpdate() {
		return tanggalUpdate;
	}
	public void setTanggalUpdate(Date tanggalUpdate) {
		this.tanggalUpdate = tanggalUpdate;
	}
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	public String getCIF() {
		return CIF;
	}
	public void setCIF(String cIF) {
		CIF = cIF;
	}
	public Date getTanggalLahir() {
		return tanggalLahir;
	}
	public void setTanggalLahir(Date tanggalLahir) {
		this.tanggalLahir = tanggalLahir;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAgentNo() {
		return agentNo;
	}
	public void setAgentNo(String agentNo) {
		this.agentNo = agentNo;
	}

}
