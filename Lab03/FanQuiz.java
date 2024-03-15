/******************************************************
 Lab Assignment: 03

 Name: Alex Nguyen
 Course/Semester: SPRING 2024
 Class Section: 01
 Lab section: L02
 Sources consulted: __________
 Comments for grader: Answer key: 
                                1) C
                                2) 8
                                3) 1025
                                4) false
                                5) Bulbasaur
*******************************************************/

import java.util.Scanner;

public class FanQuiz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        System.out.println("Welcome to the Pokemon Quiz!!\n");

        // Question 1 - Multiple Choice
        System.out.println("1) Which of the following are the three types of starter Pokemon " + 
            "you are able to choose from at the beginning of each game?");
        System.out.println("Please enter a character a-d.");
        System.out.println("   a) Fairy, Dragon, Steel");
        System.out.println("   b) Grass, Bug, Flying");
        System.out.println("   c) Fire, Water, Grass");
        System.out.println("   d) Fire, Ice, Rock");
        System.out.println();
        System.out.print("> ");
        char answer1 = scanner.next().charAt(0);
        if (answer1 == 'c') {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Sorry, that is wrong. The answer is (c).");
        }
        System.out.println();

        // Question 2 - Numeric Response (single correct answer)
        System.out.println("2) How many evolutions does Eevee have? (Please enter an integer.)");
        System.out.println();
        System.out.print("> ");
        int answer2 = scanner.nextInt();
        if (answer2 == 8) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Sorry, that is wrong. The answer is 8.");
        }
        System.out.println();

        // Question 3 - Numeric Response (within range)
        System.out.println("3) Within 100 (high or low), how many Pokemon are in the " + 
            "National Pokedex? (Please enter an integer.)");
        System.out.println();
        System.out.print("> ");
        int answer3 = scanner.nextInt();
        if (answer3 == 1025) {
            System.out.println("Wow! You got the answer exactly correct!");
            score++;
        } else if (answer3 >= 925 && answer3 <= 1125) {
            System.out.println("That's correct! The exact answer is 1,025.");
            score++;
        } else {
            System.out.println("Sorry, that is wrong. The answer is 1,025.");
        }
        System.out.println();

        // Question 4 - True/False
        System.out.println("4) The main character of the animated TV series is Ash Ketchup. " + 
            "(Please enter true or false.)");
        System.out.println();
        System.out.print("> ");
        boolean answer4 = scanner.nextBoolean();
        if (answer4) {
            System.out.println("Sorry, that is wrong. The answer is (false).");
        } else { 
            System.out.println("Correct!");
            score++;
        }
        System.out.println();

        // Question 5 - One word answer
        System.out.println("5) What is the name Pokemon #001 in the Pokedex?");
        System.out.println();
        System.out.print("> ");
        scanner.nextLine();
        String answer5 = scanner.nextLine();
        if (answer5.equalsIgnoreCase("Bulbasaur")) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Sorry, that is wrong. The answer is Bulbasaur.");
        }
        System.out.println();

        // Final score
        System.out.println("You scored " + score + "/5");
        if (score == 5) {
            System.out.println("Congratulations! You are a true Pokemon fan!");
        } else if (score == 4) {
            System.out.println("Well done! You have a good knowledge of Pokemon.");
        } else if (score == 3) {
            System.out.println("You have an average knowledge of Pokemon. Try playing more of the games!");
        } else {
            System.out.println("You have some room for improvement. Keep training!");
        }
    }
}