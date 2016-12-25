package ru.reeson2003.model.characters.coordinates;

/**
 * Created by reeson on 24.12.16.
 */
public class Coordinate {
    private int x;
    private int y;
    private int z;

    public Coordinate(int x, int y, int z) {
        setX(x);
        setY(y);
        setZ(z);
    }

    public void setX(int x) {
        if(x < CoordinateConstants.X_MIN)
            this.x = CoordinateConstants.X_MIN;
        else if (x > CoordinateConstants.X_MAX)
            this.x = CoordinateConstants.X_MAX;
        else
            this.x = x;
    }

    public void setY(int y) {
        if(y < CoordinateConstants.Y_MIN)
            this.y = CoordinateConstants.Y_MIN;
        else if (y > CoordinateConstants.Y_MAX)
            this.y = CoordinateConstants.Y_MAX;
        else
            this.y = y;
    }

    public void setZ(int z) {
        if(z < CoordinateConstants.Z_MIN)
            this.z = CoordinateConstants.Z_MIN;
        else if (z > CoordinateConstants.Z_MAX)
            this.z = CoordinateConstants.Z_MAX;
        else
            this.z = z;
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

    public int distance(Coordinate from) {
        int dX = this.x - from.x;
        int dY = this.y - from.y;
        int dZ = this.z - from.z;
        int result = (int) Math.sqrt(dX*dX + dY*dY + dZ*dZ);
        return result;
    }
}
