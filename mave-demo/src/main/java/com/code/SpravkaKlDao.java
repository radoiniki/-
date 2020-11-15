package com.code;

public class SpravkaKlDao {
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
	public String getClname() {
		return clname;
	}
String date;
String supname;
int wprice;
int wtotal;
String stockname;
String quantity;
String clname;
public SpravkaKlDao(String date, String supname, int wprice, int wtotal, String stockname, String quantity, String clname) {
	super();
	this.date = date;
	this.supname = supname;
	this.wprice = wprice;
	this.wtotal = wtotal;
	this.stockname = stockname;
	this.quantity = quantity;
	this.clname=clname;
}


}
