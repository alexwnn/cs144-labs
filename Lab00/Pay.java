/******************************************************
 Lab Assignment 00

 Name: Alex Nguyen  
 Course/Semester: CS 144 Spring 24
 Class Section: 01
 Lab section: L02
 Sources consulted: __________
 Comments for grader:  _________
*******************************************************/

//This program calculates the user's gross pay

import java.util.Scanner;

public class Pay {
    public static void main(String [] args) {

        Scanner keyboard = new Scanner(System.in);

        double hours;
        double rate = 15.0;
        double pay;

        System.out.print("How many hours did you work");
        hours = keyboard.nextDouble();

        if(hours <= 40)
            pay = hours * rate;
        else 
            pay = (hours - 40) * (1.5 * rate) + 40 * rate;

            System.out.println("You earned $" + pay);


    }
}