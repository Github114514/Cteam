import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lib.Avoidance;
import database.Res_Insert;

public class CreateRes_Servlet extends HttpServlet{
  public void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException,ServletException{
    req.setCharacterEncoding("utf-8");

    String res_name = Avoidance.TextAvoidance(req.getParameter("name"));
    String res_contents = Avoidance.TextAvoidance(req.getParameter("contents"));
    String thread_id = req.getParameter("st_thread_id");
    String res_id = req.getParameter("st_res_id");
    System.out.println(thread_id);
    Res_Insert ri = new Res_Insert();
    ri.insertRes(res_id,thread_id,res_name,res_contents);

    res.sendRedirect("Res_Servlet?thread_id="+thread_id);
  }

  public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException {
    this.doPost(req,res);
  }
}
