package ru.reeson2003.model.characters.battle;

import ru.reeson2003.model.characters.creatures.Creature;
import ru.reeson2003.model.service.AbonentTable;
import ru.reeson2003.model.service.Address;
import ru.reeson2003.model.service.Msg;

import java.io.Serializable;

/**
 * Created by Тоня on 29.12.2016.
 */
public class HealMsg extends Msg implements Serializable{
    private static final long serialVersionUID = 1L;

    public HealMsg(Address from, Address to) {
        super(from, to);
    }

    public HealMsg() {
    }

    @Override
    public void exec() {
        Creature giveHeal = (Creature) AbonentTable.getAbonent(from);
        Creature getHeal = (Creature)AbonentTable.getAbonent(to);
        giveHeal.addMana(-10);
        getHeal.addHealth(20);
    }
}
