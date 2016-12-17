package ru.reeson2003.model.characters;

import ru.reeson2003.model.service.Abonent;
import ru.reeson2003.model.service.AbonentTable;
import ru.reeson2003.model.service.Address;

/**
 * Created by reeson on 16.12.16.
 */
public abstract class WorldObject implements Abonent{

    protected final Address address;

    public WorldObject() {
        this.address = new Address();
        AbonentTable.addAbonent(this);
    }

    @Override
    public Address getAddress() {
        return address;
    }
}
