package ru.reeson2003.model.characters.battle;

import ru.reeson2003.model.characters.creatures.Creature;
import ru.reeson2003.model.service.Abonent;
import ru.reeson2003.model.service.AbonentTable;
import ru.reeson2003.model.service.Address;
import ru.reeson2003.model.service.Msg;

/**
 * Created by reeson on 17.12.16.
 */
public class UnderAttackMsg extends Msg {

    public UnderAttackMsg(Address from, Address to) {
        super(from, to);
    }

    @Override
    public void exec() {
        Abonent abonentFrom = AbonentTable.getAbonent(from);
        Abonent abonentTo = AbonentTable.getAbonent(to);
        Creature from = (Creature)abonentFrom;
        Creature to = (Creature)abonentTo;
        to.setTarget(from);
    }
}
