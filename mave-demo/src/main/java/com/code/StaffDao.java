package com.code;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.scene.control.Label;

public class StaffDao {
	public String getIme() {
		return ime;
	}
	public String getGrad() {
		return grad;
	}
	public String getAdres() {
		return adres;
	}
	public String getTelefon() {
		return telefon;
	}
	public String getEmail() {
		return email;
	}
	public String getSalary() {
		return salary;
	}

	public int getId1() {
		return id1;
	}
	public String getName() {
		return name;
	}
	public String ime;
	public String grad;
	public String adres;
	public String telefon;
	public String email;
	public String salary;
	public int id1;
	public String name;
	public StaffDao(String ime, String grad, String adres, String telefon, String email, String salary,String name,
			int id1) {
		super();
		this.ime = ime;
		this.grad = grad;
		this.adres = adres;
		this.telefon = telefon;
		this.email = email;
		this.salary = salary;
		this.name=name;
		this.id1 = id1;
	}
	
	public static boolean insert(String ime,String grad,String adres,String telefon,String email,String salary,String name,Label label1,boolean flag) {
		   try {
			 Connection com= DostavchikDao.getConnection();
				Statement st=com.createStatement();
				ResultSet rs=st.executeQuery("Insert into staff (staff_fullname,staff_city,staff_address,staff_phone,staff_email,staff_salary,pos_id) values ('"+ime+"','"+grad+"','"+adres+"','"+telefon+"','"+email+"','"+salary+"',(Select pos_id from position where pos_name='"+name+"'))");
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
				ResultSet rs=st.executeQuery("Delete from staff where staff_id='"+id1+"'");
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
	public static boolean update(String ime,String grad,String adres,String telefon,String email,String salary,int id1,Label label1,boolean flag) {
		   try {
			 Connection com= DostavchikDao.getConnection();
				Statement st=com.createStatement();
				ResultSet rs=st.executeQuery("update staff set staff_fullname='"+ime+"',staff_city='"+grad+"',staff_address='"+adres+"',staff_phone='"+telefon+"',staff_email='"+email+"',staff_salary='"+salary+"' where staff_id='"+id1+"'");
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
	public static boolean insert1(String name,Label label1,boolean flag) {
		   try {
			 Connection com= DostavchikDao.getConnection();
				Statement st=com.createStatement();
				ResultSet rs=st.executeQuery("Insert into position (pos_name) values ('"+name+"')");
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
				ResultSet rs=st.executeQuery("Select pos_name from position where pos_name='"+name+"'");
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
	
}
