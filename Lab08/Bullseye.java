import java.awt.*;

public class Bullseye {
	/** The x coordinate of the upper left corner of the bulls-eye. */
	private int x;

	/** The y coordinate of the upper left corner of the bulls-eye. */
	private int y;

	/** The width (and height) of the bulls-eye. */
	private int width;

	/** The number of circles(rings) that make up the bulls-eye. */
	private int numCircles;

	/** The color for even rings */
	private Color evenColor;

	/** The color for odd rings */
	private Color oddColor;

/**
     * Constructs a new Bullseye object with the specified parameters.
     *
     * @param x          the x coordinate of the upper left corner of the bulls-eye
     * @param y          the y coordinate of the upper left corner of the bulls-eye
     * @param width      the width (and height) of the bulls-eye
     * @param numCircles the number of circles(rings) that make up the bulls-eye
     * @param evenColor  the color for even rings
     * @param oddColor   the color for odd rings
     */
    public Bullseye(int x, int y, int width, int numCircles, Color evenColor, Color oddColor) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.numCircles = numCircles;
        this.evenColor = evenColor;
        this.oddColor = oddColor;
    }

    /**
     * Returns a string representation of the Bullseye object.
     *
     * @return a string representation of the Bullseye object
     */
    public String toString() {
        return "Bullseye[x=" + x + ", y=" + y + ", width=" + width + ", numCircles=" + numCircles + ", evenColor=" + evenColor + ", oddColor=" + oddColor + "]";
    }

    /**
     * Returns the x coordinate of the upper left corner of the bulls-eye.
     *
     * @return the x coordinate of the upper left corner of the bulls-eye
     */
    public int getX() {
        return x;
    }

    /**
     * Sets the x coordinate of the upper left corner of the bulls-eye.
     *
     * @param x the x coordinate of the upper left corner of the bulls-eye
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Returns the y coordinate of the upper left corner of the bulls-eye.
     *
     * @return the y coordinate of the upper left corner of the bulls-eye
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the y coordinate of the upper left corner of the bulls-eye.
     *
     * @param y the y coordinate of the upper left corner of the bulls-eye
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Returns the width (and height) of the bulls-eye.
     *
     * @return the width (and height) of the bulls-eye
     */
    public int getWidth() {
        return width;
    }

    /**
     * Sets the width (and height) of the bulls-eye.
     *
     * @param width the width (and height) of the bulls-eye
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Returns the number of circles(rings) that make up the bulls-eye.
     *
     * @return the number of circles(rings) that make up the bulls-eye
     */
    public int getNumCircles() {
        return numCircles;
    }

    /**
     * Sets the number of circles(rings) that make up the bulls-eye.
     *
     * @param numCircles the number of circles(rings) that make up the bulls-eye
     */
    public void setNumCircles(int numCircles) {
        this.numCircles = numCircles;
    }

    /**
     * Returns the color for even rings.
     *
     * @return the color for even rings
     */
    public Color getEvenColor() {
        return evenColor;
    }

    /**
     * Sets the color for even rings.
     *
     * @param evenColor the color for even rings
     */
    public void setEvenColor(Color evenColor) {
        this.evenColor = evenColor;
    }

    /**
     * Returns the color for odd rings.
     *
     * @return the color for odd rings
     */
    public Color getOddColor() {
        return oddColor;
    }

    /**
     * Sets the color for odd rings.
     *
     * @param oddColor the color for odd rings
     */
    public void setOddColor(Color oddColor) {
        this.oddColor = oddColor;
    }

    /**
     * Draws the bulls-eye
     * 
     * @param g Graphics object to draw the bulls-eye
     */
    public void draw(Graphics g) {
        int diff = width / (numCircles * 2);

        for(int cir = 0; cir < numCircles; cir++) {
            int cirX = x + cir * diff;
            int cirY = y + cir * diff;
            int cirWidth = width - (cir * diff * 2);
            if (cir % 2 == 0) {
                g.setColor(evenColor);
            }
            else {
                g.setColor(oddColor);
            }
            g.fillOval(cirX, cirY, cirWidth, cirWidth);
        }
    }
}