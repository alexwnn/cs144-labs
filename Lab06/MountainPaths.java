/******************************************************
 Lab Assignment 06

 Name: Alex Nguyen
 Course/Semester: Spring 2024
 Class Section: 01
 Lab section: 02
 Sources consulted: Dr. Murphy
 Comments for grader:  I am not sure if it should look exactly 1:1 with the example on the website, 
                       but I went over it with Dr. Murphy and she said that a little variation is normal.
                       I have two questions if you wouldn't mind answering, If variation is normal, why are 
                       the two pictures different if there is a seed? If it should look exactly like it, what 
                       part of my code is faulty? Thank you. 
*******************************************************/

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class MountainPaths {

    private static final long RAND_SEED = 1234L;
    private static Random randGen = new Random( RAND_SEED );
    
    public static void main(String[] args) throws Exception{
        final int WIDTH = 840;
        final int HEIGHT = 480;
        final String INPUT_FILE = "Colorado_840x480.dat";
      
        // Construct the DrawingPanel, and get its Graphics context
        DrawingCanvas panel = new DrawingCanvas(WIDTH, HEIGHT);
        Graphics g = panel.getGraphics();
        
        // Load elevation data from INPUT_FILE
        int[][] grid = ElevationData.load(INPUT_FILE, WIDTH, HEIGHT);
        
        // TODO: Implement your solution here
        int minVal = grid[0][0];
        int maxVal = grid[0][0];

        // (Step 1a) Find minimum value 
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (grid[i][j] < minVal) {
                    minVal = grid[i][j];
                }
            }
        }
        System.out.println("Min value in map: " + minVal);

        // (Step 1b) Find maximum value
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (grid[i][j] > maxVal) {
                    maxVal = grid[i][j];
                }
            }
        }
        System.out.println("Max value in map: " + maxVal);

        // (Step 2) Draw map
        for (int i = 0; i < HEIGHT; i++){
            for (int j = 0; j < WIDTH; j++) {
                int val = grid[i][j];
                double r = (double)(val - minVal) / (maxVal - minVal);
                int c = (int)(r * 255);

                g.setColor(new Color(c, c, c));
                g.fillRect(j, i, 1, 1);
            }
        }

        // (Step 3) Find row with minimum value in column 0 
        int minRow = grid[0][0];
        int minRowIndex = 0;
        for (int i = 0; i < HEIGHT; i++){
            if (grid[i][0] < minRow){
                minRow = grid[i][0];
                minRowIndex = i;
            }
        }
        System.out.println("Row with lowest val in col 0: " + minRowIndex);

        // (Step 4) Draw lowest-elevation-change path
        int totalElevationChange = 0;
        int currentRow = minRowIndex;
        g.setColor(Color.RED); 
        g.fillRect(0, currentRow, 1, 1); 

        for (int col = 1; col < WIDTH; col++) {
            int nextRow = currentRow;
            int minDiff = Integer.MAX_VALUE;

            for (int i = -1; i <= 1; i++) {
                int neighborRow = currentRow + i;
                if (neighborRow >= 0 && neighborRow < HEIGHT) {
                    int diff = Math.abs(grid[neighborRow][col] - grid[currentRow][col - 1]); 
                    if (diff == minDiff && i == 0){
                        minDiff = diff;
                        nextRow = currentRow;
                    }
                    else if (diff < minDiff || (diff == minDiff && i != 0 && randGen.nextInt(2) == 0)) {
                        minDiff = diff;
                        nextRow = neighborRow;
                    }
                }
            }

            g.fillRect(col, nextRow, 1, 1); 
            totalElevationChange += minDiff; 
            currentRow = nextRow; 
        }

        System.out.println("Lowest-Elevation-Change Path starting at row " + minRowIndex + 
            " gives a total elevation change of: " + totalElevationChange);

    }
}