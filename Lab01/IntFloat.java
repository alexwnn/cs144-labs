/******************************************************
 Lab Assignment 02

 Name: ALEX NGUYEN
 Course/Semester: SPRING 2024
 Class Section: 01
 Lab section: 02
 Sources consulted: __________
 Comments for grader:  N/A
*******************************************************/

import java.util.Scanner;

public class IntFloat {
    public static void main(String[] args) {

        int num1;
        int num2;
        int num3;
        int num4;

        int productInt;
        int averageInt;

        double productDouble;
        double averageDouble;


        Scanner scnr = new Scanner(System.in);
        
        System.out.print("Please enter the first integer: ");
        num1 = scnr.nextInt();

        System.out.print("Please enter the second integer: ");
        num2 = scnr.nextInt();

        System.out.print("Please enter the third integer: ");
        num3 = scnr.nextInt();

        System.out.print("Please enter the fourth integer: ");
        num4 = scnr.nextInt();

        productInt = (num1 * num2 * num3 * num4);
        averageInt = (num1 + num2 + num3 + num4) / 4;

        productDouble = ((double) num1 * num2 * num3 * num4);
        averageDouble = ((double) num1 + num2 + num3 + num4) / 4;

        System.out.println("The product using integer arithmetic is: " + productInt);
        System.out.println("The average using integer arithmetic is: " + averageInt);
        System.out.println("The product using floating-point arithmetic is: " + productDouble);
        System.out.println("The average using floating-point arithmetic is: " + averageDouble);

    }

}