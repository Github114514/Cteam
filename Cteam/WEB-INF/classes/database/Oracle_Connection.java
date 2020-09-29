package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ip.OracleConnectionException;

public class Oracle_Connection{
  public static Connection getConnection(String name,String pass)throws OracleConnectionException{
    Connection cn = null;
    try{
      Class.forName("oracle.jdbc.driver.OracleDriver");
      cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",name,pass);
    }catch(ClassNotFoundException e){
      System.out.println(e.getMessage());
    }catch(SQLException e){
    	throw new OracleConnectionException(e.getMessage(), e);
    }catch(Exception e){
      System.out.println(e.getMessage());
    }

    //if(cn==null)
		//throw new NoContentException("",null);

    return cn;
  }
}
