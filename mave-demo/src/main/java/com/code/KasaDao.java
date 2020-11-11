package com.code;

import javafx.scene.control.Label;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class KasaDao {
	 
	public String getIncome() {
		return income;
	}
	public String getCosts() {
		return costs;
	}
	public String getDate() {
		return date;
	}
	public String getProfit() {
		return profit;
	}


	public KasaDao(String income, String costs, String date, String profit) {
		super();
		this.income = income;
		this.costs = costs;
		this.date = date;
		this.profit = profit;
	}


	public String income;
	public String costs;
	public String date;
	public String profit;
	public int id1;
public static boolean insert(String income,String costs, String date,Label label1,boolean flag) {
Double p=Double.parseDouble(income)-Double.parseDouble(costs);
String profit=p.toString();
	   try {
		 Connection com= DostavchikDao.getConnection();
			Statement st=com.createStatement();
			ResultSet rs=st.executeQuery("Insert into moneydesk (money_income,money_costs,money_profit,money_date,money_id) values ('"+income+"','"+costs+"','"+profit+"','"+date+"','"+1+"')");
			if (rs.next())  
			{
			    label1.setText("Inserted");
			    flag=true;
			}else {
				label1.setText("Not Inserted");
				flag=false;
			}
		   	}
		    catch (Exception e)
		    		{
		    	System.out.println(e);
		    		}
	return flag;
}
public static boolean delete(Label label1,boolean flag) {
	   try {
		 Connection com= DostavchikDao.getConnection();
			Statement st=com.createStatement();
			ResultSet rs=st.executeQuery("Delete from moneydesk where money_id='"+1+"'");
			if (rs.next())  
			{
			    label1.setText("Deleted");
			    flag=true;
			}else {
				label1.setText("Not Deleted");
				flag=false;
			}
		   	}
		    catch (Exception e)
		    		{
		    	System.out.println(e);
		    		}
	return flag;
}
public static boolean update(String income,String costs,String date,Label label1,boolean flag) {
	Double p=Double.parseDouble(income)-Double.parseDouble(costs);
	String profit=p.toString();
	   try {
		 Connection com= DostavchikDao.getConnection();
			Statement st=com.createStatement();
			ResultSet rs=st.executeQuery("update moneydesk set money_income='"+income+"',money_costs='"+costs+"',money_profit='"+profit+"',money_date='"+date+"' where money_id='"+1+"'");
			if (rs.next())  
			{
			    label1.setText("Updated");
			    flag=true;
			}else {
				label1.setText("Not Updated");
				flag=false;
			}
		   	}
		    catch (Exception e)
		    		{
		    	System.out.println(e);
		    		}
	return flag;
}

}
