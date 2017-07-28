import java.io.*;  
import java.sql.*;  
import java.sql.Connection;
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
import javax.servlet.annotation.*; 
import connection.DB_connect;
import javax.servlet.RequestDispatcher;
@WebServlet("/Add")
public class Add extends HttpServlet
{
 
     public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
        {  
            try
                {  
   // PrintWriter pw=response.getWriter();
  //  response.setContentType("text/html");
 //  pw.println("hello");
      response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        String Fullname=request.getParameter("Fullname");
        String Email=request.getParameter("Email");
        String Place=request.getParameter("Place");
        pw.println(Fullname);



}
catch (Exception ex) 
{
    System.out.println(ex);
}  
        }
}