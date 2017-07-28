import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
@WebServlet("/MyServlet")  

public class MyServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        try {
           response.setContentType("text/html");
     
        PrintWriter out = response.getWriter();  
          
        String n=request.getParameter("username");  
        //out.print("hello"+n); 
          
        HttpSession session=request.getSession();  
        session.setAttribute("hello",n);  
         response.sendRedirect("Welcome");
    //out.print("<a href='Welcome'>welcome</a>");  
      out.close();  
        } 
        catch(Exception e){System.out.println(e);}  
        }
    }
