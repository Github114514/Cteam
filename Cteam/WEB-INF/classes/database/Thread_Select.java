package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.Thread_Bean;
import exception.OracleConnectionException;

public class Thread_Select extends DBOperator{
  public ArrayList getThread(){
    ArrayList<Thread_Bean> threadList=new ArrayList<Thread_Bean>();
    try{
      Connection cn = Oracle_Connection.getConnection("kingofC","takato114514");
      cn.setAutoCommit(false);
      System.out.println("接続完了");
      String sql="select * from thread_table order by thread_id";
      Statement st = cn.createStatement();
	  ResultSet rs =st.executeQuery(sql);
      while(rs.next()){
		String thread_id = rs.getString(1);
		String title = rs.getString(2);
		String t_name = rs.getString(3);
		String t_contents = rs.getString(4);
		String name = rs.getString(5);
		String thread_time = rs.getString(6);

		Thread_Bean tb = new Thread_Bean();
        tb.setThread_id(thread_id);
        tb.setTitle(title);
        tb.setT_name(t_name);
        tb.setT_contents(t_contents);
        tb.setName(name);
        tb.setThread_time(thread_time);
        threadList.add(tb);
      }
      st.close();
      cn.commit();
      cn.close();
    }catch(SQLException e){
    	e.printStackTrace();
    }catch (Exception e) {
    	throw new OracleConnectionException();
    }
    return threadList;
  }
}
