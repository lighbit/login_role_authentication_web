package com.zulkarnaen.login.requirement;

public class CriteriaModel {
	private String operator;
	private String fieldName;
	private Object value;

	public CriteriaModel(String fieldName, String operator, Object value) {
		this.operator = operator;
		this.fieldName = fieldName;
		this.value = value;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
}
