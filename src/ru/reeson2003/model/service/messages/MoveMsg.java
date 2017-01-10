package ru.reeson2003.model.service.messages;

import ru.reeson2003.model.characters.coordinates.Coordinate;
import ru.reeson2003.model.characters.creatures.Creature;
import ru.reeson2003.model.service.AbonentTable;
import ru.reeson2003.model.service.Address;

/**
 * Created by reeson on 10.01.17.
 */
public class MoveMsg extends Msg {
    private static final long serialVersionUID = 3276624815712914764L;

    private Coordinate destination;

    public MoveMsg(Address from, Address to, Coordinate destination) {
        super(from, to);
        this.destination = destination;
    }

    public void setDestination(Coordinate destination) {
        this.destination = destination;
    }

    @Override
    public void exec() {
        Creature creature = (Creature) AbonentTable.getAbonent(from);
        creature.move(destination);
        System.out.println(destination);
    }
}
