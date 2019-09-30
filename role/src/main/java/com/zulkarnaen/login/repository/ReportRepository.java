package com.zulkarnaen.login.repository;

import java.util.List;

public interface ReportRepository {
	
	List<Object[]> findCustomerByDate(String startDate, String endDate);

	List<Object[]> findAgentByDate(String dateStart, String dateEnd);

	List<Object[]> findTransactionByDate(String dateStart, String dateEnd);

	List<Object[]> findAgentHistoryByDate(String dateStart, String dateEnd);

	List<Object[]> findForm1ByDate(String dateStart, String dateEnd);

	List<Object[]> findForm2ByDate(String dateStart, String dateEnd);
	
	List<Object[]> findForm4ByDate(String dateStart, String dateEnd);

	List<Object[]> findForm9ByDate(String dateStart, String dateEnd);
}