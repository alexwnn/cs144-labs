/******************************************************
 Lab Assignment 07

 Name: Alex Nguyen
 Course/Semester: Spring 2024
 Class Section: 01
 Lab section: 02
 Sources consulted: __________
 Comments for grader:  _________
*******************************************************/
import java.io.*;
import java.util.Scanner;

public class ImageModify {

    // width & height stored
    static int width, height;

    // modification enum
     enum Modification { NEGATE, QUANTIZE, GRAY_SCALE, FLIP_HORIZONTAL }

    /**
     * Main method to interact with the user and perform image modifications.
     *
     * @throws IOException If an I/O error occurs
     */
    public static void main(String[] args) throws IOException {
        Scanner scnr = new Scanner(System.in);

        // prompt user to give input and output files
        System.out.print("Input file: ");
        String userInputFile = scnr.nextLine();
        System.out.print("Output file: ");
        String userOutputFile = scnr.nextLine();

        // promt user to select modification
        System.out.println("Select modification:");
        System.out.println("  (a) negate");
        System.out.println("  (b) quantize");
        System.out.println("  (c) gray scale");
        System.out.println("  (d) flip horizontal");
        System.out.print("> ");
        String modificationChoice = scnr.nextLine().toLowerCase();

        Modification modification = null;

        // convert user input to enum
        if (modificationChoice.equals("a")) {
            modification = Modification.NEGATE;
        } 
        else if (modificationChoice.equals("b")) {
            modification = Modification.QUANTIZE;
        } 
        else if (modificationChoice.equals("c")) {
            modification = Modification.GRAY_SCALE;
        } 
        else if (modificationChoice.equals("d")) {
            modification = Modification.FLIP_HORIZONTAL;
        } 
        else {
            System.out.println("Invalid choice. Exiting...");
            return;
        }

        // input and output files
        FileInputStream inputFile = new FileInputStream(userInputFile);
        Scanner scan = new Scanner(inputFile);
        FileOutputStream outputFile = new FileOutputStream(userOutputFile);
        PrintWriter writer = new PrintWriter(outputFile);
        
        // process header
        processHeader(scan, writer);

        // process body (apply modification)
        processBody(scan, writer, modification);

        // close files
        inputFile.close();
        writer.close();

        System.out.println(userInputFile + " --> " + userOutputFile);
        System.out.println("Complete, closing files.");
    }

    /**
     * Method to process header of PPM file.
     *
     * @param scnr  Scanner object for input file
     * @param output PrintWriter object for output file
     */
    public static void processHeader(Scanner scnr, PrintWriter output) {

        for (int i = 0; i < 3; i++) {
            String line = scnr.nextLine();
            output.println(line);
        
            if (i == 1) {
                // Extract width and height from second line
                String[] dimensions = line.split(" ");
                width = Integer.parseInt(dimensions[0]);
                height = Integer.parseInt(dimensions[1]);
                System.out.println("Image size: " + width + "x" + height);
            }
        }
    }

    /**
     * Method to process body of PPM file based on selected modification.
     *
     * @param scnr         Scanner object for input file
     * @param output        PrintWriter object for output file
     * @param modification  Modification enum indicating the modification operation
     */
    public static void processBody(Scanner scnr, PrintWriter output, Modification modification) {

        if(modification == Modification.NEGATE) {
            negate(scnr, output);
        }
        else if(modification == Modification.QUANTIZE) {
            quantize(scnr, output);
        }
        else if(modification == Modification.GRAY_SCALE) {
            grayScale(scnr, output);
        }
        else if(modification == Modification.FLIP_HORIZONTAL) {
            flipHorizontal(scnr, output);
        }
    }

    /**
     * Method to negate colors of the image.
     *
     * @param input  Scanner object for input file
     * @param output PrintWriter object for output file
     */
    public static void negate(Scanner input, PrintWriter output) {
        // negation logic
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width * 3; j += 3) {
                int negRed = input.nextInt();
                int negGreen = input.nextInt();
                int negBlue = input.nextInt();

                negRed = Math.abs(negRed - 255);
                negGreen = Math.abs(negGreen - 255);
                negBlue= Math.abs(negBlue - 255);

                output.print(negRed + " " + negGreen + " " + negBlue + " ");
            }
            output.println();
        }
    }

    /**
     * Method to quantize colors of the image.
     *
     * @param input  Scanner object for input file
     * @param output PrintWriter object for output file
     */
    public static void quantize(Scanner input, PrintWriter output) {
        // quantization logic

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width * 3; j++) {
                int value = input.nextInt();

                if (value > 127) {
                    value = 255;
                }
                else {
                    value = 0;
                }
                output.print(value + " ");
            }
            output.println();
        }
    }

    /**
     * Method to convert image to gray scale.
     *
     * @param input  Scanner object for input file
     * @param output PrintWriter object for output file
     */
    public static void grayScale(Scanner input, PrintWriter output) {
        // grayscale conversion logic
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width * 3; j += 3) {
                int red = input.nextInt();
                int green = input.nextInt();;
                int blue = input.nextInt();;
                int average = (red + green + blue) / 3;
                output.print(average + " " + average + " " + average + " ");
            }
            output.println();
        }
    }

    /**
     * Method to flip image horizontally.
     *
     * @param input  Scanner object for input file
     * @param output PrintWriter object for output file
     */
    public static void flipHorizontal(Scanner input, PrintWriter output) {
        // horizontal flip logic
        for (int i = 0; i < height; i++) {
            int[] redVals = new int[width];
            int[] greenVals = new int[width];
            int[] blueVals = new int[width];
            
            for (int j = 0; j < width; j++) {
                redVals[j] = input.nextInt();
                greenVals[j] = input.nextInt();
                blueVals[j] = input.nextInt();
            }
            for (int j = width - 1; j > -1; j--) {
                output.print(redVals[j] + " " + greenVals[j] + " " + blueVals[j] + " ");
            }
            output.println();
        }
    }
}