import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Res_Servlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		req.setCharacterEncoding("utf-8");

		String st_thread_id = req.getParameter("thread_id");
		System.out.println("st_thread_id="+st_thread_id);
		String st_res_id = req.getParameter("res_id");
		OperatorCaller caller= (OperatorCaller)DBFactory.getInstance("caller");
		ArrayList threadList = caller.selectResA(st_thread_id);
		ArrayList resList = caller.selectResB(st_thread_id, st_res_id);

		System.out.println("1=");
		req.setAttribute("threadList",threadList);
		req.setAttribute("thread_id",st_thread_id);
		//ArrayList resList = rs.getRes(st_thread_id,st_res_id);
		System.out.println("1=");
		req.setAttribute("resList",resList);

		RequestDispatcher dis = req.getRequestDispatcher("c_res.jsp");

		dis.forward(req,res);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		this.doGet(req,res);
	}
}
