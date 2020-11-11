package com.code;

import javafx.scene.control.Label;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DostavchikDao {
	 
	public DostavchikDao(String string, String string2, String string3, String string4, String string5,int integer) {
		super();
		this.ime1=string;
		this.grad1=string2;
		this.adres1=string3;
		this.telefon1=string4;
		this.email1=string5;
		this.id1=integer;
	}
	public  String getIme1() {
		return ime1;
	}
	public  String getGrad1() {
		return grad1;
	}
	public String getAdres1() {
		return adres1;
	}
	public  String getTelefon1() {
		return telefon1;
	}
	public  String getEmail1() {
		return email1;
	}
	public  int getId1() {
		return id1;
	}
	public String ime1;
	public String grad1;
	public String adres1;
	public String telefon1;
	public String email1;
	public int id1;
	public static Connection getConnection() {
		Connection com = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 com = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","JAVA","JAVA");
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		return com;
		}
public static boolean insert(String ime1,String grad1,String adres1,String telefon1,String email1,Label label1,boolean flag) {
	   try {
		 Connection com= getConnection();
			Statement st=com.createStatement();
			ResultSet rs=st.executeQuery("Insert into suppliers (sup_name,sup_city,sup_address,sup_phone,sup_email) values ('"+ime1+"','"+grad1+"','"+adres1+"','"+telefon1+"','"+email1+"')");
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
		 Connection com= getConnection();
			Statement st=com.createStatement();
			ResultSet rs=st.executeQuery("Delete from suppliers where sup_id='"+id1+"'");
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
public static boolean update(String ime1,String grad1,String adres1,String telefon1,String email1,int id1,Label label1,boolean flag) {
	   try {
		 Connection com= getConnection();
			Statement st=com.createStatement();
			ResultSet rs=st.executeQuery("update suppliers set sup_name='"+ime1+"',sup_city='"+grad1+"',sup_address='"+adres1+"',sup_phone='"+telefon1+"',sup_email='"+email1+"' where sup_id='"+id1+"'");
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
