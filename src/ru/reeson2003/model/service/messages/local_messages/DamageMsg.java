package ru.reeson2003.model.service.messages.local_messages;

import ru.reeson2003.model.characters.creatures.Creature;
import ru.reeson2003.model.service.AbonentTable;
import ru.reeson2003.model.service.Address;
import ru.reeson2003.model.service.messages.Msg;

/**
 * Created by reeson on 05.01.17.
 */
public class DamageMsg extends Msg {
    private int damage;
    public DamageMsg(Address from, Address to, int damage) {
        super(from, to);
        this.damage = damage;
    }

    @Override
    public void exec() {
        Creature getDamage = (Creature)AbonentTable.getAbonent(to);
        Creature giveDamage = (Creature)AbonentTable.getAbonent(from);
        getDamage.changeHealth(damage);
        if (getDamage.kill()) {
            giveDamage.addExperience(getDamage.getExperienceForKill());
            getDamage.subtractExperienceForKill();
        }
    }
}
