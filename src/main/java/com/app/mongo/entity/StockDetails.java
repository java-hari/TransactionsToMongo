package com.app.mongo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "stock_details")
public class StockDetails {

	@Id
	private Integer itemId;
	private String itemName;
	private double itemPrice;	
	private String itemType;
	private Integer itemInstock;
	
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
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
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public Integer getItemInstock() {
		return itemInstock;
	}
	public void setItemInstock(Integer itemInstock) {
		this.itemInstock = itemInstock;
	}
	
	
}
