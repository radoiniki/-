package com.code;

import javafx.scene.control.Label;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class ClientDao {
	 
	public ClientDao(String string, String string2, String string3, String string4, String string5,int integer) {
		ime1=string;
		grad1=string2;
		adres1=string3;
		telefon1=string4;
		email1=string5;
		id1=integer;
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
public static boolean insert(String ime1,String grad1,String adres1,String telefon1,String email1,Label label1,boolean flag) {
	   try {
		 Connection com= DostavchikDao.getConnection();
			Statement st=com.createStatement();
			ResultSet rs=st.executeQuery("Insert into clients (cl_name,cl_city,cl_address,cl_phone,cl_email) values ('"+ime1+"','"+grad1+"','"+adres1+"','"+telefon1+"','"+email1+"')");
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
			ResultSet rs=st.executeQuery("Delete from clients where cl_id='"+id1+"'");
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
		 Connection com= DostavchikDao.getConnection();
			Statement st=com.createStatement();
			ResultSet rs=st.executeQuery("update clients set cl_name='"+ime1+"',cl_city='"+grad1+"',cl_address='"+adres1+"',cl_phone='"+telefon1+"',cl_email='"+email1+"' where cl_id='"+id1+"'");
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
