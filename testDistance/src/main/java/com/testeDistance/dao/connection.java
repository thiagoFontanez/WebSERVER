package com.testeDistance.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {
	public static String status = "connecting wait a moment";

	public connection() {

	}

public static java.sql.Connection getConexaoMySQL() {
      Connection connection = null;      
try {

String driverName = "com.mysql.jdbc.Driver";                        

Class.forName(driverName);

          String serverName = "localhost:3306";
          String mydatabase = "distanceCity";
          String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
          String username = "root";      
          String password = "";
          connection = DriverManager.getConnection(url, username, password);


          if (connection != null) {
        	  System.out.println("STATE ---> Connected successfully! ");
          } else {
        	  System.out.println("STATUS ---> Could not connect");
          }
          return connection;
      } catch (ClassNotFoundException e) {  
          System.out.println("Specified driver could not be found.");
          return null;
      } catch (SQLException e) {
          System.out.println("Could not connect to database.");
          return null;

      }
  }

	public static String statusConection() {
		return status;
	}

	public static boolean FecharConexao() {
		try {
			connection.getConexaoMySQL().close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	public static java.sql.Connection ReiniciarConexao() {
		FecharConexao();
		return connection.getConexaoMySQL();
	}

}
