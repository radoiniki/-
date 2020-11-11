package com.code;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainFromDao {
public static String stocks() {
	String a = "";
	 try {
	 Connection com= DostavchikDao.getConnection();
		Statement st=com.createStatement();
		ResultSet rs=st.executeQuery("Select sum(st_quantity) from stocks");
		if (rs.next())  {
		 a=rs.getString("sum(st_quantity)");
		}
	 }
		 catch (Exception e)
 		{
 	System.out.println(e);
 		}

return a;

}
public static String pari() {
	String a = "";
	 try {
	 Connection com= DostavchikDao.getConnection();
		Statement st=com.createStatement();
		ResultSet rs=st.executeQuery("Select sum(money_profit) from moneydesk");
		if (rs.next())  {
		 a=rs.getString("sum(money_profit)");
		}
	 }
		 catch (Exception e)
 		{
 	System.out.println(e);
 		}

return a;

}
}
