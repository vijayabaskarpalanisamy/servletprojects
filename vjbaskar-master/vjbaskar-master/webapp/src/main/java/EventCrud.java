import java.lang.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.util.*;
import java.sql.*;
public class EventCrud
{
    public static Connection getConnection()
    {
    Connection con=null;
    try
    {
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost/event","root","");
    }catch(Exception e)
    {
        e.printStackTrace();
    }
    return con;
}

     public static List<EventPojo> getAllUser(){  
        List<EventPojo> list=new ArrayList<EventPojo>();  
          
        try{  
            Connection con=EventCrud.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from eventform");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
            EventPojo e=new EventPojo();  
               
                  e.setlastname(rs.getString(2));  
                e.setemail(rs.getString(3));  
                e.setdate(rs.getString(4));  
                e.setfirstname(rs.getString(1));  
                e.settime(rs.getString(5)); 
                e.settopic(rs.getString(6)); 
                e.setlocation(rs.getString(7)); 
                
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  public static int delete(String firstname){  
        int status=0;  
        try{  
            Connection con=EventCrud.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from eventform where firstname=?");  
            ps.setString(1,firstname);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }
    public static EventPojo getEmployeeById(String firstname){  
        EventPojo e=new EventPojo();  
          
        try{  
            Connection con=EventCrud.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from eventform where firstname=?");  
            ps.setString(1,firstname);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setlastname(rs.getString(2));  
                e.setemail(rs.getString(3));  
                e.setdate(rs.getString(4));  
                e.setfirstname(rs.getString(1));  
                e.settime(rs.getString(5)); 
                e.settopic(rs.getString(6)); 
                e.setlocation(rs.getString(7)); 
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }
     public static int update(EventPojo e){  
        int status=0;  
        try{  
            Connection con=EventCrud.getConnection();  
            PreparedStatement ps=con.prepareStatement("update eventform set lastname=?,email=?,date=?,time=?,topic=?,location=? where firstname=?");
            
         ps.setString(1,e.getlastname());  
            ps.setString(2,e.getemail());  
            ps.setString(3,e.getdate());  
            ps.setString(4,e.gettime());
                ps.setString(5,e.gettopic());
                  ps.setString(6,e.getlocation());
                    ps.setString(7,e.getfirstname());

            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
  
}  


