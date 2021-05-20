/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.quiz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


/**
 *
 * @author anuja
 */
public class QuestionService {
    
//static Statement stmt=null;
 File file;   
  static int score=0;
// static Connection con=null;
    
    public static int getLastQuestionID(){
        Statement stmt=null;
        Connection con=null;
         int questionId=-1;
    try {
        
         con = connection();
         stmt=con.createStatement();
        ResultSet rs= stmt.executeQuery("select max(Question_ID) from questions");
        
        if(rs.next()){
            questionId=rs.getInt("max(Question_ID)");
        }
        //  questnIDFld.setText(String.valueOf(questionId+1));
    } catch (SQLException ex) {
        Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
    }
   
     return questionId; 
        }
         
   
    

 //************************************************************************//   
    public static void addQuestion(Question question){
         connection();
      Statement stmt=null;
      Connection con=null;
        
        String query="Insert into questions(Questions,Option1,Option2,Option3,Option4,Right_Option)" + " VALUES('"+question.getQuestion()+"','"+question.getOption1()+"','"+question.getOption2()+"','"+question.getOption3()+"','"+question.getOption4()+"','"+question.getRightAnswer()+"')";
        System.out.println(query);
    try {
        stmt.executeUpdate(query);
    } catch (SQLException ex) {
        Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
    }
       }
       
         
    
        
 //******************************************************************************//        
     public static void deleteQuestion(String[] idsToDelete){
         
         String query=null;
         Statement stmt=null;
         Connection con=null;
            con= connection();
     
        for(String question:idsToDelete)
        {
             try {
                 stmt=con.createStatement();
                 query = "delete from questions where Questions='"+question+"'";
                 try {
                     stmt.executeUpdate(query);
                 } catch (SQLException ex) {
                     Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 System.out.println(query);
             } catch (SQLException ex) {
                 Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
   
       }
      
        
   
     
//*******************************************************************************//         
     
     public static List<Question> searchQuestion(Question question){
         List<Question> questions = null;
        try {
            Statement stmt=null;
            Connection con=null;
            ResultSet resultSet;
            con=connection();
           
            stmt=con.createStatement();
            String query = "select* from questions where ";
            if(question.getQuestionId()!=0){
                query = query +  "Question_ID="+question.getQuestionId()+" OR ";
            }
            if(question.getQuestion().length()>0)
            {
                 query = query +  "Questions LIKE'%"+question.getQuestion()+"%'"+" OR ";
            }
            if(question.getOption1().length()>0){
                query = query +  "Option1 LIKE'%"+question.getOption1()+"%'"+" OR ";
            }
            if(question.getOption2().length()>0){
                query = query +  "Option2 LIKE'%"+question.getOption2()+"%'"+" OR ";
            }
            if(question.getOption3().length()>0){
                query = query +  "Option3 LIKE'%"+question.getOption3()+"%'"+" OR ";
            }
            if(question.getOption4().length()>0){
                query = query +  "Option4 LIKE'%"+question.getOption4()+"%'"+" OR ";
            }
           //  String newQuery =null;
            if(query.endsWith("OR ")){
               //query= query.replace("OR", "");
                query=query.substring(0,query.lastIndexOf("OR"));
               
               
            }
            if(query.endsWith("where ")){
               // query=query.replace("where", "");
               query=query.substring(0,query.lastIndexOf("where"));
                
            }
            
            System.out.println("========"+query);
              resultSet=stmt.executeQuery(query);
                 
                  questions=  resultShow(resultSet);
            
           
        }
           /* if(question.getQuestionId()==0&&question.getQuestion().isEmpty()&&question.getOption1().isEmpty()&&question.getOption2().isEmpty()&&question.getOption4().isEmpty()&&question.getOption3().isEmpty()){
                try {
                    String query2="select* from questions";
                    System.out.println(query2);
                    
                    resultSet=stmt.executeQuery(query2);
                  questions=  resultShow(resultSet);
                } catch (SQLException ex) {
                    Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            else if(question.getQuestion().isEmpty()&&question.getOption1().isEmpty()&&question.getOption2().isEmpty()&&question.getOption4().isEmpty()&&question.getOption3().isEmpty()){
                try {
                    String query1="select* from questions where Question_ID="+question.getQuestionId();
                    System.out.println(query1);
                    resultSet=stmt.executeQuery(query1);
                   questions= resultShow(resultSet);
                } catch (SQLException ex) {
                    Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            else if(question.getQuestionId()>0&&question.getOption1().isEmpty()&&question.getOption2().isEmpty()&&question.getOption4().isEmpty()&&question.getOption3().isEmpty()){
                try {
                    String query1="select* from questions where Questions LIKE'%"+question.getQuestion()+"%'";
                    System.out.println(query1);
                    resultSet=stmt.executeQuery(query1);
                     questions=resultShow(resultSet);
                } catch (SQLException ex) {
                    Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(question.getQuestionId()>0&&question.getQuestion().isEmpty()&&question.getOption2().isEmpty()&&question.getOption4().isEmpty()&&question.getOption3().isEmpty()){
                try {
                    String query1="select* from questions where Option1 LIKE'%"+question.getOption1()+"%'";
                    System.out.println(query1);
                    resultSet=stmt.executeQuery(query1);
                     questions=resultShow(resultSet);
                } catch (SQLException ex) {
                    Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(question.getQuestionId()>0&&question.getQuestion().isEmpty()&&question.getOption1().isEmpty()&&question.getOption4().isEmpty()&&question.getOption3().isEmpty()){
                try {
                    String query1="select* from questions where Option2 LIKE'%"+question.getOption2()+"%'";
                    System.out.println(query1);
                    resultSet=stmt.executeQuery(query1);
                    questions= resultShow(resultSet);
                } catch (SQLException ex) {
                    Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(question.getQuestionId()>0&&question.getQuestion().isEmpty()&&question.getOption1().isEmpty()&&question.getOption4().isEmpty()&&question.getOption2().isEmpty()){
                try {
                    String query1="select* from questions where Option3 LIKE'%"+question.getOption3()+"%'";
                    System.out.println(query1);
                    resultSet=stmt.executeQuery(query1);
                    questions= resultShow(resultSet);
                } catch (SQLException ex) {
                    Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(question.getQuestionId()>0&&question.getQuestion().isEmpty()&&question.getOption1().isEmpty()&&question.getOption3().isEmpty()&&question.getOption2().isEmpty()){
                try {
                    String query1="select* from questions where Option4 LIKE'%"+question.getOption4()+"%'";
                    System.out.println(query1);
                    resultSet=stmt.executeQuery(query1);
                    questions= resultShow(resultSet);
                } catch (SQLException ex) {
                    Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } */catch (SQLException ex) {
            Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
        }
         return questions;
         
     }   
//*****************************************************************************************//      
      
     
      
     public static List<Question> resultShow(ResultSet resultSet){
         List<Question> questions = new ArrayList<Question>();
        try {
            while(resultSet.next())
            {
                
                try {
                      Question question = new Question();
                      question.setQuestionId(resultSet.getInt("Question_ID"));
                      question.setQuestion(resultSet.getString("Questions"));
                      question.setOption1(resultSet.getString("Option1"));
                       question.setOption2( resultSet.getString("Option2"));
                       question.setOption3(resultSet.getString("Option3"));
                       question.setOption4(resultSet.getString("Option4"));
                       question.setRightAnswer(resultSet.getString("Right_Option"));
                       questions.add(question);
                   // System.out.println();
                  //  String iD = String.valueOf(resultSet.getString("Question_ID"));
                   // String question = resultSet.getString("Questions");
                   // String option1 = resultSet.getString("Option1");
                    /*String option2 = resultSet.getString("Option2");
                    String option3 = resultSet.getString("Option3");
                    String option4= resultSet.getString("Option4");
                    String rightOption = resultSet.getString("Right_Option");*/
                  
                 //   SearchTableIF search=new SearchTableIF();
                //    search.result(iD, question, option1,option2,option3,option4,rightOption);
                    // SearchTableIF searchTable=new SearchTableIF();
                    
                } catch (SQLException ex) {
                    Logger.getLogger(SearchTableIF.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }} catch (SQLException ex) {
            Logger.getLogger(SearchTableIF.class.getName()).log(Level.SEVERE, null, ex);
        }
        return questions;
    }
         
//**********************************************************************************//
     public static Connection connection(){
          Connection con=null;
  //  Statement stmt=null;
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("LOADED");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
        System.out.println("Connerction established");
       
    }
     catch(NumberFormatException z){
             System.out.println(z);
         }
      catch(ClassNotFoundException e)
            {
                System.out.println(e);
                System.out.println("###################");

            }
            catch(SQLException f)
            {
                System.out.println(f);
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!");
           
            }
    /*finally{
        try{
            if(con!=null)
        con.close();
        }catch(SQLException q){
            System.out.println(q);
        }*/
    
     
     return con;
}
     //******************************************************************************************
     public static ArrayList<AnswerableQuestion>  getQuestionsOfTest(int numberOfQuestn){
          ArrayList<AnswerableQuestion> list=null;
          Connection con=null;
         Statement stmt=null;
    try {
        con=connection();
         list=new ArrayList<AnswerableQuestion>();
         System.out.println("Numbr of questn are"+numberOfQuestn);
        String query="select* from questions order by RAND() limit "+numberOfQuestn;
        stmt=con.createStatement();
        ResultSet resultSet=stmt.executeQuery(query);
        AnswerableQuestion answerableQuestion=new AnswerableQuestion();
        while(resultSet.next()){
            try {
                String question= resultSet.getString("Questions");
                System.out.println(resultSet.getString("Questions"));
                String questionID=resultSet.getString("Question_ID");
                String option1=resultSet.getString("Option1");
                String option2=resultSet.getString("Option2");
                String option3=resultSet.getString("Option3");
                String option4=resultSet.getString("Option4");
                String rightAnswer=resultSet.getString("Right_Option");
                answerableQuestion.setQuestionId(Integer.parseInt(questionID));
                answerableQuestion.setQuestion(question);
                answerableQuestion.setOption1(option1);
                answerableQuestion.setOption2(option2);
                answerableQuestion.setOption3(option3);
                answerableQuestion.setOption4(option4);
                answerableQuestion.setRightAnswer(rightAnswer);
                System.out.println("option 1 is "+answerableQuestion.getOption1());
                list.add(answerableQuestion);
            } catch (SQLException ex) {
                Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
         
                
        
    } catch (SQLException ex) {
        Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
     }
 ///*******************************************************************************************
     public static void updateQuestion(Question questions){
        try {
            Statement stmt=null;
            Connection con=null;
            con=connection();
            stmt=con.createStatement();
           
            
           // SearchTableIF searchTable=new SearchTableIF();
            
                        String query = "update questions set Questions='"+questions.getQuestion()+"',Option1='"+questions.getOption1()+"',Option2='"+questions.getOption2()+"',Option3='"+questions.getOption3()+"',Option4='"+questions.getOption4()+"',Right_Option='"+questions.getRightAnswer()+"'WHERE Question_ID="+questions.getQuestionId();
                        System.out.println(query);
                        stmt.executeUpdate(query);
                    } catch (SQLException ex) {
                        Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                
                
                
             
     }
 //************************************************************************************//    
     public static String count(){
         String count=null;
        try {
            Statement stmt=null;
            Connection con=null;
            con=connection();
            String query="select count(*) from questions";
            System.out.println(query);
            stmt=con.createStatement();
            ResultSet resultSet=stmt.executeQuery(query);
            resultSet.next();
             count=String.valueOf(resultSet.getInt(1));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
        }
         return count;
     }
//*************************************************************************************//     
     public  void  readCsvFile(){
        
         String[] word=null;
            Connection con=null;
            Statement stmt=null;
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("Driver Loaded");
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
                System.out.println("connection established");
                stmt=con.createStatement();
                String query="Insert into questions (Questions,Option1,Option2,Option3,Option4,Right_Option)" + " VALUES(?,?,?,?,?,?)";
                PreparedStatement statement=con.prepareStatement(query);
                BufferedReader reader=new BufferedReader(new FileReader("C:/Self Practice/Demo.csv"));
                String newLine;
                while ((newLine = reader.readLine()) != null) {

                    word=newLine.split(",");
                    //String QuestionID=word[0];
                    String Question=word[0];
                    String Option1=word[1];
                    String Option2=word[2];
                    String Option3=word[3];
                    String Option4=word[4];
                    String RightOption=word[5];
                    //statement.setString(1, QuestionID);
                    statement.setString(1, Question);
                    statement.setString(2, Option1);
                    statement.setString(3, Option2);
                    statement.setString(4, Option3);
                    statement.setString(5, Option4);
                    statement.setString(6, RightOption);

                   
                        statement.execute();

                       

                }
                reader.close();
                con.close();

            }catch(ClassNotFoundException e)
            {
                System.out.println(e);

            }
            catch(SQLException f)
            {
                System.out.println(f);

            }
            catch(FileNotFoundException g)
            {
                System.out.print(g);

            }
            catch(IOException h)
            {
                System.out.print(h);
            }
     }
 //************************************************************************************//    
     public void readJsonFile(){
          JSONParser jsonParser = new JSONParser();
      try {
        
         JSONArray jsonArray=(JSONArray) jsonParser.parse(new FileReader("C:/Self Practice/question.json"));
        
          DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
     
      String mysqlUrl = "jdbc:mysql://localhost/project";
      Connection con = DriverManager.getConnection(mysqlUrl, "root", "root");
      System.out.println("Connection established......");
       
         PreparedStatement pstmt = con.prepareStatement("INSERT INTO questions values (?, ?, ?, ?, ?, ?, ?)");
         for(Object object : jsonArray) {
            JSONObject record = (JSONObject) object;
           
            String id = (String) record.get("QuestionID");
            String question = (String) record.get("Question");
            String option1 = (String) record.get("Option1");
            String option2 = (String) record.get("Option2");
            String option3 = (String) record.get("Option3");
            String option4 = (String) record.get("Option4");
            String rightOption=(String) record.get("Right_Option");
            
            pstmt.setString(1, id);
            pstmt.setString(2, question);
            pstmt.setString(3, option1);
            pstmt.setString(4, option2);
            pstmt.setString(5, option3);
             pstmt.setString(6, option4);
             pstmt.setString(7, rightOption);
           
            pstmt.executeUpdate();
         }  
         System.out.println("Records inserted.....");
      } catch (FileNotFoundException e) {
         System.out.println(e);
      } catch (IOException f) {
          System.out.println(f);
      } catch (ParseException z) {
          System.out.println(z);
      } catch (Exception c) {
         
          System.out.println(c);
      }
     }
     
     public static int getFinalScore(AnswerableQuestion question){
         String rightOption=null;
        
          try {
             Statement stmt=null;
             Connection con=null;
            con= QuestionService.connection();
            stmt=con.createStatement();
             //Question question=new Question();
             String query="select Right_Option from questions where Question_ID="+ question.getQuestionId();
             System.out.println(query);
             ResultSet rs= stmt.executeQuery(query);
             if(rs.next()){
              rightOption=rs.getString("Right_Option");
              System.out.println("Right Option is"+rs.getString("Right_Option"));
              
             }
             
             if(question.getUserSelectedAnswer().equals(rightOption)){
                 System.out.println("HURAYYYYYY");
                 score=score+1;
                 System.out.println("Socre is "+score);
             }
             else{
                 System.out.println("AWWWWW wrong");
             }
        }
          catch (SQLException ex) {
              System.out.println("!!!!!!!!!!!!!!!");
             Logger.getLogger(TestFrame.class.getName()).log(Level.SEVERE, null, ex);
         }
          return score;
     }
}



            
        
    

