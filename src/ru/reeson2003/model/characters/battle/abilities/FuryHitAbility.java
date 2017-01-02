package ru.reeson2003.model.characters.battle.abilities;

import ru.reeson2003.model.characters.battle.Ability;
import ru.reeson2003.model.characters.battle.CoolDown;
import ru.reeson2003.model.characters.creatures.Creature;

/**
 * Created by nimtego_loc on 21.12.2016.
 */
public class FuryHitAbility extends Ability {

    private int damageAbility;

    public FuryHitAbility(Creature owner) {
        this.name = "Fury Hit";
        this.information = "Causes a loss";
        this.owner = owner;
        this.msg = new FuryHitMsg(this.owner.getAddress());
        this.damageAbility = AbilityConstants.FURY_HIT_COEFF + (owner.getStrength() / 2);
        this.coolDown =
                new CoolDown(AbilityConstants.FURY_HIT_COOLDOWN / owner.getAttackSpeed());
    }
    @Override
    public void use(Creature to) {
        msg.setTo(to.getAddress());
        if(coolDown.isActive()) {
            coolDown.use();
            msg.exec();
        }
    }

    public int getDamageAbility() {
        return damageAbility;
    }
}
