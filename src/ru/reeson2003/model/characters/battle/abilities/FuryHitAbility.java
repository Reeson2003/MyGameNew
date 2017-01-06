package ru.reeson2003.model.characters.battle.abilities;

import ru.reeson2003.model.characters.battle.CoolDown;
import ru.reeson2003.model.characters.creatures.Creature;
import ru.reeson2003.model.service.exception.NoTargetException;

/**
 * Created by nimtego_loc on 21.12.2016.
 */
public class FuryHitAbility extends Ability {

    public FuryHitAbility(Creature owner) {
        this.name = "Fury Hit";
        this.information = "Causes a loss";
        this.owner = owner;
        this.damageAbility = AbilityConstants.FURY_HIT_COEFF;
        this.manaCost = AbilityConstants.FURY_HIT_MANACOST;
        this.msg = new FuryHitMsg(this.owner.getAddress(), this.damageAbility);
        this.coolDown =
                new CoolDown(AbilityConstants.FURY_HIT_COOLDOWN / owner.getAttackSpeed());
    }
    @Override
    public void use(Creature to) throws NoTargetException {
        if (to == null) {
            throw new NoTargetException();
        }
        msg.setTo(to.getAddress());
        if(coolDown.isActive() && owner.getMana() - manaCost >= 0) {
            coolDown.use();
            msg.exec();
        }
    }

    public int getDamageAbility() {
        return damageAbility;
    }
}
