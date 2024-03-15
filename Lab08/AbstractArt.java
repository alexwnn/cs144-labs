/******************************************************
 Lab Assignment 08

 Name: Alex Nguyen
 Course/Semester: Spring 2024
 Class Section: 01
 Lab section: 02
 Sources consulted: __________
 Comments for grader:  Extra Credit: Bulls-eye(nested circles) + Flower
*******************************************************/
import java.awt.*;
import java.util.Random;

public class AbstractArt {
    public static void main(String[] args) {
        DrawingCanvas canvas = new DrawingCanvas();
        Graphics g = canvas.getGraphics();
        Random rand = new Random();

        final int MAX_X = 560;
        final int MAX_Y = 370;
        final int MIN_WIDTH = 80;
        final int MAX_WIDTH = 150;
        final int MIN_NUM_OF = 4;
        final int MAX_NUM_OF = 10;
        final int MAX_COLOR_VAL = 255;
        final int MIN_REPITITIONS = 3;
        final int MAX_REPITITIONS = 7;
        final int MIN_OPACITY = 100;

        // Bulls-eye
        int repititions = rand.nextInt(MAX_REPITITIONS) + MIN_REPITITIONS;
        for (int i = 0; i < repititions; i++) {
            int randomX = rand.nextInt(MAX_X) + 1;
            int randomY = rand.nextInt(MAX_Y) + 1;
            int randomWidth = rand.nextInt(MAX_WIDTH - 100) + MIN_WIDTH;
            int randomNumOf = rand.nextInt(MAX_NUM_OF) + MIN_NUM_OF;
            Color color = new Color(rand.nextInt(MAX_COLOR_VAL) + 1, rand.nextInt(MAX_COLOR_VAL) 
                + 1, rand.nextInt(MAX_COLOR_VAL) + 1, rand.nextInt(MAX_COLOR_VAL - MIN_OPACITY) + MIN_OPACITY);
            Color color2 = new Color(rand.nextInt(MAX_COLOR_VAL) + 1, rand.nextInt(MAX_COLOR_VAL) 
                + 1, rand.nextInt(MAX_COLOR_VAL) + 1, rand.nextInt(MAX_COLOR_VAL - MIN_OPACITY) + MIN_OPACITY);
            
            Bullseye bull = new Bullseye(randomX, randomY, randomWidth, randomNumOf, color, color2);
            bull.draw(g);
        }

        // Checkerboard
        repititions = rand.nextInt(MAX_REPITITIONS) + MIN_REPITITIONS;
        for (int i = 0; i < repititions; i++) {
            int randomX = rand.nextInt(MAX_X) + 1;
            int randomY = rand.nextInt(MAX_Y) + 1;
            int randomWidth = rand.nextInt(MAX_WIDTH) + MIN_WIDTH;
            int randomNumOf = rand.nextInt(MAX_NUM_OF) + MIN_NUM_OF;
            Color color = new Color(rand.nextInt(MAX_COLOR_VAL) + 1, rand.nextInt(MAX_COLOR_VAL) 
                + 1, rand.nextInt(MAX_COLOR_VAL) + 1);
            Color color2 = new Color(rand.nextInt(MAX_COLOR_VAL) + 1, rand.nextInt(MAX_COLOR_VAL) 
                + 1, rand.nextInt(MAX_COLOR_VAL) + 1);
            
            Checkerboard board = new Checkerboard(randomX, randomY, randomWidth, randomNumOf, color, color2);
            board.draw(g);
        }

        // Star
        repititions = rand.nextInt(MAX_REPITITIONS) + MIN_REPITITIONS;
        for (int i = 0; i < repititions; i++) {
            int randomX = rand.nextInt(MAX_X) + 1;
            int randomY = rand.nextInt(MAX_Y) + 1;
            int randomWidth = rand.nextInt(MAX_WIDTH) + MIN_WIDTH;
            int randomNumOf = rand.nextInt(MAX_NUM_OF) + MIN_NUM_OF;
            Color color = new Color(rand.nextInt(MAX_COLOR_VAL) + 1, rand.nextInt(MAX_COLOR_VAL) 
                + 1, rand.nextInt(MAX_COLOR_VAL) + 1);

            Star star = new Star(randomX, randomY, randomWidth, randomNumOf, color);
            star.draw(g);
        }

        // Nested Squares
        repititions = rand.nextInt(MAX_REPITITIONS) + MIN_REPITITIONS;
        for (int i = 0; i < repititions; i++) {
            int randomX = rand.nextInt(MAX_X) + 1;
            int randomY = rand.nextInt(MAX_Y) + 1;
            int randomWidth = rand.nextInt(MAX_WIDTH) + MIN_WIDTH;
            int randomNumOf = rand.nextInt(MAX_NUM_OF) + MIN_NUM_OF;
            Color color = new Color(rand.nextInt(MAX_COLOR_VAL) + 1, rand.nextInt(MAX_COLOR_VAL) 
                + 1, rand.nextInt(MAX_COLOR_VAL) + 1);
            
            NestedSquares square = new NestedSquares(randomX, randomY, randomWidth, randomNumOf, color);
            square.draw(g);
        }

        // Flower 
        repititions = rand.nextInt(MAX_REPITITIONS) + MIN_REPITITIONS;
        final int FLOWER_MAX_X = 500;
        final int FLOWER_MAX_Y = 300;
        for (int i = 0; i < repititions; i++) {
            int randomX = rand.nextInt(FLOWER_MAX_X) + 50;
            int randomY = rand.nextInt(FLOWER_MAX_Y) + 50;
            int randomWidth = rand.nextInt(MAX_WIDTH) + MIN_WIDTH;
            int randomNumOf = rand.nextInt(MAX_NUM_OF) + MIN_NUM_OF;
            while(randomNumOf % 2 != 0) {
                randomNumOf = rand.nextInt(MAX_NUM_OF) + MIN_NUM_OF;
            }
            Color color = new Color(rand.nextInt(MAX_COLOR_VAL) + 1, rand.nextInt(MAX_COLOR_VAL) 
                + 1, rand.nextInt(MAX_COLOR_VAL) + 1, rand.nextInt(MAX_COLOR_VAL - MIN_OPACITY) + MIN_OPACITY);
            
            Flower flower = new Flower(randomX, randomY, randomWidth, randomNumOf, color);
            flower.draw(g);
        }
    }
}