import java.sql.*;  
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;

@WebServlet("/LoginDao")
    public class LoginDao {  
    public static boolean validate(String uname,String password){  
    boolean status=false;  
    try{  
    Class.forName("com.mysql.jdbc.Driver");  
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost/Employee","root","");  
    PreparedStatement ps=con.prepareStatement("select* from Login where uname=? and password=?");
    ps.setString(1,uname);
    ps.setString(2,password);     
    ResultSet rs=ps.executeQuery();  
    status=rs.next();   
              
    }catch(Exception e){System.out.println(e);}  
    return status;  
    }  
    }  