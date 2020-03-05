package database;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;  //実行するためのもの

import java.util.ArrayList;

import bean.Thread_Bean;

public class ThreadLikeSelect{
	public ArrayList getThread(String title){
		ArrayList<Thread_Bean> threadList = new ArrayList<Thread_Bean>();
		try{
			Connection cn = Oracle_Connection.getConnection("kingofC","takato114514");  //送っている
			cn.setAutoCommit(false);
			System.out.println("接続完了");
			String sql ="SELECT * FROM thread_table WHERE title LIKE '%"+title+"%'";
			Statement st = cn.createStatement();
			ResultSet rs =st.executeQuery(sql);
			while(rs.next()){
				String thread_id = rs.getString(1);
				String t_title = rs.getString(2);
				String t_name = rs.getString(3);
				String t_contents = rs.getString(4);
				String name = rs.getString(5);
				String thread_time = rs.getString(6);
				Thread_Bean tb = new Thread_Bean();
				tb.setThread_id(thread_id);
				tb.setTitle(t_title);
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
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return threadList;
	}
}
