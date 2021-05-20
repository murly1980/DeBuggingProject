/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.quiz;

/**
 *
 * @author anuja
 */
public class AnswerableQuestion extends Question {
    private String userSelectedAnswer;
    //private boolean correctAnswer;

    public boolean isCorrectAnswer() {
       // System.out.println("qwerty"+getUserSelectedAnswer());
       // System.out.println("qwerty"+getRightAnswer());
        return getUserSelectedAnswer().equals(getRightAnswer());
    }

  

    public String getUserSelectedAnswer() {
        return userSelectedAnswer;
    }

    public void setUserSelectedAnswer(String userSelectedAnswer) {
        this.userSelectedAnswer = userSelectedAnswer;
       
        
    }
    
}
