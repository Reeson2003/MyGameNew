package ru.reeson2003.model.characters.battle.abilities;

import ru.reeson2003.model.characters.battle.UnderAttackMsg;
import ru.reeson2003.model.characters.creatures.Creature;
import ru.reeson2003.model.service.AbonentTable;
import ru.reeson2003.model.service.Address;
import ru.reeson2003.model.service.exception.MyGameException;
import ru.reeson2003.model.service.messages.Msg;
import ru.reeson2003.model.service.messages.local_messages.DamageMsg;

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
            int damage;
            int manaCost;
            try {
                manaCost = giveDamage.getAbility("Fury Hit").manaCost;
                damage = giveDamage.getAbility("Fury Hit").damageAbility;
                giveDamage.changeMana(-manaCost);
                //test
                System.out.println(giveDamage.getName() +" FURY HIT TO "
                                    +getDamage.getName() +" " +damage);
                //test
                new DamageMsg(from, to, -damage).exec();
            } catch (MyGameException e) {
                e.printStackTrace();
            }
/**
 * for test
 */
            new UnderAttackMsg(from, to).exec();
        }
    }
}
