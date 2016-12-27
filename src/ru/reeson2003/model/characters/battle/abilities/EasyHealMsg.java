package ru.reeson2003.model.characters.battle.abilities;

import ru.reeson2003.model.service.Address;
import ru.reeson2003.model.service.Msg;

/**
 * Created by nimtego_loc on 21.12.2016.
 */
public class EasyHealMsg extends Msg {

    public EasyHealMsg(Address from) {this(from, null);}
    public EasyHealMsg(Address from, Address to) {super(from, to);}

    @Override
    public void exec() {
        Creature giveHeal = (Creature)AbonentTable.getAbonent(from);
        Creature getHeal = (Creature)AbonentTable.getAbonent(to);
        int healCost =;
        int manaCost =;
        
        
        
        
        
        
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
    }
}
