import java.awt.*;

public class Checkerboard {

	/** The x coordinate of the upper left corner of the checkerboard. */
	private int x;

	/** The y coordinate of the upper left corner of the checkerboard. */
	private int y;

	/** The width (and height) of the square checkerboard. */
	private int width;

	/** The number of squares per side of the checkerboard. */
	private int squaresPerSide;

	/** The color for even squares */
	private Color evenColor;

	/** The color for odd squares */
	private Color oddColor;

    /**
     * Constructs a new Checkerboard object with the specified parameters.
     *
     * @param x              the x coordinate of the upper left corner of the checkerboard
     * @param y              the y coordinate of the upper left corner of the checkerboard
     * @param width          the width (and height) of the square checkerboard
     * @param squaresPerSide the number of squares per side of the checkerboard
     * @param evenColor      the color for even squares
     * @param oddColor       the color for odd squares
     */
    public Checkerboard(int x, int y, int width, int squaresPerSide, Color evenColor, Color oddColor) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.squaresPerSide = squaresPerSide;
        this.evenColor = evenColor;
        this.oddColor = oddColor;
    }

    /**
     * Returns a string representation of the Checkerboard object.
     *
     * @return a string representation of the Checkerboard object
     */
    public String toString() {
        return "Checkerboard[x=" + x + ", y=" + y + ", width=" + width + ", squaresPerSide=" + squaresPerSide + ", evenColor=" + evenColor + ", oddColor=" + oddColor + "]";
    }

    /**
     * Returns the x coordinate of the upper left corner of the checkerboard.
     *
     * @return the x coordinate of the upper left corner of the checkerboard
     */
    public int getX() {
        return x;
    }

    /**
     * Sets the x coordinate of the upper left corner of the checkerboard.
     *
     * @param x the x coordinate of the upper left corner of the checkerboard
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Returns the y coordinate of the upper left corner of the checkerboard.
     *
     * @return the y coordinate of the upper left corner of the checkerboard
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the y coordinate of the upper left corner of the checkerboard.
     *
     * @param y the y coordinate of the upper left corner of the checkerboard
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Returns the width (and height) of the square checkerboard.
     *
     * @return the width (and height) of the square checkerboard
     */
    public int getWidth() {
        return width;
    }

    /**
     * Sets the width (and height) of the square checkerboard.
     *
     * @param width the width (and height) of the square checkerboard
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Returns the number of squares per side of the checkerboard.
     *
     * @return the number of squares per side of the checkerboard
     */
    public int getSquaresPerSide() {
        return squaresPerSide;
    }

    /**
     * Sets the number of squares per side of the checkerboard.
     *
     * @param squaresPerSide the number of squares per side of the checkerboard
     */
    public void setSquaresPerSide(int squaresPerSide) {
        this.squaresPerSide = squaresPerSide;
    }

    /**
     * Returns the color for even squares.
     *
     * @return the color for even squares
     */
    public Color getEvenColor() {
        return evenColor;
    }

    /**
     * Sets the color for even squares.
     *
     * @param evenColor the color for even squares
     */
    public void setEvenColor(Color evenColor) {
        this.evenColor = evenColor;
    }

    /**
     * Returns the color for odd squares.
     *
     * @return the color for odd squares
     */
    public Color getOddColor() {
        return oddColor;
    }

    /**
     * Sets the color for odd squares.
     *
     * @param oddColor the color for odd squares
     */
    public void setOddColor(Color oddColor) {
        this.oddColor = oddColor;
    }

    /**
     * Draws the checkerboard
     * 
     * @param g graphics object used to draw checkerboard
     */
    public void draw(Graphics g) {
        int sqrWidth = width / squaresPerSide;
        for (int row = 0; row < squaresPerSide; row++) {
            for (int col = 0; col < squaresPerSide; col++) {
                int squareX = x + col * sqrWidth;
                int squareY = y + row * sqrWidth;

                if ((row + col) % 2 == 0) {
                    g.setColor(evenColor);
                }
                else {
                    g.setColor(oddColor);
                }
                g.fillRect(squareX, squareY, sqrWidth, sqrWidth);
            }
        }
    }
}