package database;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Date;

import bean.Thread_Bean;
import bean.Res_Bean;

public class Res_Select{

  public ArrayList getThread(String thread_id){
    ArrayList< Thread_Bean > threadList = new ArrayList< Thread_Bean >();
    try{
      Connection cn = Oracle_Connection.getConnection("kingofC","takato114514");
      cn.setAutoCommit(false);
      System.out.println("");

      String sql = "select * from thread_table where thread_id='"+thread_id+"'";
      Statement st = cn.createStatement();
      ResultSet rs = st.executeQuery(sql);
      while(rs.next()){
        rs.getString(1);
				String title = rs.getString(2);
				String t_name = rs.getString(3);
				String t_contents = rs.getString(4);
        String name = rs.getString(5);
				String thread_time = rs.getString(6);
        System.out.println("thread_id="+thread_id);
        System.out.println("t_name="+t_name);
        System.out.println("t_contents="+t_contents);
        System.out.println("thread_time="+thread_time);
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
        System.out.println(e.getMessage());
        e.printStackTrace();
      }catch(Exception e){
        System.out.println(e.getMessage());
      }
    return threadList;
  }

  public ArrayList getRes(String thread_id,String res_id){
    ArrayList< Res_Bean > resList = new ArrayList< Res_Bean >();

    try{
      Connection cn = Oracle_Connection.getConnection("kingofC","takato114514");
      cn.setAutoCommit(false);
      System.out.println("");

      String sql = "select * from res_table where thread_id='"+thread_id+"' order by res_time";
      Statement st = cn.createStatement();
      ResultSet rs = st.executeQuery(sql);
      while(rs.next()){
        res_id = rs.getString(1);
        thread_id = rs.getString(2);
        String res_name = rs.getString(3);
        String res_contents = rs.getString(4);
        String res_time = rs.getString(5);
        System.out.println("res_id="+res_id);
        System.out.println("thread_id="+thread_id);
        System.out.println("res_name="+res_name);
        System.out.println("res_contents="+res_contents);
        System.out.println("res_time="+res_time);
        Res_Bean rb = new Res_Bean();
        rb.setRes_id(res_id);
        rb.setThread_id(thread_id);
        rb.setRes_name(res_name);
        rb.setRes_contents(res_contents);
        rb.setRes_time(res_time);
        resList.add(rb);
      }
      st.close();
      cn.commit();
      cn.close();
    }catch(SQLException e){
      System.out.println(e.getMessage());
      e.printStackTrace();
    }catch(Exception e){
      System.out.println(e.getMessage());
    }
    return resList;
  }
}
