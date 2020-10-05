package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import exception.OracleConnectionException;

public class Oracle_Connection{
  public static Connection getConnection(String name,String pass){
    Connection cn = null;
    try{
      Class.forName("oracle.jdbc.driver.OracleDriver");
      cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",name,pass);
    }catch(ClassNotFoundException e){
      System.out.println(e.getMessage());
    }catch(SQLException e){
    	throw new OracleConnectionException();
    }catch(Exception e){
      System.out.println(e.getMessage());
    }

    return cn;
  }
}
