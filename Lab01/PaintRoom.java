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

public class PaintRoom {
    public static void main(String[] args) {

        double height;
        double width; 
        double length;

        double area;
        double gallons;

        final int GALLONS_PER_SQFT = 350;


        Scanner scnr = new Scanner(System.in);

        System.out.print("Enter the height of the room in feet: ");
        height = scnr.nextDouble();

        System.out.print("Enter the width of the room in feet: ");
        width = scnr.nextDouble();

        System.out.print("Enter the length of the room in feet: ");
        length = scnr.nextDouble();

        area = (2 * height * (width + length));
        gallons = (area / GALLONS_PER_SQFT);

        System.out.println("For a room that is " + height + "ft. high, " + width + "ft. wide, " + length + "ft. long");
        System.out.printf("You will need %.2f gallons of paint.\n", gallons);


    }  


}