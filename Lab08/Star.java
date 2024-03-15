import java.awt.*;

public class Star {

	/** The x coordinate of the upper left corner of the star. */
	private int x;

	/** The y coordinate of the upper left corner of the star. */
	private int y;

	/** The width of the star. */
	private int width;

	/** The number of spokes that make up the star. */
	private int numSpokes;

	/** The color of the star */
	private Color color;

    /**
     * Constructs a new Star object with the specified parameters.
     *
     * @param x         the x coordinate of the upper left corner of the star
     * @param y         the y coordinate of the upper left corner of the star
     * @param width     the width of the star
     * @param numSpokes the number of spokes that make up the star
     * @param color     the color of the star
     */
    public Star(int x, int y, int width, int numSpokes, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.numSpokes = numSpokes;
        this.color = color;
    }

    /**
     * Returns a string representation of the Star object.
     *
     * @return a string representation of the Star object
     */
    public String toString() {
        return "Star[x=" + x + ", y=" + y + ", width=" + width + ", numSpokes=" + numSpokes + ", color=" + color + "]";
    }

    /**
     * Returns the x coordinate of the upper left corner of the star.
     *
     * @return the x coordinate of the upper left corner of the star
     */
    public int getX() {
        return x;
    }

    /**
     * Sets the x coordinate of the upper left corner of the star.
     *
     * @param x the x coordinate of the upper left corner of the star
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Returns the y coordinate of the upper left corner of the star.
     *
     * @return the y coordinate of the upper left corner of the star
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the y coordinate of the upper left corner of the star.
     *
     * @param y the y coordinate of the upper left corner of the star
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Returns the width of the star.
     *
     * @return the width of the star
     */
    public int getWidth() {
        return width;
    }

    /**
     * Sets the width of the star.
     *
     * @param width the width of the star
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Returns the number of spokes that make up the star.
     *
     * @return the number of spokes that make up the star
     */
    public int getNumSpokes() {
        return numSpokes;
    }

    /**
     * Sets the number of spokes that make up the star.
     *
     * @param numSpokes the number of spokes that make up the star
     */
    public void setNumSpokes(int numSpokes) {
        this.numSpokes = numSpokes;
    }

    /**
     * Returns the color of the star.
     *
     * @return the color of the star
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets the color of the star.
     *
     * @param color the color of the star
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Draws the spoked star
     * 
     * @param g graphics object used to draw the star
     */
    public void draw(Graphics g) {
        int radius = width / 2;
        int centerX = x + radius;
        int centerY = y + radius;
        double delta = (2 * Math.PI) / numSpokes;
        for (int spoke = 0; spoke < numSpokes; spoke++) {
            double spokeXdouble = Math.cos(spoke * delta) * radius + centerX;
            double spokeYdouble = Math.sin(spoke * delta) * radius + centerY;
            int spokeX = (int)spokeXdouble;
            int spokeY = (int)spokeYdouble;

            g.setColor(color);
            g.drawLine(centerX, centerY, spokeX, spokeY);
        }

    }
}