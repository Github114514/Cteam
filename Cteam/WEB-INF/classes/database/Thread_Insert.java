
package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.Part;

public class Thread_Insert{
	public void insertThread(String title,String t_name,String contents,String name){
		try{
			Connection cn = Oracle_Connection.getConnection("kingofC","takato114514");
			cn.setAutoCommit(false);
			System.out.println("接続完了");
			String sql ="insert into Thread_table " +
			"(thread_id , title , t_name , t_contents , name ) " +
			"values(thread_sequence.nextval,'"+title+"','"+t_name+"','"+contents+"','"+name+"')";
			System.out.println("name"+name);
			Statement st = cn.createStatement();
			int count =st.executeUpdate(sql);
			System.out.println(count+"件処理されました");
			st.close();
			cn.commit();
			cn.close();
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
