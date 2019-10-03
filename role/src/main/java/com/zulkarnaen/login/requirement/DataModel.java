package com.zulkarnaen.login.requirement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataModel {
	public static final String EQ = "eq";
	public static final String NE = "ne";
	public static final String LIKE = "like";
	public static final String GT = "GT";
	public static final String LT = "LT";
	public static final String NULL = "NULL";
	public static final String NOT_NULL = "NOT_NULL";

	/**
	 * Data result after query
	 */
	@SuppressWarnings("rawtypes")
	private List dataResult;
	/**
	 * Key for searching
	 */
	private List<CriteriaModel> keySearch;

	private Map<String, String> alias;

	private int currentPage;
	private int maxResult;
	private int resultCount;

	public DataModel() {
		keySearch = new ArrayList<CriteriaModel>();
		alias = new HashMap<String, String>();
		maxResult = 10;
	}

	@SuppressWarnings("rawtypes")
	public List getDataResult() {
		return dataResult;
	}

	@SuppressWarnings("rawtypes")
	public void setDataResult(List dataResult) {
		this.dataResult = dataResult;
	}

	public List<CriteriaModel> getKeySearch() {
		return keySearch;
	}

	public void setKeySearch(List<CriteriaModel> keySearch) {
		this.keySearch = keySearch;
	}

	public Map<String, String> getAlias() {
		return alias;
	}

	public void setAlias(Map<String, String> alias) {
		this.alias = alias;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getMaxResult() {
		return maxResult;
	}

	public void setMaxResult(int maxResult) {
		this.maxResult = maxResult;
	}

	public int getResultCount() {
		return resultCount;
	}

	public void setResultCount(int resultCount) {
		this.resultCount = resultCount;
	}

	public int getTotalPage() {
		return Math.max(
				(int) Math.ceil(Double.valueOf(resultCount)
						/ Double.valueOf(maxResult)), 1);
	}

	public int getFirstRow() {
		return Math.min(currentPage * maxResult + 1, getResultCount());
	}

	public int getLastRow() {
		return Math.min((currentPage + 1) * maxResult, resultCount);
	}

	public void addSearchCriteria(String fieldName, String operator,
			Object value) {
		keySearch.add(new CriteriaModel(fieldName, operator, value));
	}

	public void addAlias(String fieldName, String aliasName) {
		this.alias.put(fieldName, aliasName);
	}
}
