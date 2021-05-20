/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testproject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author anuja
 */
public class CsvToDb {
    public static void main(String[] args)
    {
        String[] word=null;
        Connection con=null;
        Statement stmt=null;
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/officeinfo","root","root");
            System.out.println("connection established");
            stmt=con.createStatement();
            String query="Insert into details" + " VALUES(?,?,?,?)";
            PreparedStatement statement=con.prepareStatement(query);
            BufferedReader reader=new BufferedReader(new FileReader("C:/Information.csv"));
            String newLine;
	    while ((newLine = reader.readLine()) != null) {
				
		 word=newLine.split(",");
                String Name=word[0];
                 String Email=word[1];
                 String PhoneNumber=word[2];
                 String Address=word[3];
                 statement.setString(1, Name);
                 statement.setString(2, Email);
                 statement.setString(3, PhoneNumber);
                 statement.setString(4, Address);
                        
			//for(int i=0;i<=word.length-1;i++)
			//{
			 /*   String Query="INSERT INTO details"+
                           " VALUES('"+Name+"','"+Email+"',"+PhoneNumber+",'"+Address+"')";*/
                           //  statement.executeUpdate(Query); 
                 statement.execute();
                              
			//}
                                
                }
            reader.close();
            con.close();
            
    }catch(ClassNotFoundException e)
        {
            System.out.println(e);
            System.out.println("aaaaaaaaaaa");
        }
        catch(SQLException f)
        {
            System.out.println(f);
            System.out.println("bbbbbbbbbbb");
        }
        catch(FileNotFoundException g)
		{
		   System.out.print(g);
                   System.out.println("cccccccccc");
		}
        catch(IOException h)
		{
		    System.out.print(h);
                    System.out.println("ddddddddddd");
		}
}
}
