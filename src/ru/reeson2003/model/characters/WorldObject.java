package ru.reeson2003.model.characters;

import ru.reeson2003.model.characters.coordinates.Coordinate;
import ru.reeson2003.model.service.Abonent;
import ru.reeson2003.model.service.AbonentTable;
import ru.reeson2003.model.service.Address;

/**
 * Created by reeson on 16.12.16.
 */
public abstract class WorldObject implements Abonent{

    protected final Address address;

    protected Coordinate coordinate;

    public WorldObject() {
        this.address = new Address();
        AbonentTable.addAbonent(this);
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    final public Address getAddress() {
        return address;
    }
}
