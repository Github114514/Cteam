import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import ip.OracleConnectionException;


public class Thread_Servlet extends HttpServlet{
  public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException,ServletException{
	ArrayList threadList = null;
	req.setCharacterEncoding("utf-8");
    OperatorCaller caller= (OperatorCaller)DBFactory.getInstance("caller");
    System.out.print("ここまで動いてる");
    threadList = caller.selectThread();
    System.out.print("ここまで動いてる２");
    req.setAttribute("threadList", threadList);
    RequestDispatcher dis = req.getRequestDispatcher("c_thread.jsp");
    System.out.print("ここまで動いてる３");
    dis.forward(req , res);
  }
  public void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException,ServletException{
    this.doGet(req,res);
  }
}
