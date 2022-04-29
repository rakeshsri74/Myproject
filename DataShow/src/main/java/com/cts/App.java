package com.cts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/adm21jf034";
			String user = "root";
			String password = "root";
			
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			
			String query = "select * from emp";
			
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getInt("age"));
			}
			
		}catch(ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		finally {
			try {
			rs.close();
			stmt.close();
			conn.close();
			}catch(SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}

    }
}
