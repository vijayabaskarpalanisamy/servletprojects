import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.sql.*;
import connection.DB_connect;
import connection.DB_connect.*;
@WebServlet("/edit")
public class Edit extends HttpServlet
{
     
     static String Fullname,Email,Place;
    static  Connection conn=DB_connect.getCon();
            public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
            {
                String Fullname=req.getParameter("Fullname");
                String Email=req.getParameter("Email");
                String Place=req.getParameter("Place");
               
                PrintWriter p=res.getWriter();
                res.setContentType("text/html");
                //p.println(Fullname);
                  Edit.update();
               p.println("<html>"+"<head>"+"<body>");
               p.println("<form action='show' method='GET'>");
                p.println("name:<input type='text'>");
                 p.println("<input type='submit'"+ "value='update'>");
                 p.println("</form>"+"</body>"+"</head>"+"</html>");
                   
            }
            public static void update()
{
    try
    {
        PreparedStatement ps=conn.prepareStatement("update Register set Fullname=? where Fullname="+Fullname);
       ps.setString(1,Fullname);
       ps.executeUpdate();
      
        
    }
    catch(Exception ex)
    {
        ex.printStackTrace();
    }
}
}