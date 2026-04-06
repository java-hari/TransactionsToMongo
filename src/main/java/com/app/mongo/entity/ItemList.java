package com.app.mongo.entity;

import java.util.List;

//import javax.xml.bind.annotation.XmlRootElement;



//@XmlRootElement
public class ItemList {
	List<StockDetails> itemStockList;

	public List<StockDetails> getItemStockList() {
		return itemStockList;
	}

	public void setItemStockList(List<StockDetails> itemStockList) {
		this.itemStockList = itemStockList;
	}

	
}
