package com.app.mongo.entity;

public class FilterData {

	private String sourceSelect;
	private String sortSelectItem;
	private String transactionFromDate;
	private String transactionToDate;
	private String loginUser;

	public String getSourceSelect() {
		return sourceSelect;
	}

	public void setSourceSelect(String sourceSelect) {
		this.sourceSelect = sourceSelect;
	}

	public String getSortSelectItem() {
		return sortSelectItem;
	}

	public void setSortSelectItem(String sortSelectItem) {
		this.sortSelectItem = sortSelectItem;
	}

	public String getTransactionFromDate() {
		return transactionFromDate;
	}

	public void setTransactionFromDate(String transactionFromDate) {
		this.transactionFromDate = transactionFromDate;
	}

	public String getTransactionToDate() {
		return transactionToDate;
	}

	public void setTransactionToDate(String transactionToDate) {
		this.transactionToDate = transactionToDate;
	}

	public String getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}

}
