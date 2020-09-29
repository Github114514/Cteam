import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Thread_Servlet extends HttpServlet{
  public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException,ServletException{
    req.setCharacterEncoding("utf-8");
    OperatorCaller caller= (OperatorCaller)DBFactory.getInstance("caller");
    ArrayList threadList = caller.selectThread();
    req.setAttribute("threadList", threadList);
    RequestDispatcher dis = req.getRequestDispatcher("c_thread.jsp");
    dis.forward(req , res);
  }
  public void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException,ServletException{
    this.doGet(req,res);
  }
}
