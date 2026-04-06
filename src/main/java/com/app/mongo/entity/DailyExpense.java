package com.app.mongo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "daily_expense")
public class DailyExpense {

	@Id
	private Long id;
	private String itemName;
	private double itemPrice;
	private double subTotal;
	private String source;
	private String transactionType;	
	private String transactionDate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	public double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	@Override
	public String toString() {
		return "DailyExpense [id=" + id + ", itemName=" + itemName + ", itemPrice=" + itemPrice + ", subTotal="
				+ subTotal + ", source=" + source + ", transactionType=" + transactionType + ", transactionDate="
				+ transactionDate + "]";
	}
	public DailyExpense() {
		
	}
	public DailyExpense(Long id, String itemName, double itemPrice, double subTotal, String source,
			String transactionType, String transactionDate) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.subTotal = subTotal;
		this.source = source;
		this.transactionType = transactionType;
		this.transactionDate = transactionDate;
	}
	
	
	
}
