package ru.reeson2003.view;


import ru.reeson2003.model.Interactable;
import ru.reeson2003.model.map.Position;

import java.util.List;

/**
 * Created by Toshiba on 27.11.2016.
 */
public class ConsoleView extends View {
    private static View instance = null;
    private ConsoleView(){}
    public static View getInstance() {
        if(instance == null)
            instance = new ConsoleView();
        return instance;
    }

    @Override
    public void show(Position position) {
        StringBuilder sb = new StringBuilder();
        sb.append("You are: ");
        sb.append(position);
        sb.append("\n Directions:");
        if (position.getSouth() != null) {
            sb.append("\nS: ");
            sb.append(position.getSouth());
        }
        if (position.getNorth() != null) {
            sb.append("\nN: ");
            sb.append(position.getNorth());
        }
        if (position.getEast() != null) {
            sb.append("\nE: ");
            sb.append(position.getEast());
        }
        if (position.getWest() != null) {
            sb.append("\nW: ");
            sb.append(position.getWest());
        }
        sb.append("\n Objects: {");
        List<Interactable> objs = position.getObjects();
        for (int i = 0; i < objs.size(); i++) {
            sb.append(i + 1);
            sb.append(".");
            sb.append(objs.get(i).getName());
            sb.append(", ");
        }
        if (objs.size() > 0)
            sb.deleteCharAt(sb.length() - 1);
        sb.append("}");
        System.out.println(sb.toString());
    }

    @Override
    public void show(List<Interactable> objects) {

    }

    @Override
    public void show(String text) {
        System.out.println(text);
    }
}
