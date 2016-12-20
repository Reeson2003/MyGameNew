package ru.reeson2003.model.characters;

import ru.reeson2003.model.service.Abonent;
import ru.reeson2003.model.service.AbonentTable;
import ru.reeson2003.model.service.Address;

/**
 * Created by reeson on 16.12.16.
 */
public abstract class WorldObject implements Abonent{
    protected final Address address;
    protected ActionsAndStatus actionsAndStatus;

    public WorldObject() {
        this.address = new Address();
        AbonentTable.addAbonent(this);
        this.actionsAndStatus = new ActionsAndStatus();
    }

    @Override
    final public Address getAddress() {
        return address;
    }
}
