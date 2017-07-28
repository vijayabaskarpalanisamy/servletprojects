import java.io.*;  
import java.sql.*;  
import java.sql.Connection;
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
import javax.servlet.annotation.*; 
import connection.DB_connect;
import javax.servlet.RequestDispatcher;
@WebServlet("/delete")
public class Delete extends HttpServlet
{
   Connection con=DB_connect.getCon(); 
     public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
        {  
            try
                {  
    PrintWriter pw=response.getWriter();
    response.setContentType("text/html");

    
    String name1=request.getParameter("id");
PreparedStatement st=con.prepareStatement("delete from Register where Firstname=?");
st.setString(1,name1);

int r=st.executeUpdate();
}
catch (Exception ex) 
{
    System.out.println(ex);
}  
        }
}