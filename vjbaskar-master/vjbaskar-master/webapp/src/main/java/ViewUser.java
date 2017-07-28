import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet(name="ViewUser" , urlPatterns="/ViewUser")  
public class ViewUser extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<a href='welcome.jsp'>Add New User</a>");  
        out.println("<h1>User List</h1>");  
          
        List<EventPojo> list=EventCrud.getAllUser();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>FirstName</th><th>Lastname</th><th>Email</th><th>Date</th><th>Time</th><th>Topic</th><th>Topic</th></tr>");  
        for(EventPojo e:list)
        {  
         out.print("<tr><td>"+e.getfirstname()+"</td><td>"+e.getlastname()+"</td><td>"+e.getemail()+"</td><td>"+e.getdate()+"</td><td>"+e.gettime()+"</td><td>"+e.gettopic()+"</td><td>"+e.getlocation()+"</td></tr>");  
        }  
        out.print("</table>");  
          
        out.close();  
    }  
}  