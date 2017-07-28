import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;  
@WebServlet("/Admin")
public class Admin extends HttpServlet {  
public void doGet(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
  
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
          
        out.print("welcome ADMIN");  
        out.close();  
    }  
}  