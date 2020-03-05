import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.ThreadLikeSelect;
import bean.Thread_Bean;


public class SearchThreadServlet extends HttpServlet{
	public void doPost(HttpServletRequest req , HttpServletResponse res)throws IOException,ServletException{
		req.setCharacterEncoding("utf-8");

		String title=req.getParameter("title");
		ThreadLikeSelect tls = new ThreadLikeSelect();
		ArrayList threadList=tls.getThread(title);
		req.setAttribute("threadList",threadList);

		RequestDispatcher dis = req.getRequestDispatcher("c_thread.jsp");
		dis.forward(req , res);

	}
}
