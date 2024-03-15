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

public class RealEstate {
    public static void main(String[] args) {

        double lastMonth;
        double currentMonth;
        double priceChange;
        double monthlyPay;

        final double MORTGAGE_FACTOR = 0.051;
        final int MONTHS_IN_YEAR = 12;

        Scanner scnr = new Scanner(System.in);

        System.out.print("Enter the current price of the house: ");
        currentMonth = scnr.nextDouble();

        System.out.print("Enter the price of the house last month: ");
        lastMonth = scnr.nextDouble();

        priceChange = currentMonth - lastMonth;
        monthlyPay = (MORTGAGE_FACTOR * currentMonth)  / MONTHS_IN_YEAR;

        System.out.printf("The current price of this home is $%.2f\n", currentMonth);
        System.out.printf("Since last month, the price has changed $%.2f\n", priceChange);
        System.out.printf("The estimated monthly mortgage payment for this home is $%.2f\n", monthlyPay);


    }  


}