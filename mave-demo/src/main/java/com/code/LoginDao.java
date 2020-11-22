package com.code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;


public class LoginDao extends MainForm{
	public Connection getConnection() {
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
	public boolean validateLogin(String username1,String password1,Label label,boolean flag) {
		try{
			Connection com= getConnection();
			Statement st=com.createStatement();
			ResultSet rs=st.executeQuery("SELECT *FROM user1 WHERE username='"+username1+"' AND password='"+password1+"'");
			if (rs.next())  
    		{
    			label.setText("Logged in!");
    			flag=true;   			
    		}
    		else {
    			Alert a = new Alert(AlertType.INFORMATION);
     	    	a.setContentText("Wrong username or password!");
     	    	a.show();
    			flag=false;
            }
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		return flag;
	
	}
	public boolean validateLogin1(String username1,String password1,boolean flag) {
		if(username1.equals("admin") && password1.contentEquals("admin"))
		{
    		flag=true;   			
    	}
		else {
			flag=false;
        }
		return flag;
		}
	


}

