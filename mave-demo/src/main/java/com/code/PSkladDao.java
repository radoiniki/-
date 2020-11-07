package com.code;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.scene.control.Label;

public class PSkladDao {
	public String getStockid() {
		return stockid;
	}

	public String getQuantity() {
		return quantity;
	}

	public String getPriceeach() {
		return priceeach;
	}

	public String getDate() {
		return date;
	}

	public int getSupname() {
		return supname;
	}


	public int getPriceorder() {
		return priceorder;
	}


	public String getOrdername() {
		return ordername;
	}
	public int getWorderid() {
		return worderid;
	}

	public String date;
	public int supname;
	public int priceorder;
	public String ordername;
	public int worderid;
	
	public PSkladDao(String date, int supname, int priceorder, String ordername,int worderid,String stockid, String quantity, String priceeach) {
		super();
		this.date = date;
		this.supname = supname;
		this.priceorder = priceorder;
		this.ordername = ordername;
		this.worderid = worderid;
		this.stockid = stockid;
		this.quantity = quantity;
		this.priceeach = priceeach;
	}
	public String stockid;
	public String quantity;
	public String priceeach;
	public static boolean insert(String date,String supname, String priceorder, String ordername,Label label1,boolean flag) {
		   try {
			 Connection com= DostavchikDao.getConnection();
				Statement st=com.createStatement();
				ResultSet rs=st.executeQuery("Insert into warehouse_orders(worder_date,sup_id,worder_total,worder_name) values ('"+date+"',(Select sup_id from suppliers where sup_name='"+supname+"'),'"+priceorder+"','"+ordername+"')");
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
	public static boolean insert1(String stockname,String wordername, String quantity, String priceeach,Label label1,boolean flag) {
		Integer p=Integer.parseInt(quantity)*Integer.parseInt(priceeach);
		String price=p.toString();
		   try {
			 Connection com= DostavchikDao.getConnection();
				Statement st=com.createStatement();
				ResultSet rs=st.executeQuery("Insert into worder_price(stocks_st_id,warehouse_orders_worder_id,w_quantity,w_price_each,w_price) values ((Select st_id from stocks where st_name='"+stockname+"'),(Select worder_id from warehouse_orders where worder_name='"+wordername+"'),'"+quantity+"','"+priceeach+"','"+price+"')");
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

	public static boolean select(String name,Label label1,boolean flag) {
		   try {
			 Connection com= DostavchikDao.getConnection();
				Statement st=com.createStatement();
				ResultSet rs=st.executeQuery("Select worder_name from warehouse_orders where worder_name='"+name+"'");
				if (rs.next())  
				{
				    label1.setText("Insert");
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
	public static boolean delete(int id1,Label label1,boolean flag) {
		   try {
			 Connection com= DostavchikDao.getConnection();
				Statement st=com.createStatement();
				ResultSet rs=st.executeQuery("Delete from warehouse_orders where worder_id='"+id1+"'");
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
	public static boolean delete1(int id1,Label label1,boolean flag) {
		   try {
			 Connection com= DostavchikDao.getConnection();
				Statement st=com.createStatement();
				ResultSet rs=st.executeQuery("Delete from worder_price where warehouse_orders_worder_id='"+id1+"'");
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
	public static boolean update(String date,String supname, String priceorder, String ordername,int id1,Label label1,boolean flag) {
		   try {
			 Connection com= DostavchikDao.getConnection();
				Statement st=com.createStatement();
				ResultSet rs=st.executeQuery("update warehouse_orders set worder_date='"+date+"',sup_id=(Select sup_id from suppliers where sup_name='"+supname+"'),worder_total='"+priceorder+"',worder_name='"+ordername+"' where worder_id='"+id1+"'");
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
	public static boolean update1(String stockname, String quantity, String priceeach,int id1,Label label1,boolean flag) {
		Integer p=Integer.parseInt(quantity)*Integer.parseInt(priceeach);
		String price=p.toString();
		   try {
			 Connection com= DostavchikDao.getConnection();
				Statement st=com.createStatement();
				ResultSet rs=st.executeQuery("update worder_price set stocks_st_id=(Select st_id from stocks where st_name='"+stockname+"'),w_quantity='"+quantity+"',w_price_each='"+priceeach+"',w_price='"+price+"' where warehouse_orders_worder_id='"+id1+"'");
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
	public static boolean update2(String quantity,String wordername,Label label1,boolean flag) {
		   try {
			 Connection com= DostavchikDao.getConnection();
				Statement st=com.createStatement();
				ResultSet rs=st.executeQuery("update stocks set st_quantity=st_quantity+'"+quantity+"' where st_id=(Select stocks_st_id from worder_price where warehouse_orders_worder_id=(Select worder_id from warehouse_orders where worder_name='"+wordername+"'))");
				if (rs.next())  
				{
				    label1.setText("Updated");
				    flag=true;
				}else {
					label1.setText("Not Updated");
					flag=false;
				}
				 com.setAutoCommit(false);
			   	}
			    catch (Exception e)
			    		{
			    	System.out.println(e);
			    		}
		
		return flag;
	}
	
}