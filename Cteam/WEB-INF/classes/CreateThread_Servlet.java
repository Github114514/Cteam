import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;

import lib.Avoidance;
import database.Thread_Insert;

@MultipartConfig(maxFileSize=1040008576)
public class CreateThread_Servlet extends HttpServlet{
  @Override
  public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{

    req.setCharacterEncoding("utf-8");

    Part part = req.getPart("name");
		String name = this.getFileName(part);
        System.out.println("name"+name);
		if(!name.equals("")){
			part.write("C:/Cteam/img/" + name);
		}

    String title =  Avoidance.TextAvoidance(req.getParameter("title"));
    String t_name =  Avoidance.TextAvoidance(req.getParameter("t_name"));
    String t_contents =  Avoidance.TextAvoidance(req.getParameter("contents"));
    Thread_Insert ti = new Thread_Insert();
    ti.insertThread(title,t_name,t_contents,name);
    res.sendRedirect("Thread_Servlet");
  }
  private String getFileName(Part part) {
        String name = null;
        for (String dispotion : part.getHeader("Content-Disposition").split(";")) {
            if (dispotion.trim().startsWith("filename")) {
                name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
                name = name.substring(name.lastIndexOf("\\") + 1);
                break;
            }
        }
        System.out.println(name);
        System.out.println("アップロード完了");
        return name;
    }

  public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
    this.doPost(req,res);
  }
}
