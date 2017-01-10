package ru.reeson2003.model.service.messages;


import ru.reeson2003.model.characters.creatures.Creature;
import ru.reeson2003.model.service.AbonentTable;
import ru.reeson2003.model.service.Address;
import ru.reeson2003.model.service.exception.MyGameException;
import ru.reeson2003.model.service.exception.NonExistentAbilityKey;

/**
 * Created by nimtego_loc on 21.12.2016.
 */
public class FuryHitMsg extends Msg {
    private static final long serialVersionUID = 7121336970002515032L;
    private int damage;

    public FuryHitMsg(Address from, Address to) {
        super(from, to);
        this.damage = damage;
    }

    @Override
    public void exec() {
        Creature giveDamage = (Creature) AbonentTable.getAbonent(from);
        Creature getDamage = (Creature)AbonentTable.getAbonent(to);
        try {
            giveDamage.getAbility("Fury Hit").use(getDamage);
        } catch (NonExistentAbilityKey e) {
            e.printStackTrace();
            System.err.println(e.getInfo());
        } catch (MyGameException e) {
            e.printStackTrace();
        }
    }

}
