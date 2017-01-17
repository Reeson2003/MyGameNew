package ru.reeson2003.model.characters.coordinates;

import ru.reeson2003.model.characters.WorldObject;
import ru.reeson2003.model.characters.creatures.Creature;
import ru.reeson2003.model.characters.items.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by reeson on 07.01.17.
 */
public class World {
    private static World instance = null;
    private static final int worldLength = WorldConstants.WORLD_LENGTH;
    private static final int worldWidth = WorldConstants.WORLD_WIDTH;
    private static final int worldHeight = WorldConstants.WORLD_HEIGHT;
    private static final int locationDimension = WorldConstants.LOC_DIM_PTS;

    /**
     * Singleton.
     * @return instance of World.
     */
    public static World getInstance() {
        if (instance == null)
            instance = new World();
        return instance;
    }

    private Location[][][] locations;

    /**
     * Returns instance. Creates new array of locations with size from WorldConstants class.
     * Creates new locations in each array element.
     */
    private World() {
        locations = new Location[worldHeight][worldLength][worldWidth];
        for (int i = 0; i < worldHeight; i++) {
            for (int j = 0; j < worldLength; j++) {
                for (int k = 0; k < worldWidth; k++) {
                    locations[i][j][k] = new Location();
                }
            }
        }
    }

    /**
     * Places an creature to the appropriate location according it's Coordinate.
     * Changes incorrect coordinate into correct state.
     * @param creature to place to the Location;
     */
    public void place(Creature creature) {
        Coordinate coordinate = correctCoordinate(creature.getCoordinate());
        creature.setCoordinate(coordinate);
        int x = coordinate.getX() / locationDimension;
        int y = coordinate.getY() / locationDimension;
        int z = coordinate.getZ() / locationDimension;
        try {
            locations[z][y][x].put(creature);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.err.println("World has not such coordinate: " + creature.getCoordinate().toString());
            return;
        }
    }

    /**
     * Places an item to the appropriate location according it's Coordinate.
     * Changes incorrect coordinate into correct state.
     * @param item to place to the Location;
     */
    public void place(Item item) {
        Coordinate coordinate = correctCoordinate(item.getCoordinate());
        item.setCoordinate(coordinate);
        int x = coordinate.getX() / locationDimension;
        int y = coordinate.getY() / locationDimension;
        int z = coordinate.getZ() / locationDimension;
        try {
            locations[z][y][x].put(item);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.err.println("World has not such coordinate: " + item.getCoordinate().toString());
            return;
        }
    }

    /**
     * Moves a creature to the appropriate location according Coordinate.
     * Changes incorrect coordinate into correct state.
     * @param creature to place to the Location;
     */
    public void move(Creature creature, Coordinate coordinate) {
        try {
            Coordinate newCoordinate = correctCoordinate(coordinate);
            int xOld = creature.getCoordinate().getX() / locationDimension;
            int yOld = creature.getCoordinate().getY() / locationDimension;
            int zOld = creature.getCoordinate().getZ() / locationDimension;
            int xNew = newCoordinate.getX() / locationDimension;
            int yNew = newCoordinate.getY() / locationDimension;
            int zNew = newCoordinate.getZ() / locationDimension;
            if (xNew == xOld && yNew == yOld && zNew == zOld)
                creature.setCoordinate(newCoordinate);
            else {
                locations[zOld][yOld][xOld].remove(creature);
                creature.setCoordinate(newCoordinate);
                locations[zNew][yNew][xNew].put(creature);
            }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            System.err.println("World has not such coordinate: " + coordinate.toString());
        }
    }

    /**
     * Moves an item to the appropriate location according Coordinate.
     * Changes incorrect coordinate into correct state.
     * @param item to place to the Location;
     */
    public void move(Item item, Coordinate coordinate) {
        try {
            Coordinate newCoordinate = correctCoordinate(coordinate);
            int xOld = item.getCoordinate().getX() / locationDimension;
            int yOld = item.getCoordinate().getY() / locationDimension;
            int zOld = item.getCoordinate().getZ() / locationDimension;
            int xNew = newCoordinate.getX() / locationDimension;
            int yNew = newCoordinate.getY() / locationDimension;
            int zNew = newCoordinate.getZ() / locationDimension;
            if (xNew == xOld && yNew == yOld && zNew == zOld)
                item.setCoordinate(newCoordinate);
            else {
                locations[zOld][yOld][xOld].remove(item);
                item.setCoordinate(newCoordinate);
                locations[zNew][yNew][xNew].put(item);
            }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            System.err.println("World has not such coordinate: " + coordinate.toString());
        }
    }

