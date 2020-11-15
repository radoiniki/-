package com.code;

public class SpravkaNaDao {
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
public SpravkaNaDao(String costs, String profit, String income) {
	super();
	this.profit = profit;
	this.income = income;
	this.costs = costs;
}

}