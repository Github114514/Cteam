package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Res_Insert{
  public void insertRes(String res_id,String thread_id,String name,String contents){
    try{
      Connection cn = Oracle_Connection.getConnection("kingofC","takato114514");
      cn.setAutoCommit(false);
      System.out.println("接続完了");
      String sql = "insert into res_table(res_id, thread_id, res_name, res_contents)values(res_sequence.nextval, '"+thread_id+"','"+name+"','"+contents+"')";
      System.out.println(sql);
      Statement st = cn.createStatement();
      int count = st.executeUpdate(sql);
      System.out.println(count+"件処理されました");
      st.close();
      cn.commit();
      cn.close();
    }catch(SQLException e){
      System.out.println(e.getMessage());
      e.printStackTrace();
    }catch(Exception e){
      System.out.println(e.getMessage());
    }
  }
}
