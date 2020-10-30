package com.code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.scene.control.Label;


public class LoginDao {
	protected static Connection getConnection() {
	Connection com=null;

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
	public static boolean validateLogin(String username1,String password1,Label label,boolean flag) {
		try{
			Connection com= getConnection();
			Statement st=com.createStatement();
			ResultSet rs=st.executeQuery("SELECT *FROM userv1 WHERE username='"+username1+"' AND password='"+password1+"'");
			if (rs.next())  
    		{
    			label.setText("Logged in!");
    			flag=true;   			
    		}
    		else {
    			label.setText("Check username and password!");
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
