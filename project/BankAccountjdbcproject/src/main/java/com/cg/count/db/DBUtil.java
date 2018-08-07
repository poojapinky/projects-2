package com.cg.count.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.cg.count.exception.AccountException;

public class DBUtil {
	public static Connection getConnection() throws AccountException{
		//String url="jdbc:oracle:thin:@localhost:1521:schedule";
		String url="jdbc:mysql://localhost:3306/jpa1";
		try{
		//Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(url,"root","root");
		}catch(ClassNotFoundException e){
		throw new AccountException(e.getMessage());
		}catch(SQLException e1){
		throw new AccountException(e1.getMessage());
		}
		}
}
