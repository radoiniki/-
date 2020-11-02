package com.code;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class StokaDao {
	 
	public StokaDao(String string, String string2,int integer) {
		ime1=string;
		expDate1=string2;
		id1=integer;
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
	public String ime1;
	public String expDate1;
	public int id1;
public static boolean insert(String ime1,String expDate1,Label label1,boolean flag) {
	   try {
		 Connection com= DostavchikDao.getConnection();
			Statement st=com.createStatement();
			ResultSet rs=st.executeQuery("Insert into stocks (st_name,st_expdate) values ('"+ime1+"','"+expDate1+"')");
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
public static boolean update(String ime1,String expDate1,int id1,Label label1,boolean flag) {
	   try {
		 Connection com= DostavchikDao.getConnection();
			Statement st=com.createStatement();
			ResultSet rs=st.executeQuery("update stocks set st_name='"+ime1+"',st_expdate='"+expDate1+"' where st_id='"+id1+"'");
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
