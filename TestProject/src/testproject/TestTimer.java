/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testproject;

/**
 *
 * @author anuja
 */
import java.awt.event.*;
import javax.swing.*;
public class TestTimer {
    static public void main(String [] args) {
try{
ActionListener ticktock = new ActionListener() {
public void actionPerformed(ActionEvent evnt) {
System.out.println("Swing timer started"); //display of this message is basically an action which is associated with swing timer until timer stops
}
};
Timer timer = new Timer(555 ,ticktock); //timer is ticking
timer.setRepeats(false); //by using this, we are asking to off timer once
timer.start();
Thread.sleep(5555);
System.out.println("Timeout"); //timer ends and this message is displayed
} catch (InterruptedException expn) {
}
}
}
