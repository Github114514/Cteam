package database;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class Oracle_Connection{
  public static Connection getConnection(String name,String pass){
    Connection cn = null;
    try{
      Class.forName("oracle.jdbc.driver.OracleDriver");
      cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",name,pass);
    }catch(ClassNotFoundException e){
      System.out.println(e.getMessage());
    }catch(SQLException e){
      System.out.println(e.getMessage());
    }catch(Exception e){
      System.out.println(e.getMessage());
    }

    return cn;
  }
}
