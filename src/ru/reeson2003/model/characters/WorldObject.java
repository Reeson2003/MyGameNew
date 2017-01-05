package ru.reeson2003.model.characters;

import ru.reeson2003.model.characters.coordinates.Coordinate;
import ru.reeson2003.model.service.Abonent;
import ru.reeson2003.model.service.AbonentTable;
import ru.reeson2003.model.service.Address;

/**
 * Superclass for items and creatures
 */
public abstract class WorldObject implements Abonent {
    protected final Address address;
    protected Coordinate coordinate;
    protected String name;

    public WorldObject() {
        this.address = new Address();
        AbonentTable.addAbonent(this);
        this.coordinate = new Coordinate();
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public String getName() {
        return name;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void remove() {
        AbonentTable.removeAbonent(this);
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    final public Address getAddress() {
        return address;
    }
}
