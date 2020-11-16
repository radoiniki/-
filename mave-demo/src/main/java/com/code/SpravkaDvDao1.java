package com.code;

public class SpravkaDvDao1 {
	public String getOrderprice() {
		return orderprice;
	}
	public String getStockprice() {
		return stockprice;
	}
	String orderprice;
	String stockprice;
	public SpravkaDvDao1(String orderprice, String stockprice) {
		super();
		this.orderprice = orderprice;
		this.stockprice = stockprice;
	}
	
}
