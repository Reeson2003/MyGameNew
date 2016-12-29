package ru.reeson2003.model.characters.battle.abilities;

import ru.reeson2003.model.characters.battle.CoolDownAbility;
import ru.reeson2003.model.characters.battle.HealMsg;
import ru.reeson2003.model.characters.creatures.Creature;

/**
 * Created by Тоня on 29.12.2016.
 */
public class HealAbility extends CoolDownAbility {
    protected HealAbility(int coolDownMilliseconds) {
        super(coolDownMilliseconds);
    }

    public void use(Creature from, Creature to) {
        if(isActive) {
            super.use();
            new HealMsg(from.getAddress(), to.getAddress()).exec();
        }
    }
}
