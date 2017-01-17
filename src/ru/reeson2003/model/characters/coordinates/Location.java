package ru.reeson2003.model.characters.coordinates;

import ru.reeson2003.model.characters.WorldObject;
import ru.reeson2003.model.characters.creatures.Creature;
import ru.reeson2003.model.characters.items.Item;
import ru.reeson2003.model.service.Address;

import java.util.*;

/**
 * Container for "Item" and "Creature" objects.
 */
public class Location {
    /**
     * HashMap collection for "Creature" objects.
     */
    private Map<Address, Creature> creatures;
    /**
     * HashMap collection for "Item" objects.
     */
    private Map<Address, Item> items;

    /**
     *Returns instance. Initializes creatures and items Maps by HashMap.
     */
    public Location() {
        this.creatures = new HashMap<>();
        this.items = new HashMap<>();
    }

    /**
     * Puts a "Creature" object in container.
     * @param creature wrong object type verification, null verification.
     */
    public void put(Creature creature) {
        try {
            this.creatures.put(creature.getAddress(), creature);
        } catch (ClassCastException e) {
            e.printStackTrace();
            System.err.println("Location. Wrong key type:" + creature.getClass().getName());
            return;
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.err.println("Location. Key is null.");
            return;
        }
    }

    /**
     * Removes a "Creature" object in container.
     * @param creature wrong object type verification, null verification.
     */
    public void remove(Creature creature) {
        try {
            creatures.remove(creature.getAddress());
        } catch (ClassCastException e) {
            e.printStackTrace();
            System.err.println("Location. Wrong key type:" + creature.getClass().getName());
            return;
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.err.println("Location. Key is null.");
            return;
        }
    }

    /**
     * Puts an "Item" object in container.
     * @param item wrong object type verification, null verification.
     */
    public void put(Item item) {
        try {
            this.items.put(item.getAddress(), item);
        } catch (ClassCastException e) {
            e.printStackTrace();
            System.err.println("Location. Wrong key type:" + item.getClass().getName());
            return;
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.err.println("Location. Key is null.");
            return;
        }
    }

    /**
     * Puts an "Item" object in container.
     * @param item wrong object type verification, null verification.
     */
    public void remove(Item item) {
        try {
            this.items.remove(item.getAddress());
        } catch (ClassCastException e) {
            e.printStackTrace();
            System.err.println("Location. Wrong key type:" + item.getClass().getName());
            return;
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.err.println("Location. Key is null.");
            return;
        }
    }

    /**
     * Creates "LinkedList<Creatures>", adds Creatures in the list.
     * @param object to get "Creature" objects around from.
     * @param radius from object, to get "Creature" objects around.
     * @return "List<Creature>" of creatures in radius from object.
     * @throws IllegalArgumentException if radius is negative.
     */
    public List<Creature> getCreaturesAround(WorldObject object, int radius) throws IllegalArgumentException {
        if (radius < 0)
            throw new IllegalArgumentException("Location. Radius does not be negative.");
        else {
            List<Creature> result = new LinkedList<>();
            Coordinate from = object.getCoordinate();
            for (Map.Entry<Address, Creature> pair : creatures.entrySet()) {
                if (from.distance(pair.getValue().getCoordinate()) <= radius)
                    result.add(pair.getValue());
            }
            return result;
        }
    }

    /**
     * Creates "LinkedList<Item>", adds Items in the list.
     * @param object to get "Item" objects around from.
     * @param radius from object, to get "Item" objects around.
     * @return "List<Items>" of items in radius from object.
     * @throws IllegalArgumentException if radius is negative.
     */
    public List<Item> getItemsAround(WorldObject object, int radius) throws IllegalArgumentException {
        if (radius < 0)
            throw new IllegalArgumentException("Location. Radius does not be negative.");
        else {
            List<Item> result = new LinkedList<>();
            Coordinate from = object.getCoordinate();
            for (Map.Entry<Address, Item> pair : items.entrySet()) {
                if (from.distance(pair.getValue().getCoordinate()) <= radius)
                    result.add(pair.getValue());
            }
            return result;
        }
    }
}