    /**
     * Gets creature's coordinate, and removes this creature from container.
     * @param creature creature to remove.
     */
    public void remove(Creature creature) {
        int x = creature.getCoordinate().getX() / locationDimension;
        int y = creature.getCoordinate().getY() / locationDimension;
        int z = creature.getCoordinate().getZ() / locationDimension;
        try {
            locations[z][y][x].remove(creature);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.err.println("World has not such coordinate: " + creature.getCoordinate().toString());
        }
    }

    /**
     * Creates new ArrayList of creatures. According radius, takes all creatures from object location
     * and from eight locations around object location(if they exists).
     * @param object to search creatures around.
     * @param radius in which creatures placed.
     * @return ArrayList of creatures.
     */
    public List<Creature> getCreaturesAround(final WorldObject object, int radius) {
        List<Creature> result = new ArrayList<>();
        int x = object.getCoordinate().getX() / locationDimension;
        int y = object.getCoordinate().getY() / locationDimension;
        int z = object.getCoordinate().getZ() / locationDimension;
        for (int i = z - 1; i <= z + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                for (int k = x - 1; k <= x + 1; k++) {
                    if (!(i < 0 || i > worldHeight - 1 ||
                            j < 0 || j > worldLength - 1 ||
                            k < 0 || k > worldWidth - 1))
                        result.addAll(locations[i][j][k].getCreaturesAround(object, radius));
                }

            }
        }
        return result;
    }

    /**
     * Creates new ArrayList of items. According radius, takes all items from object location
     * and from eight locations around object location(if they exists).
     * @param object to search items around.
     * @param radius in which items placed.
     * @return ArrayList of items.
     */
    public List<Item> getItemsAround(final WorldObject object, int radius) {
        List<Item> result = new ArrayList<>();
        int x = object.getCoordinate().getX() / locationDimension;
        int y = object.getCoordinate().getY() / locationDimension;
        int z = object.getCoordinate().getZ() / locationDimension;
        for (int i = z - 1; i < z + 1; i++) {
            for (int j = y - 1; j < y + 1; j++) {
                for (int k = x - 1; k < x + 1; k++) {
                    if (!(x < 0 || x > worldWidth - 1 ||
                            y < 0 || y > worldLength - 1 ||
                            z < 0 || z > worldHeight - 1))
                        result.addAll(locations[z][y][x].getItemsAround(object, radius));
                }

            }
        }
        return result;
    }

    /**
     * Creates new ArrayList of creatures. According visibility radius from WorldConstants class,
     * takes all creatures from object location and from eight locations around object location
     * (if they exists).
     * @param object to search creatures around.
     * @return ArrayList of creatures.
     */
    public List<Creature> getVisibleCreatures(WorldObject object) {
        return getCreaturesAround(object, WorldConstants.VIS_RADIUS_PTS);
    }

    /**
     * Creates new ArrayList of items. According visibility radius from WorldConstants class,
     * takes all items from object location and from eight locations around object location
     * (if they exists).
     * @param object to search items around.
     * @return ArrayList of items.
     */
    public List<Item> getVisibleItems(WorldObject object) {
        return getItemsAround(object, WorldConstants.VIS_RADIUS_PTS);
    }

    /**
     * Checks if the coordinates in range of World size.
     * If coordinate less than 0, sets 0 value, if coordinate more than world size,
     * sets world size value. Creates new instance of Coordinate with correct values.
     * @param coordinate coordinate to turn in correct state.
     * @return correct coordinate if parameter is incorrect.
     */
    private Coordinate correctCoordinate(Coordinate coordinate) {
        int x = coordinate.getX();
        if (x < 0)
            x = 0;
        if (x > worldWidth * locationDimension)
            x = worldWidth * locationDimension - 1;
        int y = coordinate.getY();
        if (y < 0)
            y = 0;
        if (y > worldLength * locationDimension)
            y = worldLength * locationDimension - 1;
        int z = coordinate.getZ();
        if (z < 0)
            z = 0;
        if (z > worldHeight * locationDimension)
            z = worldHeight * locationDimension - 1;
        return new Coordinate(x, y, z);
    }
}
