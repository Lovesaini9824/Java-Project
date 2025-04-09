package bank.management.sys;
import java.sql.*;
public class Conn {
    
    Connection c;
    Statement s;
    public Conn(){
        try {
           
//            Class.forName(com.mysql.cj.jdbc.Driver);    Register the driver...
             // Create connection
            c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root", "2004");  //connection string---jdbc:mysql:///bankmanagementsystem","root", "2004"
            s=c.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}


//steps for jdbc connection.....
//1.) Register The driver
//2.) Create Connection
//3.) Create Statement
//4.) Execute Query