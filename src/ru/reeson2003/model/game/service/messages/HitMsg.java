package ru.reeson2003.model.game.service.messages;

import ru.reeson2003.model.game.characters.creatures.Creature;
import ru.reeson2003.model.game.service.AbonentTable;
import ru.reeson2003.model.game.service.Address;
import ru.reeson2003.model.game.service.exception.MyGameException;
import ru.reeson2003.model.game.service.exception.NonExistentAbilityKey;

import java.io.Serializable;

/**
 * Created by reeson on 16.12.16.
 */
public class HitMsg extends Msg implements Serializable{

    private static final long serialVersionUID = 1948681647777460401L;

    public HitMsg(Address from, Address to) {
        super(from, to);
    }

    public HitMsg() {
    }

    @Override
    public void exec() {
        Creature giveDamage = (Creature)AbonentTable.getAbonent(from);
        Creature getDamage = (Creature)AbonentTable.getAbonent(to);
        try {
            giveDamage.getAbility("Hit").use(getDamage);
        } catch (NonExistentAbilityKey e) {
            e.printStackTrace();
            System.err.println(e.getInfo());
        } catch (MyGameException e) {
            e.printStackTrace();
        }
    }
}
