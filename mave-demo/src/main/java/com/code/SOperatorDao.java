package com.code;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.scene.control.Label;

public class SOperatorDao {
	public String getName() {
		return name;
	}
	public String getCity() {
		return city;
	}
	public String getAdress() {
		return adress;
	}
	public String getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getOpid() {
		return opid;
	}
	String name;
	String city;
	String adress;
	String phone;
	String email;
	String username;
	String password;
	String opid;
	public SOperatorDao(String name, String city, String adress, String phone, String email, String username,
			String password,String opid) {
		super();
		this.name = name;
		this.city = city;
		this.adress = adress;
		this.phone = phone;
		this.email = email;
		this.username = username;
		this.password = password;
		this.opid=opid;
	}
	public static boolean insert(String ime1,String grad1,String adres1,String telefon1,String email1,Label label1,boolean flag) {
		   try {
			 Connection com= DostavchikDao.getConnection();
				Statement st=com.createStatement();
				ResultSet rs=st.executeQuery("Insert into warehouse_operator (op_fullname,op_city,op_address,op_phone,op_email) values ('"+ime1+"','"+grad1+"','"+adres1+"','"+telefon1+"','"+email1+"')");
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
	public static boolean insert1(String username,String password,String email,Label label1,boolean flag) {
		   try {
			 Connection com= DostavchikDao.getConnection();
				Statement st=com.createStatement();
				ResultSet rs=st.executeQuery("Insert into user1 (username,password,op_id) values ('"+username+"','"+password+"',(Select op_id from warehouse_operator where op_email='"+email+"'))");
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
	public static boolean selectusername(String username,Label label1,boolean flag) {
		   try {
			 Connection com= DostavchikDao.getConnection();
				Statement st=com.createStatement();
				ResultSet rs=st.executeQuery("Select username from user1");
				if (rs.next())  
				{
				    label1.setText("this username is used from another operator! Please choose another one !");
				    flag=true;
				}else {
					label1.setText("Not selected");
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
				ResultSet rs=st.executeQuery("Delete from warehouse_operator where op_id='"+id1+"'");
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
				ResultSet rs=st.executeQuery("Delete from user1 where op_id='"+id1+"'");
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
				ResultSet rs=st.executeQuery("update warehouse_operator set op_fullname='"+ime1+"',op_city='"+grad1+"',op_address='"+adres1+"',op_phone='"+telefon1+"',op_email='"+email1+"' where op_id='"+id1+"'");
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
	public static boolean update1(String username,String password,int id1,Label label1,boolean flag) {
		   try {
			 Connection com= DostavchikDao.getConnection();
				Statement st=com.createStatement();
				ResultSet rs=st.executeQuery("update user1 set username='"+username+"',password='"+password+"' where op_id='"+id1+"'");
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
