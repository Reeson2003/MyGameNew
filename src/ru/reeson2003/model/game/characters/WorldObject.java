package ru.reeson2003.model.game.characters;

import ru.reeson2003.model.game.characters.coordinates.Coordinate;
import ru.reeson2003.model.game.service.Abonent;
import ru.reeson2003.model.game.service.AbonentTable;
import ru.reeson2003.model.game.service.Address;

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

    @Override
    public int hashCode() {
        return this.address.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        WorldObject worldObject = (WorldObject)obj;
        return this.address.equals(worldObject.address);
    }
}
