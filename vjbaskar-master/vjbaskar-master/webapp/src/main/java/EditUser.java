import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/EditUser")  
public class EditUser extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
           throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Update User</h1>");  
        String semail=request.getParameter("firstname");  
          
        EventPojo e=EventCrud.getEmployeeById(semail);  
          
        out.print("<form action='UpdateUser' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td>FirstName:</td><td><input type='text' name='firstname' value='"+e.getfirstname()+"'/></td></tr>");  
        out.print("<tr><td>LastName:</td><td><input type='password' name='lastname' value='"+e.getlastname()+"'/></td></tr>");  
        out.print("<tr><td>Email:</td><td><input type='hidden' name='email' value='"+e.getemail()+"'/></td></tr>"); 
        out.print("<tr><td>Date:</td><td><input type='text' name='date' value='"+e.getdate()+"'/></td></tr>"); 
        out.print("<tr><td>Time:</td><td><input type='text' name='time' value='"+e.gettime()+"'/></td></tr>"); 
        out.print("<tr><td>Topic:</td><td><input type='text' name='topic' value='"+e.gettopic()+"'/></td></tr>"); 
        out.print("<tr><td>Location:</td><td><input type='text' name='location' value='"+e.getlocation()+"'/></td></tr>"); 
        out.print("<tr><td colspan='2'><input type='submit' value='update '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
    }  
} 