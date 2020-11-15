package com.code;

public class SpravkaDostDao {
public String getDate() {
		return date;
	}
	public String getSupname() {
		return supname;
	}
	public int getWprice() {
		return wprice;
	}
	public int getWtotal() {
		return wtotal;
	}
	public String getStockname() {
		return stockname;
	}
	public String getQuantity() {
		return quantity;
	}
String date;
String supname;
int wprice;
int wtotal;
String stockname;
String quantity;
public SpravkaDostDao(String date, String supname, int wprice, int wtotal, String stockname, String quantity) {
	super();
	this.date = date;
	this.supname = supname;
	this.wprice = wprice;
	this.wtotal = wtotal;
	this.stockname = stockname;
	this.quantity = quantity;
}


}
