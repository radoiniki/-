package com.code;

public class SpravkaDvDao {

	public String getOrderprice() {
		return orderprice;
	}
	public String getStockprice() {
		return stockprice;
	}
	public String getSalary() {
		return salary;
	}
String orderprice;
String salary;
String stockprice;
public SpravkaDvDao( String orderprice, String stockprice) {
	super();
	this.orderprice = orderprice;
	this.stockprice = stockprice;
}
public SpravkaDvDao( String salary) {
	super();
	this.salary = salary;

}
}
