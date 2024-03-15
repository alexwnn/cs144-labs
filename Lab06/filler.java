import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class filler {

    private static final long RAND_SEED = 1234L;
    private static Random randGen = new Random(RAND_SEED);
    
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

        // Find minimum value 
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (grid[i][j] < minVal) {
                    minVal = grid[i][j];
                }
            }
        }
        System.out.println("Min value in map: " + minVal);

        // Find maximum value
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (grid[i][j] > maxVal) {
                    maxVal = grid[i][j];
                }
            }
        }
        System.out.println("Max value in map: " + maxVal);

        // Draw map
        for (int i = 0; i < HEIGHT; i++){
            for (int j = 0; j < WIDTH; j++) {
                int val = grid[i][j];
                double r = (double)(val - minVal) / (maxVal - minVal);
                int c = (int)(r * 255);

                g.setColor(new Color(c, c, c));
                g.fillRect(j, i, 1, 1);
            }
        }

        // Find and draw the lowest-elevation-change path for every possible starting row
        int minTotalElevationChange = Integer.MAX_VALUE;
        int minStartRow = 0;

        for (int startRow = 0; startRow < HEIGHT; startRow++) {
            int totalElevationChange = 0;
            int currentRow = startRow;
            g.setColor(Color.RED); // set color
            g.fillRect(0, currentRow, 1, 1); // start

            for (int col = 1; col < WIDTH; col++) {
                int nextRow = currentRow;
                int minDiff = Integer.MAX_VALUE;

                for (int i = -1; i <= 1; i++) {
                    int neighborRow = currentRow + i;
                    if (neighborRow >= 0 && neighborRow < HEIGHT) {
                        int diff = Math.abs(grid[neighborRow][col] - grid[currentRow][col - 1]); // take abs val of difference
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

                g.fillRect(col, nextRow, 1, 1); // draw cell
                totalElevationChange += minDiff; // update total
                currentRow = nextRow; // update row
            }

            // Check if this path has the minimum total elevation change
            if (totalElevationChange < minTotalElevationChange) {
                minTotalElevationChange = totalElevationChange;
                minStartRow = startRow;
            }
        }

        // Redraw the overall lowest-elevation-change path starting at the row with the minimum total elevation change using a green color
        int totalElevationChange = 0;
        int currentRow = minStartRow;
        g.setColor(Color.GREEN);
        g.fillRect(0, currentRow, 1, 1); // Start point

        for (int col = 1; col < WIDTH; col++) {
            int nextRow = currentRow;
            int minDiff = Integer.MAX_VALUE;

            for (int i = -1; i <= 1; i++) {
                int neighborRow = currentRow + i;
                if (neighborRow >= 0 && neighborRow < HEIGHT) {
                    int diff = Math.abs(grid[neighborRow][col] - grid[currentRow][col - 1]); // take abs val of difference
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

            g.fillRect(col, nextRow, 1, 1); // Draw the chosen cell
            totalElevationChange += minDiff; // Update total elevation change
            currentRow = nextRow; // Update current row
        }

        System.out.println("Total Elevation Change: " + totalElevationChange);
    }
}