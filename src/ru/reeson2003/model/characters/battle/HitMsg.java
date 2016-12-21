package ru.reeson2003.model.characters.battle;

import ru.reeson2003.model.characters.creatures.Creature;
import ru.reeson2003.model.service.AbonentTable;
import ru.reeson2003.model.service.Address;
import ru.reeson2003.model.service.Msg;

import java.util.Random;

/**
 * Created by reeson on 16.12.16.
 */
public class HitMsg extends Msg {
    public HitMsg(Address from, Address to) {
        super(from, to);
    }

    @Override
    public void exec() {
        Creature giveDamage = (Creature)AbonentTable.getAbonent(from);
        Creature getDamage = (Creature)AbonentTable.getAbonent(to);
        int damage = giveDamage.getPhysicalAttack() - getDamage.getPhysicalDefence()/10;
        if (damage < 2)
            damage = 2;
        Random random = new Random();
        int dispersion = 40;
        int check = random.nextInt(100);
        if (check >=0 && check < giveDamage.getCriticalChance())
            damage *= 2;
        check = random.nextInt(100);
        if (check >=0 && check < getDamage.getEvasion() - giveDamage.getAccuracy()/10)
            damage = 0;
        damage = damage*(100 - dispersion/2 + random.nextInt(dispersion))/100;
        getDamage.addHealth(-damage);
        System.out.println(giveDamage.getName() + " hits " +damage);
/**
 * for test
 */
        new UnderAttackMsg(from, to).exec();
    }
}
