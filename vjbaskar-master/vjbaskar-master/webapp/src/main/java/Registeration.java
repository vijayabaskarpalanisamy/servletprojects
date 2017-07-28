import java.io.IOException;  
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.ServletException;  
import javax.servlet.http.*;

@WebServlet(name= "Registeration", urlPatterns= "/Registeration")
public class Registeration extends HttpServlet
{
        String driver_name="com.mysql.jdbc.Driver";
        String driver_url="jdbc:mysql://localhost/";
        String db_name="event";
        String user_name="root";
        String password="";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          response.setContentType("text/html");  

        try
        {
            Class.forName(driver_name);
            Connection con=DriverManager.getConnection(driver_url+db_name,user_name,password);
            PrintWriter out = response.getWriter(); 
           String firstname=request.getParameter("firstname");  
        String lastname=request.getParameter("lastname");  
        String date=request.getParameter("date");  
        String email=request.getParameter("email");  
        String time=request.getParameter("time");  
        String topic=request.getParameter("topic");  
        String location=request.getParameter("location");  

            String query="INSERT INTO eventform(firstname,lastname,email,date,time,topic,location) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement e=con.prepareStatement(query);

            e.setString(1,firstname);  
        e.setString(2,lastname);  
        e.setString(4,date);  
        e.setString(3,email);  
         e.setString(5,time);  
          e.setString(6,topic);  
           e.setString(7,location);  
            e.executeUpdate();
            
            out.println(user_name);
            out.print("<br><h1>Your details registered successfully</h1><br>"); 
            RequestDispatcher rs=request.getRequestDispatcher("welcome.jsp");  
            rs.include(request, response);
           // response.sendRedirect("welcome.jsp");

        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
}