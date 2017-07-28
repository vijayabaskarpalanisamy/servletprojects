

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;  
import java.util.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/LoginDB")
public class LoginDB extends HttpServlet{
    public  void  doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{

res.setContentType("text/html");
PrintWriter out=res.getWriter();

String n=req.getParameter("username");
String p=req.getParameter("userpass");

 if(LoginDao.validate(n, p)){  
    RequestDispatcher rd=req.getRequestDispatcher("Loginwelcome");
    rd.forward(req,res);
}else{
    out.print("Sorry Your password & username are wrong");
      RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
    rd.include(req,res);
}


out.close();


    }
}

 