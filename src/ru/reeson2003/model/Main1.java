package ru.reeson2003.model;

import ru.reeson2003.model.map.Direction;
import ru.reeson2003.model.map.Map;
import ru.reeson2003.model.map.MapFactory;
import ru.reeson2003.model.map.Position;
import ru.reeson2003.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Created by reeson on 04.12.16.
 */
public class Main1 {
    public static void main(String[] args) {
        Map map = MapFactory.getMap();
        View cv = View.getInstance();
        Position current = map.getStart();
        while (true) {
            char dir = getKey();
            if (dir == 'w')
                current = current.moveByDirection(Direction.North);
            else if (dir == 's')
                current = current.moveByDirection(Direction.South);
            else if (dir == 'a')
                current = current.moveByDirection(Direction.West);
            else if (dir == 'd')
                current = current.moveByDirection(Direction.East);
            else if (dir == 'q')
                break;
            cv.show(current);
        }

    }
    public static char getKey() {
        Reader rd = new BufferedReader(new InputStreamReader(System.in));
        char ch[] = new char[1];
        try {
            rd.read(ch);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ch[0];
    }
}
