import java.awt.*;
import java.util.Random;

public class Flower {

    /** The x coordinate of the upper left corner of the flower. */
    private int x;

    /** The y coordinate of the upper left corner of the flower. */
    private int y;

    /** The width (and height) of the flower. */
    private int width;

    /** The number of petals of the flower. */
    private int numPetals;

    /** The color of the flower */
    private Color color;

    /**
     * Constructs a new Flower object with the specified parameters.
     *
     * @param x          the x coordinate of the upper left corner of the flower
     * @param y          the y coordinate of the upper left corner of the flower
     * @param width      the width (and height) of the flower
     * @param numPetals  the number of petals of the flower
     * @param color      the color of the flower
     */
    public Flower(int x, int y, int width, int numPetals, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.numPetals = numPetals;
        this.color = color;
    }

    /**
     * Returns a string representation of the Flower object.
     *
     * @return a string representation of the Flower object
     */
    public String toString() {
        return "Flower[x=" + x + ", y=" + y + ", width=" + width + ", numPetals=" + numPetals + ", color=" + color + "]";
    }

    /**
     * Returns the x coordinate of the upper left corner of the flower.
     *
     * @return the x coordinate of the upper left corner of the flower
     */
    public int getX() {
        return x;
    }

    /**
     * Sets the x coordinate of the upper left corner of the flower.
     *
     * @param x the x coordinate of the upper left corner of the flower
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Returns the y coordinate of the upper left corner of the flower.
     *
     * @return the y coordinate of the upper left corner of the flower
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the y coordinate of the upper left corner of the flower.
     *
     * @param y the y coordinate of the upper left corner of the flower
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Returns the width (and height) of the flower.
     *
     * @return the width (and height) of the flower
     */
    public int getWidth() {
        return width;
    }

    /**
     * Sets the width (and height) of the flower.
     *
     * @param width the width (and height) of the flower
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Returns the number of petals of the flower.
     *
     * @return the number of petals of the flower
     */
    public int getNumPetals() {
        return numPetals;
    }

    /**
     * Sets the number of petals of the flower.
     *
     * @param numPetals the number of petals of the flower
     */
    public void setNumPetals(int numPetals) {
        this.numPetals = numPetals;
    }

    /**
     * Returns the color of the flower.
     *
     * @return the color of the flower
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets the color of the flower.
     *
     * @param color the color of the flower
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Draws the flower pattern
     *
     * @param g graphics object used to draw the flower
     */
    public void draw(Graphics g) {
        Random rand = new Random();
        int centerX = x + width / 2;
        int centerY = y + width / 2;
        int centerSize = width / 3;

        // Draw petals
        double angleIncrement = Math.PI * 2 / numPetals;
        double petalRadius = width / 3.5; 

        Color color1 = new Color(rand.nextInt(255) + 1, rand.nextInt(255) 
                + 1, rand.nextInt(255) + 1, rand.nextInt(201) + 55);
        Color color2 = new Color(rand.nextInt(255) + 1, rand.nextInt(255) 
                + 1, rand.nextInt(255) + 1, rand.nextInt(201) + 55);
        for (int i = 0; i < numPetals; i++) {
            double angle = i * angleIncrement;
            int petalX = centerX + (int) (petalRadius * Math.cos(angle));
            int petalY = centerY + (int) (petalRadius * Math.sin(angle));
            int petalSize = width / 2;
            if (i % 2 == 0) {
                g.setColor(color1);
            }
            else {
                g.setColor(color2);
            }
            g.fillOval(petalX - petalSize / 2, petalY - petalSize / 2, petalSize, petalSize);
        }
        // Draw flower center
        g.setColor(color);
        g.fillOval(centerX - centerSize / 2, centerY - centerSize / 2, centerSize, centerSize);
    }
}
