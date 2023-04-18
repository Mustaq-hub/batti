package com.battisapi.BattiTradingAPI.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	private static Connection connection=null;
	
	public static Connection getConnection() throws SQLException {
		if(connection!=null)
		{
			return connection;
		}else {
			String driver="com.mysql.cj.jdbc.Driver";
			String url="jdbc:mysql://a2nlmysql11plsk.secureserver.net:3306/ph10977507853_btc";
			String user="btc";
			String password="Giri@7676";
			
			try {
				Class.forName(driver);
				connection=DriverManager.getConnection(url,user,password);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		return connection;
	}

}
