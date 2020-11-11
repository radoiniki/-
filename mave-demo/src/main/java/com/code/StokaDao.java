package com.code;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class StokaDao {
	 
	public int getQuantity() {
		return quantity;
	}

	public StokaDao(int quantity, String ime1, String expDate1, int id1) {
		super();
		this.quantity = quantity;
		this.ime1 = ime1;
		this.expDate1 = expDate1;
		this.id1 = id1;
	}

	public  String getIme1() {
		return ime1;
	}
	public  String getExpDate1() {
		return expDate1;
	}
	public  int getId1() {
		return id1;
	}

	public int quantity;
	public String ime1;
	public String expDate1;
	public int id1;
public static boolean insert(String ime1,String expDate1,int quantity,Label label1,boolean flag) {
	   try {
		 Connection com= DostavchikDao.getConnection();
			Statement st=com.createStatement();
			ResultSet rs=st.executeQuery("Insert into stocks (st_name,st_expdate,st_quantity) values ('"+ime1+"','"+expDate1+"','"+quantity+"')");
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
public static boolean delete(int id1,Label label1,boolean flag) {
	   try {
		 Connection com= DostavchikDao.getConnection();
			Statement st=com.createStatement();
			ResultSet rs=st.executeQuery("Delete from stocks where st_id='"+id1+"'");
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
static Parent root1 ;

public static void close() {
	((Stage)root1.getScene().getWindow()).close(); 
}
public static boolean update(String ime1,String expDate1,int quantity,int id1,Label label1,boolean flag) {
	   try {
		 Connection com= DostavchikDao.getConnection();
			Statement st=com.createStatement();
			ResultSet rs=st.executeQuery("update stocks set st_name='"+ime1+"',st_expdate='"+expDate1+"',st_quantity='"+quantity+"' where st_id='"+id1+"'");
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
public static boolean select(String ime1,Label label1,boolean flag) {
	try {
		 Connection com= DostavchikDao.getConnection();
			Statement st=com.createStatement();
			ResultSet rs=st.executeQuery("Select st_name from stocks where st_name='"+ime1+"'");
			if (rs.next())  
			{
			    label1.setText("There is the name called: "+ime1);
			    flag=true;
			}else {
				label1.setText("You can insert");
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
