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
 import java.lang.*;
public class SubStringDemo {
   


public static void main(String[] args) {
String str = "This is tutorials point";
String substr = "";

// prints the substring after index 8 till index 17
substr = str.substring(8, 17);
System.out.println("substring = " + substr);

// prints the substring after index 0 till index 8
substr = str.substring(0, 8);
System.out.println("substring = " + substr);
}

    
}
