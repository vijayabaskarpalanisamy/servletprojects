import java.io.IOException;
import java.io.PrintWriter;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
@WebServlet("/Register")
public class Register extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        String Fullname=request.getParameter("Fullname");
        String Email=request.getParameter("Email");
        String Place=request.getParameter("Place");
         try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Symposium", "root", "");
            Statement st = conn.createStatement();
            String sql="insert into Register(Fullname,Email,Place)values(?,?,?)";
            PreparedStatement pr=conn.prepareStatement(sql);
            pr.setString(1,Fullname);
            pr.setString(2,Email);
            pr.setString(3,Place);
            int result=pr.executeUpdate();
            ResultSet rs = st.executeQuery("Select * from Register");

            pw.println("<table border=1>");
            while (rs.next()) {
                 String url="<a href=edit?Fullname="+rs.getString(1)+"&"+"Email="+rs.getString(2)+"&"+"Place="+rs.getString(3)+">Edit</a>";
    pw.println("<tr><td>" + rs.getString(1) + "<td>" + rs.getString(2)  + "<td>" + rs.getString(3)+"</tr>"+"<a href=delete?id="+rs.getString(1)+">Delete</a>"+"</td><td>"+url);
        } 
                  
            pw.println("</table>");
            pw.close();
            pw.println("hello");
 }
        catch(Exception e)
        {
             e.printStackTrace();
        }
    }
}