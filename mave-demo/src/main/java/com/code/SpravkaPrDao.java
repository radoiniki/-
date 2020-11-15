package com.code;

public class SpravkaPrDao {
	
public String getProfit() {
		return profit;
	}
	public String getIncome() {
		return income;
	}
	public String getCosts() {
		return costs;
	}
String profit;
String income;
String costs;
public SpravkaPrDao(String profit, String income, String costs) {
	super();
	this.profit = profit;
	this.income = income;
	this.costs = costs;
}

}
