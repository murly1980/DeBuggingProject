/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testproject;
import java.sql.*;
/**
 *
 * @author anuja
 */
public class SqlConnection {
    public static void main(String[] args)
            
    {
        Connection con=null;
        Statement stmt=null;
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/officeinfo","root","root");
            System.out.println("connection established");
            stmt=con.createStatement();
            int a=99;
            String name="Ajay";
            String query="INSERT INTO newemployeerecord" +
                    " VALUES(3,"+a+",'"+name+"',222)";
            
            stmt.executeUpdate(query);
            
             query="INSERT INTO newemployeerecord"+
                    " VALUES(4,97,'Kanishk',221)";
           
            stmt.executeUpdate(query);
            
            System.out.println("Record inserted");
        }
        catch(ClassNotFoundException e)
        {
            System.out.println(e);
        }
        catch(SQLException f)
        {
            System.out.println(f);
        }
        try{
        con.close();
        }catch(SQLException i)
        {
            System.out.println(i);
        }
    }
    
}
