package ru.reeson2003.model.characters.coordinates;

/**
 * Created by reeson on 25.12.16.
 */
public class WorldConstants {
    /**
     * Count of locations on "X" axis.
     */
    public static final int WORLD_WIDTH = 10;
    /**
     * Count of locations on "Y" axis.
     */
    public static final int WORLD_LENGTH = 10;
    /**
     * Count of locations on "Z" axis.
     */
    public static final int WORLD_HEIGHT = 2;
    /**
     * Dimension (X, Y, Z) of one location in meters.
     */
    public static final int LOCATION_SIZE = 1_000;
    /**
     * Radius of visibility. In this radius player can see
     * and interact with objects around. Meters.
     */
    public static final int VISIBILITY_RADIUS = 1000;
    /**
     * Current coordinate scale in points per meter.
     */
    public static final int SCALE = 100;
    /**
     * Current count of points in location dimension.
     */
    public static final int LOC_DIM_PTS = LOCATION_SIZE*SCALE;
    /**
     * Current visibility radius in points.
     */
    public static final int VIS_RADIUS_PTS = VISIBILITY_RADIUS*SCALE;
}
