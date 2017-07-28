import java.io.*;  
import java.sql.*;  
import java.sql.Connection;
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
import javax.servlet.annotation.*; 
import connection.DB_connect;
@WebServlet("/show")
public class Table extends HttpServlet
 {
     Connection con=DB_connect.getCon(); 
     public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
        {  
            try
                {  
    PrintWriter pw=response.getWriter();
    response.setContentType("text/html");
   String name=request.getParameter("name");
    Statement st=con.createStatement();
    ResultSet r=st.executeQuery("select * from Register");
        pw.println("<table border=3>");
        while(r.next())
        {
            String url="<a href=edit?Fullname="+r.getString(1)+"&"+"Email="+r.getString(2)+"&"+"Place="+r.getString(3)+">Edit</a>";
            pw.println("<tr><td>"+r.getString("Fullname")+"</td><td>"+r.getString("Email")+"</td><td>"+r.getString("Place")+"</td><td>"+"<a href=delete?id="+r.getString(1)+">Delete</a>"+"</td><td>"+url);
        }
        pw.println("</table>");
        pw.close();
}
catch (Exception ex) 
{
    System.out.println(ex);
}  
          
}  
  
 }