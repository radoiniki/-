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
	public int getCorderid() {
		return corderid;
	}


String stockname;
String date;
String staffname;
int priceorder;
int quantity;
int priceeach;
String ordername;
String clname;
int corderid;

public PklientDao(String stockname, String date, String staffname, int priceorder, int quantity, int priceeach,
		String ordername, String clname,int corderid) {
	super();
	this.stockname = stockname;
	this.date = date;
	this.staffname = staffname;
	this.priceorder = priceorder;
	this.quantity = quantity;
	this.priceeach = priceeach;
	this.ordername = ordername;
	this.clname = clname;
	this.corderid = corderid;
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
public static boolean insert1(String stockname,String ordername, int quantity,int priceeach,Label label1,boolean flag) {
	Integer p=quantity*priceeach;
	String price=p.toString();
	   try {
		 Connection com= DostavchikDao.getConnection();
			Statement st=com.createStatement();
			ResultSet rs=st.executeQuery("Insert into corder_price(stocks_st_id,client_orders_corder_id,quantity,price_each,price) values ((Select st_id from stocks where st_name='"+stockname+"'),(Select corder_id from client_orders where corder_name='"+ordername+"'),'"+quantity+"','"+priceeach+"','"+price+"')");
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
			ResultSet rs=st.executeQuery("Select corder_name from client_orders where corder_name='"+name+"'");
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
			ResultSet rs=st.executeQuery("Delete from client_orders where corder_id='"+id1+"'");
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
			ResultSet rs=st.executeQuery("Delete from corder_price where client_orders_corder_id='"+id1+"'");
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
public static boolean update(String date,String clname, String staffname,String priceorder,String ordername,int id1,Label label1,boolean flag) {
	   try {
		 Connection com= DostavchikDao.getConnection();
			Statement st=com.createStatement();
			ResultSet rs=st.executeQuery("update client_orders set corder_date='"+date+"',cl_id=(Select cl_id from clients where cl_name='"+clname+"'),corder_total='"+priceorder+"',corder_name='"+ordername+"' where corder_id='"+id1+"'");
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
			ResultSet rs=st.executeQuery("update corder_price set stocks_st_id=(Select st_id from stocks where st_name='"+stockname+"'),quantity='"+quantity+"',price_each='"+priceeach+"',price='"+price+"' where client_orders_corder_id='"+id1+"'");
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
			ResultSet rs=st.executeQuery("update stocks set st_quantity=st_quantity-'"+quantity+"' where st_id=(Select stocks_st_id from corder_price where client_orders_corder_id=(Select corder_id from client_orders where corder_name='"+wordername+"'))");
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
public static boolean updatemoney(String priceorder,Label label1,boolean flag) {
	   try {
		 Connection com= DostavchikDao.getConnection();
			Statement st=com.createStatement();
			ResultSet rs=st.executeQuery("update moneydesk set money_income=money_income+'"+priceorder+"' where money_id='"+1+"'");
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
public static boolean updatemoney1(String name,Label label1,boolean flag) {
	   try {
		 Connection com= DostavchikDao.getConnection();
			Statement st=com.createStatement();
			ResultSet rs=st.executeQuery("update moneydesk set money_income=money_income+(Select price from corder_price where client_orders_corder_id=(Select corder_id from client_orders where corder_name='"+name+"')) where money_id='"+1+"'");
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
public static boolean updatekasa(Label label1,boolean flag) {
	 try {
		 Connection com= DostavchikDao.getConnection();
			Statement st=com.createStatement();
			ResultSet rs=st.executeQuery("update moneydesk set money_profit=money_income-money_costs where money_id='"+1+"'");
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
