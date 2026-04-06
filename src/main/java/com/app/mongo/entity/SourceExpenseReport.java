package com.app.mongo.entity;

//@Document(collection = "daily_expense")
public class SourceExpenseReport {

	private String source;
	private double amount;
	private String month;

	private double min;
	private double max;
	private Long transactions;
	
	public SourceExpenseReport() {
		
	}
	


	public SourceExpenseReport(String source, double amount, String month, double min, double max,
			Long transactions) {
		super();
		this.source = source;
		this.amount = amount;
		this.month = month;
		this.min = min;
		this.max = max;
		this.transactions = transactions;
	}



	public double getMin() {
		return min;
	}
	public void setMin(double min) {
		this.min = min;
	}
	public double getMax() {
		return max;
	}
	public void setMax(double max) {
		this.max = max;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public Long getTransactions() {
		return transactions;
	}
	public void setTransactions(Long transactions) {
		this.transactions = transactions;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}

	@Override
	public String toString() {
		return "SourceExpenseReport [min=" + min + ", max=" + max + ", amount=" + amount + ", source=" + source
				+ ", transactions=" + transactions + ", month=" + month + "]";
	}
	
	

}
