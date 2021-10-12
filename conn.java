
package bank.management.system;
import java.sql.*;
public class conn {
    Connection c;
    Statement s;
    public conn(){
        try{
                Class.forName("com.mysql.cj.jdbc.Driver");//This is my Driver Class
                c= DriverManager.getConnection("jdbc:mysql://localhost:3306/project2","root","");//Connection URl to get connection with database
                s = c.createStatement();
//                c.close();
        }catch(Exception e){
            System.out.println(e);
        } 
    }
}
