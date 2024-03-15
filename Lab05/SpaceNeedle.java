/******************************************************
 Lab Assignment 05

 Name: Alex Nguyen
 Course/Semester: Spring 2024
 Class Section: 01
 Lab section: 02
 Sources consulted: __________
 Comments for grader:  _________
*******************************************************/

import java.util.Scanner;

public class SpaceNeedle {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        // Scale
        System.out.print("Enter the scale: ");
        int scale = scnr.nextInt();

        // Needle
        for (int row = 0; row < scale; row++) {
            for (int space = 0; space < scale; space++) {
                System.out.print("   ");
            }
            System.out.println("||");
        }

        // Top of Saucer 
        for (int row = 0; row < scale; row++) {
            for (int space = 0; space < (scale - 1) - row; space++){
                System.out.print("   "); 
            }
            System.out.print("__/");
            for (int colon = 0; colon != row; colon++) {
                System.out.print(":::");
            }
            System.out.print("||");
            for (int colon = 0; colon != row; colon++) {
                System.out.print(":::");
            }
            System.out.print("\\__");

            System.out.println();
        }

        // Center of Saucer
        System.out.print("|");
        for (int quote = 0; quote < scale; quote++) {
            System.out.print("\"\"\"\"\"\"");
        }
        System.out.println("|");

        // Bottom of Saucer
        for (int row = 0; row < scale; row++) {
            for (int space = 0; space != row; space++) {
                System.out.print("  ");
            }
            System.out.print("\\_");
            for (int slash = 0; slash < ((scale * 2 - 1) - (2 * row) + scale); slash++) {
                System.out.print("/\\");
            }
            System.out.print("_/");
            System.out.println();
        }

        // Neck
        for (int row = 0; row < scale; row++) {
            for (int space = 0; space < scale; space++) {
                System.out.print("   ");
            }
            System.out.println("||");
        }

        // Elevator
        for (int row = 0; row < Math.pow(scale, 2); row++) { 
            for (int space = 0; space < scale - 1; space++){
                System.out.print("   ");
            }
            System.out.print("|%%||%%|");
            System.out.println();
        }

        // Base 
        for (int row = 0; row < scale; row++) {
            for (int space = 0; space < (scale - 1) - row; space++){
                System.out.print("   "); 
            }
            System.out.print("__/");
            for (int colon = 0; colon != row; colon++) {
                System.out.print(":::");
            }
            System.out.print("||");
            for (int colon = 0; colon != row; colon++) {
                System.out.print(":::");
            }
            System.out.print("\\__");

            System.out.println();
        }

        // Very Bottom 
        System.out.print("|");
        for (int quote = 0; quote < scale; quote++) {
            System.out.print("\"\"\"\"\"\"");
        }
        System.out.println("|");
    }
}