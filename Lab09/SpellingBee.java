/******************************************************
 Lab Assignment 09

 Name: Alex Nguyen
 Course/Semester: Spring 2024
 Class Section: 01
 Lab section: 02
 Sources consulted: Dr. Fawcett , Dr. Murphy
 Comments for grader: Extra credit for Word Field implemented.
*******************************************************/
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;
import java.awt.Color;

public class SpellingBee {
    private SpellingBeeGraphics sbg;
    private SpellingBeePuzzle puzzle;
    private ArrayList<String> dictionary;
    private ArrayList<String> usedWords;
    static int score = 0;
    static int wordCount = 0;
    static int totalScore = 0;
    public static void main(String[] args) {
        new SpellingBee().run();
    }
    /**
     * This method runs the Spelling Bee game
     */
    public void run() {
        sbg = new SpellingBeeGraphics();
        sbg.addField("Puzzle", (s) -> puzzleAction(s));
        sbg.addField("Word", (s) -> wordAction(s));
        sbg.addButton("Solve", (s) -> solveAction());

        dictionary = new ArrayList<>();
        usedWords = new ArrayList<>();
        Scanner scan = null;
        try {
            FileInputStream in = new FileInputStream("EnglishWords.txt");
            scan = new Scanner(in);
        }
        catch (IOException e) {
            System.out.println(e);
        } 
        while (scan != null && scan.hasNext()) {
            dictionary.add(scan.next());
        }
    }

    /**
     * This method is called when the user enters a set of letters in the puzzle field
     * 
     * @param s the set of letters entered by the user
     */
    private void puzzleAction(String s) {
        usedWords.clear();
        sbg.clearWordList();
        score = 0;
        totalScore = 0;
        wordCount = 0;
        try {
            puzzle = new SpellingBeePuzzle(s.toUpperCase());
            sbg.setBeehiveLetters(puzzle.getPuzzle());
            sbg.showMessage("");
        } 
        catch (SpellingBeePuzzleException e) {
            sbg.showMessage(e.getMessage(), Color.red);
        }
    }
    
    /**
     * This method displays all possible words when solve button is pressed
     */
    private void solveAction() {
        sbg.clearWordList();
        score = 0;
        totalScore = 0;
        wordCount = 0;
        ArrayList<String> validWords = new ArrayList<>();
        for (String word : dictionary) {
            boolean validity = false;
            if (word.length() >= 4) {
                if (puzzle.wordUsesPuzzleLettersOnly(word)) {
                    if (puzzle.wordUsesCenterLetter(word)) {
                        validity = true;
                    }
                }
            }
            if (validity) {
                validWords.add(word);
                wordCount++;
            }
        }

        for (String word : validWords) {
            int score;
            Color color = Color.BLACK;
            if (word.length() == 4) {
                score = 1;
            }
            else if (puzzle.isPangram(word)) {
                score = word.length() + 7;
                color = Color.BLUE;
            }
            else {
                score = word.length();
            }
            totalScore += score;
            word = word + " (" + score + ")";
            sbg.addWord(word.toLowerCase(), color);
        }
        sbg.showMessage(wordCount + " Words | " + "Total Score: " + totalScore);
    }

    /**
     * This method is called when the user enters a String in the word field
     * 
     * @param s the word entered by the user
     */
    private void wordAction(String s) {
        boolean isValid = false;
        Color color = Color.BLACK;
        ArrayList<String> validWords = new ArrayList<>();
        for (String word : dictionary) {
            boolean validity = false;
            if (word.length() >= 4) {
                if (puzzle.wordUsesPuzzleLettersOnly(word)) {
                    if (puzzle.wordUsesCenterLetter(word)) {
                        validity = true;
                    }
                }
            }
            if (validity) {
                validWords.add(word);
            }
        }
        try {
            checkWord(s);
            usedWords.add(s.toLowerCase());
            isValid = true;
        }
        catch (SpellingBeePuzzleException e) {
            sbg.showMessage(e.getMessage(), Color.red);
        }
        if (isValid) {
            if (s.length() == 4) {
                score = 1;
            }
            else if (puzzle.isPangram(s)) {
                score = s.length() + 7;
                color = Color.BLUE;
            }
            else {
                score = s.length();
            }
            totalScore += score;
            wordCount++;
            s = s + " (" + score + ")";
            sbg.addWord(s.toLowerCase(), color);
            sbg.setField("Word", "");
            sbg.showMessage(wordCount + " Words | " + "Total Score: " + totalScore);
        }
    }

    /**
     * This method checks if the word entered by user is valid
     * 
     * @param s the word to check
     * @throws SpellingBeePuzzleException if the word is not valid
     */
    public void checkWord(String s) throws SpellingBeePuzzleException {
        if (usedWords.indexOf(s.toLowerCase())!= -1) {
            throw new SpellingBeePuzzleException("Word has already been used");
        }
        else if (dictionary.indexOf(s.toLowerCase()) == -1) {
            throw new SpellingBeePuzzleException("Word is not in the dictionary");
        }
        else if (dictionary.indexOf(s.toLowerCase()) == -1) {
            throw new SpellingBeePuzzleException("Word is not in the dictionary");
        }
        else if (s.length() < 4) {
            throw new SpellingBeePuzzleException("Word is too short");
        }
        else if (!puzzle.wordUsesPuzzleLettersOnly(s)) {
            throw new SpellingBeePuzzleException("Word uses letter(s) not present in the puzzle");
        }
        else if (!puzzle.wordUsesCenterLetter(s)) {
            throw new SpellingBeePuzzleException("Word does not use the center letter");
        }
    }
}
