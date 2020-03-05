import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Thread_Select;
import bean.Thread_Bean;


public class Thread_Servlet extends HttpServlet{
  public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException,ServletException{
    req.setCharacterEncoding("utf-8");
    Thread_Select ts =new Thread_Select();
    ArrayList threadList = ts.getThread();
    req.setAttribute("threadList", threadList);
    RequestDispatcher dis = req.getRequestDispatcher("c_thread.jsp");

    dis.forward(req , res);
  }
  public void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException,ServletException{
    this.doGet(req,res);
  }
}
