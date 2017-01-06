package ru.reeson2003.model.characters.battle.abilities;

import ru.reeson2003.model.characters.battle.UnderAttackMsg;
import ru.reeson2003.model.characters.creatures.Creature;
import ru.reeson2003.model.service.AbonentTable;
import ru.reeson2003.model.service.Address;
import ru.reeson2003.model.service.exception.MyGameException;
import ru.reeson2003.model.service.messages.Msg;

/**
 * Created by nimtego_loc on 21.12.2016.
 */
public class FuryHitMsg extends Msg {
    private int damage;

    public FuryHitMsg(Address from, int damage) {
        this(from, null, damage);
    }

    public FuryHitMsg(Address from, Address to, int damage) {
        super(from, to);
        this.damage = damage;
    }

    @Override
    public void exec() {
        if (to != null) {
            Creature giveDamage = (Creature) AbonentTable.getAbonent(from);
            Creature getDamage = (Creature) AbonentTable.getAbonent(to);
            try {
                giveDamage.changeMana(-giveDamage.getAbility("Fury Hit").manaCost);
            } catch (MyGameException e) {
                e.printStackTrace();
            }
            try {
                getDamage.changeHealth(-giveDamage.getAbility("Fury Hit").damageAbility);
            } catch (MyGameException e) {
                e.printStackTrace();
            }
            System.out.println(giveDamage.getName() + " hits " + damage);
/**
 * for test
 */
            new UnderAttackMsg(from, to).exec();
        }
    }
}
