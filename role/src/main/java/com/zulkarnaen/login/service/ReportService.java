package com.zulkarnaen.login.service;

import java.util.Date;
import java.util.List;

import com.zulkarnaen.login.model.AgentHistoryModel;
import com.zulkarnaen.login.model.AgentModel;
import com.zulkarnaen.login.model.CustomerModel;
import com.zulkarnaen.login.model.Form1Model;
import com.zulkarnaen.login.model.Form2Model;
import com.zulkarnaen.login.model.Form9Model;
import com.zulkarnaen.login.model.TransactionModel;
import com.zulkarnaen.login.model.form4ModelOut;

public interface ReportService {

	List<AgentModel> provideDataAgent(Date startDate, Date endDate);

	List<CustomerModel> provideDataCustomer(Date startDate, Date endDate);

	List<TransactionModel> provideDataTransaction(Date startDate, Date endDate);

	List<AgentHistoryModel> provideDataAgentHistory(Date startDate, Date endDate);

	List<Form1Model> provideForm1Data(Date startDate, Date endDate);

	List<Form2Model> provideForm2aData(Date startDate, Date endDate);

	List<form4ModelOut> provideForm4aData(Date startDate, Date endDate);

	List<Form9Model> provideForm9Data(Date startDate, Date endDate);

}
