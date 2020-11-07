package com.code;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.scene.control.Label;

public class PklientDao {
public String getStockname() {
		return stockname;
	}

	public String getDate() {
		return date;
	}

	public String getStaffname() {
		return staffname;
	}

	public int getPriceorder() {
		return priceorder;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getPriceeach() {
		return priceeach;
	}

	public String getOrdername() {
		return ordername;
	}

	public String getClname() {
		return clname;
	}

String stockname;
String date;
String staffname;
int priceorder;
int quantity;
int priceeach;
String ordername;
String clname;

public PklientDao(String stockname, String date, String staffname, int priceorder, int quantity, int priceeach,
		String ordername, String clname) {
	super();
	this.stockname = stockname;
	this.date = date;
	this.staffname = staffname;
	this.priceorder = priceorder;
	this.quantity = quantity;
	this.priceeach = priceeach;
	this.ordername = ordername;
	this.clname = clname;
}
public static boolean insert(String date,String clname, String staffname,String priceorder,String ordername,Label label1,boolean flag) {
	   try {
		 Connection com= DostavchikDao.getConnection();
			Statement st=com.createStatement();
			ResultSet rs=st.executeQuery("Insert into client_orders(corder_date,cl_id,staff_id,corder_total,corder_name) values ('"+date+"',(Select cl_id from clients where cl_name='"+clname+"'),(Select staff_id from staff where staff_fullname='"+staffname+"'),'"+priceorder+"','"+ordername+"')");
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
}
