/******************************************************
 Lab Assignment: 02

 Name: Alex Nguyen
 Course/Semester: SPRING 2024
 Class Section: 01
 Lab section: L02
 Sources consulted: _______
 Comments for grader: 
I wanted to give my chatBot the personality and speech patterns of Yoda from Star Wars. 
If you are familiar with Yoda and the Star Wars franchise, you will understand the grammar and vocabulary. 
If not, Yoda characteristically speaks a non-standard syntax of Basic, primarily constructing sentences in 
object-subject-verb word order rare in natural languages. Ex. "I believe in you" would be "Believe in you, I do."
*******************************************************/

import java.util.Scanner;

public class chatBot {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        
        System.out.println("Hello! YodaBot, my name is.");
        System.out.print("What is your name, hmm? ");
        String userName = scnr.nextLine();
        System.out.println();
        System.out.println("Great to meet you it is, " + userName); 

        System.out.print("From, where are you, " + userName + "? ");
        String userLocation = scnr.nextLine();
        System.out.println();
        System.out.println("Like an interesting place, " 
            + userLocation + " sounds! ");
        System.out.println("Hmmm, what other knowledge, YodaBot might want to inquire? Oh!");

        System.out.print("Favorite number, you have? Hmm..? ");
        int userFavNum = scnr.nextInt();
        double yodaFavNum = 7; // YodaBot's favorite number
        System.out.println();

        if (userFavNum == yodaFavNum) {
            System.out.println("Oh! Same favorite number, we have, hmm.");
        }

        else if (userFavNum > 7) {
            System.out.printf("Your favorite number (" 
                + userFavNum + ") is %.2f times bigger, than my favorite number is (" 
                + yodaFavNum + "). \n" , (userFavNum / yodaFavNum));    
        }

        else if (userFavNum < 7) { 
            System.out.printf("Your favorite number (" 
                + userFavNum + ") is %.2f times smaller, than my favorite number (" 
                + yodaFavNum + "). \n" , (yodaFavNum/userFavNum));
        }
        System.out.println();

        scnr.nextLine();
        System.out.print("Your dream car, what is? ");
        String dreamCar = scnr.nextLine();
        System.out.println();  
        System.out.println("Wow, cool vehicle " + dreamCar 
            + " is! Better, my Jedi Starfighter I like.");
        
        System.out.print("Cost of " + dreamCar + ", how much it is? Hmm? ");
        double carCost = scnr.nextDouble();
        System.out.println();  
        System.out.println("Lot of money, that is. Hmm.. How much Lightsaber would cost on your planet, I wonder.");

        System.out.print("Reasonable yearly interest rate, on a beautiful car like that, what might it be? Hmm? ");
        double yearlyInterestRate = scnr.nextDouble();
        System.out.println();

        System.out.print("To take out a loan to buy the " + dreamCar + ", The loan out for, how many years, you would you take? ");
        int loanYears = scnr.nextInt();
        System.out.println();   

        // monthly payment calculation
        double monthlyInterestRate = (yearlyInterestRate / 100) / 12;
        int numberOfPayments = loanYears * 12;
        double monthlyPayment = (monthlyInterestRate * carCost) / (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));
        
        double totalCost = monthlyPayment * numberOfPayments;
        
        System.out.printf("If you bought the %s, a monthly payment of $%.2f, you would have. Reasonable for your budget, " 
            + "hopefully is. A total of $%.2f that is! Hope you can purchase, I do!\n", dreamCar, monthlyPayment, totalCost);
        
        System.out.println("Unfortunately leave, YodaBot must. Work hard to make purchase, hmm." 
            + " Try not! Do, or do not, there is no try, remember " + userName + "! <(-_-)>");
        
    }
}