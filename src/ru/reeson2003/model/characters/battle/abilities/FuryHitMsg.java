package ru.reeson2003.model.characters.battle.abilities;

import ru.reeson2003.model.characters.battle.UnderAttackMsg;
import ru.reeson2003.model.characters.creatures.Creature;
import ru.reeson2003.model.service.AbonentTable;
import ru.reeson2003.model.service.Address;
import ru.reeson2003.model.service.Msg;

/**
 * Created by nimtego_loc on 21.12.2016.
 */
public class FuryHitMsg extends Msg {

    public FuryHitMsg(Address from) {this(from, null);}
    public FuryHitMsg(Address from, Address to) {super(from, to);}

    @Override
    public void exec() {
        if (to != null) {
            Creature giveDamage = (Creature) AbonentTable.getAbonent(from);					// HashMap<AbilityID, Ability> abilityMap = new HashMap<>();
            Creature getDamage = (Creature)AbonentTable.getAbonent(to);		// ArrayList<Ability> abilityList = new ArrayList<>();
//            Ability furyHitAbility = giveDamage.getAbilityByKey(1);
            int damage = 100; // furyHitAbility.getDamageAbility() - getDamage.getPhysicalDefence()/10;
            if (damage < 2)
                damage = 2;
            getDamage.addHealth(-damage);
            System.out.println(giveDamage.getName() + " hits " +damage);
/**
 * for test
 */
            new UnderAttackMsg(from, to).exec();
        }
        System.out.println("Need Target");
    }
}
