package ru.reeson2003.model.characters.coordinates;


import java.io.Serializable;

/**
 * The class {@code Coordinate} is the simple container
 * of the <b>X</b>,<b>Y</b>,<b>Z</b> coordinates of point.
 */
public class Coordinate implements Serializable {
    /** use serialVersionUID for interoperability */
    private static final long serialVersionUID = 637319357842271410L;
    /** The {@code int} value on the <b>OX</b> axis. */
    private int x;
    /** The {@code int} value on the <b>OY</b> axis. */
    private int y;
    /** The {@code int} value on the <b>OZ</b> axis. */
    private int z;

    /**
     * Initializes new {@code Coordinate} {@link #x},
     * {@link #y}, {@link #z} values with
     * parameters values.
     * @param x value on the <b>OX</b> axis.
     * @param y value on the <b>OY</b> axis.
     * @param z value on the <b>OZ</b> axis.
     */
    public Coordinate(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Initializes new {@code Coordinate} {@link #x},
     * {@link #y}, {@link #z} values with {@code 0}.
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
     * @param from {@code Coordinate} to calculate distance to.
     * @return {@code int} value of distance this this {@code Coordinate} and
     * argument {@code Coordinate}.
     */
    public int distance(Coordinate from) {
        long dX = this.x - from.x;
        long dY = this.y - from.y;
        long dZ = this.z - from.z;
        int result = (int) Math.sqrt(dX * dX + dY * dY + dZ * dZ);
        return result;
    }

    /**
     * Checks if this {@link #x} equals argument {@link #x},
     * this {@link #y} equals argument {@link #y} and
     * this {@link #z} equals argument {@link #z}.
     * @param c {@code Coordinate} to check.
     * @return {@code true} if this {@link #x} equals argument {@link #x},
     * this {@link #y} equals argument {@link #y} and
     * this {@link #z} equals argument {@link #z}, otherwise {@code false}.
     */
    public boolean equals(Coordinate c) {
        return this.x == c.x && this.y == c.y && this.z == c.z;
    }

    @Override
    public String toString() {
        return "{X = " + x + ", Y = " + y + ", Z = " + z + "}";
    }
}
