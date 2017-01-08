package ru.reeson2003.model.characters.coordinates;


/**
 * Coordinate class is immutable.
 */
public class Coordinate {
    private int x;
    private int y;
    private int z;

    /**
     * Returns instance with X, Y, Z from parameters.
     * @param x coordinate in "X" axis.
     * @param y coordinate in "Y" axis.
     * @param z coordinate in "Z" axis.
     */
    public Coordinate(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Returns instance with X, Y, Z initialized by 0.
     */
    public Coordinate() {
        this(0, 0, 0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    /**
     * Calculates distance from this coordinate to another.
     * @param from coordinate, to calculate distance to.
     * @return distance from this coordinate to another.
     */
    public int distance(Coordinate from) {
        long dX = this.x - from.x;
        long dY = this.y - from.y;
        long dZ = this.z - from.z;

        int result = (int) Math.sqrt(dX * dX + dY * dY + dZ * dZ);
        return result;
    }

    /**
     * Checks if this X, Y, Z is the same as another X, Y, Z.
     * @param c coordinate to check.
     * @return true if this X, Y, Z is the same as another X, Y, Z.
     */
    public boolean equals(Coordinate c) {
        return this.x == c.x && this.y == c.y && this.z == c.z;
    }

    @Override
    public String toString() {
        return "{X = " + x + ", Y = " + y + ", Z = " + z + "}";
    }
}
