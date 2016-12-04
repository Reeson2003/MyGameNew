package ru.reeson2003.view;

import ru.reeson2003.model.Interactable;
import ru.reeson2003.model.map.Position;

import java.util.List;

/**
 * Created by Тоня on 18.10.2016.
 */
public abstract class View {
    protected View() {

    }
    public static View getInstance() {
        return ConsoleView.getInstance();
    }
    public abstract void show(String text);
    public abstract void show(Position position);
    public abstract void show(List<Interactable> objects);
}
