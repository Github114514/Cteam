//ビジネスロジック層
import java.util.ArrayList;

import database.DBOperator;

public class OperatorCaller{
	public void insertThread(String title,String t_name,String t_contents,String name){
	    DBOperator ti = (DBOperator)DBFactory.getInstance("threadInsert");
	    ti.insertThread(title,t_name,t_contents,name);
	}

	public void insertRes(String res_id,String thread_id,String res_name,String res_contents){
		DBOperator ri = (DBOperator)DBFactory.getInstance("resInsert");
	    ri.insertRes(res_id,thread_id,res_name,res_contents);
	}

	public ArrayList selectThread(){
		DBOperator ts = (DBOperator)DBFactory.getInstance("threadSelect");
		 ArrayList threadList = ts.getThread();
		return threadList;
	}

	public ArrayList selectResA(String st_thread_id){
		DBOperator rs = (DBOperator)DBFactory.getInstance("resSelect");
		ArrayList threadList = rs.getThreadR(st_thread_id);
		return threadList;
	}

	public ArrayList selectResB(String st_thread_id,String st_res_id){
		DBOperator rs = (DBOperator)DBFactory.getInstance("resSelect");
		ArrayList resList = rs.getRes(st_thread_id,st_res_id);
		return resList;
	}

	public ArrayList SelectThreadLike(){
		DBOperator tls = (DBOperator)DBFactory.getInstance("threadLikeSelect");
		ArrayList threadList = tls.getThread();
		 return threadList;
	}
}