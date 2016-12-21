package ru.reeson2003.model.characters.battle.abilities;

import ru.reeson2003.model.characters.battle.CoolDownAbility;
import ru.reeson2003.model.characters.battle.HitMsg;
import ru.reeson2003.model.characters.creatures.Creature;


/**
 * Created by reeson on 20.12.16.
 */
public class HitAbility extends CoolDownAbility {

    public HitAbility(int coolDownMilliseconds) {
        super(coolDownMilliseconds);
    }

    public void use(Creature from, Creature to) {
        if(isActive) {
            super.use();
            new HitMsg(from.getAddress(), to.getAddress()).exec();
        }
    }
}
