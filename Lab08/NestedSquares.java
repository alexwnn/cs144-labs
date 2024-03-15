import java.awt.*;

public class NestedSquares {

	/** The x coordinate of the upper left corner of the nested square. */
	private int x;

	/** The y coordinate of the upper left corner of the nested square. */
	private int y;

	/** The width (and height) of the nested square. */
	private int width;

	/** The number of squares that make up the nested square. */
	private int numSquares;

	/** The color of the nested square. */
	private Color color;

    /**
     * Constructs a new NestedSquares object with the specified parameters.
     *
     * @param x          the x coordinate of the upper left corner of the nested square
     * @param y          the y coordinate of the upper left corner of the nested square
     * @param width      the width (and height) of the nested square
     * @param numSquares the number of squares that make up the nested square
     * @param color      the color of the nested square
     */
    public NestedSquares(int x, int y, int width, int numSquares, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.numSquares = numSquares;
        this.color = color;
    }

    /**
     * Returns a string representation of the NestedSquares object.
     *
     * @return a string representation of the NestedSquares object
     */
    public String toString() {
        return "NestedSquares[x=" + x + ", y=" + y + ", width=" + width + ", numSquares=" + numSquares + ", color=" + color + "]";
    }

    /**
     * Returns the x coordinate of the upper left corner of the nested square.
     *
     * @return the x coordinate of the upper left corner of the nested square
     */
    public int getX() {
        return x;
    }

    /**
     * Sets the x coordinate of the upper left corner of the nested square.
     *
     * @param x the x coordinate of the upper left corner of the nested square
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Returns the y coordinate of the upper left corner of the nested square.
     *
     * @return the y coordinate of the upper left corner of the nested square
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the y coordinate of the upper left corner of the nested square.
     *
     * @param y the y coordinate of the upper left corner of the nested square
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Returns the width (and height) of the nested square.
     *
     * @return the width (and height) of the nested square
     */
    public int getWidth() {
        return width;
    }

    /**
     * Sets the width (and height) of the nested square.
     *
     * @param width the width (and height) of the nested square
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Returns the number of squares that make up the nested square.
     *
     * @return the number of squares that make up the nested square
     */
    public int getNumSquares() {
        return numSquares;
    }

    /**
     * Sets the number of squares that make up the nested square.
     *
     * @param numSquares the number of squares that make up the nested square
     */
    public void setNumSquares(int numSquares) {
        this.numSquares = numSquares;
    }

    /**
     * Returns the color of the nested square.
     *
     * @return the color of the nested square
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets the color of the nested square.
     *
     * @param color the color of the nested square
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Draws the Nested Squares
     * 
     * @param g Graphics object to draw the Nested Squares
     */
    public void draw(Graphics g) {
        int diff = width / (numSquares * 2);
        for (int square = 0; square < numSquares; square++) {
            int squareX = x + square * diff; 
            int squareY = y + square * diff;
            int squareWidth = width - (square * diff * 2);

            g.setColor(color);
            g.drawRect(squareX, squareY, squareWidth, squareWidth);
            g.drawLine(squareX, squareY, (squareX + squareWidth), (squareY + squareWidth));
            g.drawLine(squareX, (squareY + squareWidth), (squareX + squareWidth), squareY);
        }
    }
}