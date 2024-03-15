/******************************************************
 Lab Assignment: 04

 Name: Alex Nguyen 
 Course/Semester: SPRING 2024
 Class Section: 01
 Lab section: 02
 Sources consulted: __________
 Comments for grader: Additional feature: Sentinel based loop
*******************************************************/

import java.util.Scanner;

public class WordPlay {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        
        // User input/output
        while (true) {
            System.out.print("Please enter a sentence (Or \"quit\" to exit): ");
            String input = scnr.nextLine();

            if (input.equalsIgnoreCase("quit")){
                break;
            }

        // Palindrome
        String cleanedInput = input.replaceAll("[^a-zA-Z]", "").toLowerCase();

        boolean isPalindrome = true;
        int left = 0;
        int right = cleanedInput.length() - 1;
        while (left < right) {
            if (cleanedInput.charAt(left) != cleanedInput.charAt(right)) {
                isPalindrome = false;
            }
            left++;
            right--;
        }
        if (isPalindrome) {
            System.out.println("The input is a palindrome.");
        } else {
            System.out.println("The input is not a palindrome.");
        }
        
        // Alliteration
        Scanner strScan = new Scanner(input);

        boolean isAlliteration = true;
        if(strScan.hasNext()) { 
            String firstWord = strScan.next();
            char initialLetter = Character.toLowerCase(firstWord.charAt(0));
            
            while (strScan.hasNext()) {
                String word = strScan.next();
                if (word.length() > 3 && Character.toLowerCase(word.charAt(0)) != initialLetter) {
                    isAlliteration = false;
                }
            }           
        }

        if (isAlliteration) {
            System.out.println("The input is an alliteration.");
        } else {
            System.out.println("The input is not an alliteration.");
        }
        
        // Lipogram 'E'
        boolean isLipogramE = true;
        for (int i = 0; i < input.length(); i++) {
            if (Character.toLowerCase(input.charAt(i)) == 'e') {
                isLipogramE = false;
            }
        }
        if (isLipogramE) {
            System.out.println("The input is a lipogram avoiding E.");
        } else {
            System.out.println("The input is not a lipogram avoiding E.");
        }
        
        // Lipogram 'S'
        boolean isLipogramS = true;
        for (int i = 0; i < input.length(); i++) {
            if (Character.toLowerCase(input.charAt(i)) == 's') {
                isLipogramS = false;
            }
        }
        if (isLipogramS) {
            System.out.println("The input is a lipogram avoiding S.\n");
        } else {
            System.out.println("The input is not a lipogram avoiding S.\n");
        }

        }  
    }
}