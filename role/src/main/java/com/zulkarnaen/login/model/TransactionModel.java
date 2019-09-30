package com.zulkarnaen.login.model;

import java.util.Date;

public class TransactionModel {
	//
	private Date tglTransaksi;
	private String namaCustomer, phoneNoCustomer, namaAgent, noAgent, transactionName, accountSourceName,
			accountSourceNo, codeResponse, accountDestNo, accountDestName, txType;
	
	private Double nominalTx;

	public Date getTglTransaksi() {
		return tglTransaksi;
	}

	public void setTglTransaksi(Date tglTransaksi) {
		this.tglTransaksi = tglTransaksi;
	}

	public String getNamaCustomer() {
		return namaCustomer;
	}

	public void setNamaCustomer(String namaCustomer) {
		this.namaCustomer = namaCustomer;
	}

	public String getPhoneNoCustomer() {
		return phoneNoCustomer;
	}

	public void setPhoneNoCustomer(String phoneNoCustomer) {
		this.phoneNoCustomer = phoneNoCustomer;
	}

	public String getNamaAgent() {
		return namaAgent;
	}

	public void setNamaAgent(String namaAgent) {
		this.namaAgent = namaAgent;
	}

	public String getNoAgent() {
		return noAgent;
	}

	public void setNoAgent(String noAgent) {
		this.noAgent = noAgent;
	}

	public String getTransactionName() {
		return transactionName;
	}

	public void setTransactionName(String transactionName) {
		this.transactionName = transactionName;
	}

	public String getAccountSourceName() {
		return accountSourceName;
	}

	public void setAccountSourceName(String accountSourceName) {
		this.accountSourceName = accountSourceName;
	}

	public String getAccountSourceNo() {
		return accountSourceNo;
	}

	public void setAccountSourceNo(String accountSourceNo) {
		this.accountSourceNo = accountSourceNo;
	}

	public String getCodeResponse() {
		return codeResponse;
	}

	public void setCodeResponse(String codeResponse) {
		this.codeResponse = codeResponse;
	}

	public String getAccountDestNo() {
		return accountDestNo;
	}

	public void setAccountDestNo(String accountDestNo) {
		this.accountDestNo = accountDestNo;
	}

	public String getAccountDestName() {
		return accountDestName;
	}

	public void setAccountDestName(String accountDestName) {
		this.accountDestName = accountDestName;
	}

	public String getTxType() {
		return txType;
	}

	public void setTxType(String txType) {
		this.txType = txType;
	}

	public Double getNominalTx() {
		return nominalTx;
	}

	public void setNominalTx(Double nominalTx) {
		this.nominalTx = nominalTx;
	}

}
