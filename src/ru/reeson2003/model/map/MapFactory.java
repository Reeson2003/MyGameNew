package ru.reeson2003.model.map;

import javax.swing.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Тоня on 06.10.2016.
 */
public class MapFactory {
    Position start;
    List<Location> locations;

    public static Map getMap() {
        MapFactory mf = new MapFactory();
        Map res = new Map();
        res.setLocations(mf.locations);
        res.setStart(mf.start);
        return res;
    }

    public MapFactory() {
        this.locations = new LinkedList<>();
        makeMap();
    }

    private void makeMap() {
        final Location forest = LocationFactory.getLocation("Forest","Лес", 4, 4);
        forest.setIcon(new ImageIcon("icons/mainpics/fantasy_forest.jpg"));
        final Location field  = LocationFactory.getLocation("Field","Поле", 5, 5);
        field.setIcon(new ImageIcon("icons/mainpics/fantasy_field.jpg"));
        final Location dungeon = LocationFactory.getLocation("Dungeon","Подземелье", 3, 2);
        dungeon.setIcon(new ImageIcon("icons/mainpics/fantasy_dungeon.jpg"));
        start = field.getPosition(2, 0);
        field.getPosition(0,1).setWest(forest.getPosition(3,3));
        forest.getPosition(3,3).setEast(field.getPosition(0,1));
        field.getPosition(4,3).setEast(dungeon.getPosition(0,1));
        dungeon.getPosition(0,1).setWest(field.getPosition(4,3));
        dungeon.getPosition(1,0).deleteDirectionTwoSide(Direction.South);
        final Location smallHouse = new LocationFactory("House", "Избушка", 2,2).getLocation();
        forest.getPosition(0,0).setWest(smallHouse.getPosition(1,0));
        smallHouse.getPosition(1,0).setEast(forest.getPosition(0,0));
    }
}
