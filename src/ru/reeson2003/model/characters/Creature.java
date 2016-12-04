package ru.reeson2003.model.characters;

import ru.reeson2003.model.Interactable;
import ru.reeson2003.model.map.Direction;
import ru.reeson2003.model.map.Position;

/**
 * Created by reeson on 04.12.16.
 */
public abstract class Creature implements Interactable {
    protected String name = "";
    protected String info = "";
    protected Position position;
    protected Parameters parameters;

    protected Creature() {
    }

    public Parameters getParameters() {
        return parameters;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public String getInfo() {
        return info;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void move(Direction direction) {
        setPosition(position.moveByDirection(direction));
    }

    public void setPosition(Position position) {
        if (this.position != null)
            this.position.removeObject(this);
        this.position = position;
        this.position.addObject(this);
    }

    public void setName(String name) {
        if (name != null)
            this.name = name;
    }

    public void setInfo(String info) {
        if (info != null)
            this.info = info;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

}
