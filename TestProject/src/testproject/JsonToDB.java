/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testproject;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;

public class JsonToDB {
   public static Connection ConnectToDB() throws Exception {
      //Registering the Driver
      DriverManager.registerDriver(new com.mysql.jdbc.Driver());
      //Getting the connection
      String mysqlUrl = "jdbc:mysql://localhost/officeinfo";
      Connection con = DriverManager.getConnection(mysqlUrl, "root", "root");
      System.out.println("Connection established......");
      return con;
   }
   public static void main(String args[]) {
      //Creating a JSONParser object
      JSONParser jsonParser = new JSONParser();
      try {
         //Parsing the contents of the JSON file
         //JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("C:/self practice/fruit.json"));
         JSONArray jsonArray=(JSONArray) jsonParser.parse(new FileReader("C:/Self Practice/fruit.json"));
         //Retrieving the array
         //JSONArray jsonArray = (JSONArray) jsonObject.get(jsonObject);
         Connection con = ConnectToDB();
         //Insert a row into the MyPlayers table
         PreparedStatement pstmt = con.prepareStatement("INSERT INTO fruits values (?, ?, ? )");
         for(Object object : jsonArray) {
            JSONObject record = (JSONObject) object;
           
            String fruit = (String) record.get("fruit");
            String size = (String) record.get("size");
            String color = (String) record.get("color");
            
            pstmt.setString(1, fruit);
            pstmt.setString(2, size);
            pstmt.setString(3, color);
           
            pstmt.executeUpdate();
         }  
         System.out.println("Records inserted.....");
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } catch (ParseException e) {
         e.printStackTrace();
      } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
}
