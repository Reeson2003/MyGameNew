package ru.reeson2003.model.characters.battle.abilities;

import ru.reeson2003.model.characters.battle.Ability;
import ru.reeson2003.model.characters.battle.CoolDownAbility;
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
        this.damageAbility = /*AbilityConstant.FURY_HIT_COEFF*/100 + (owner.getStrength() / 2);
        this.coolDownAbility =
                /*AbilityConstant.FURY_HIT_COOLDOWN*/new CoolDownAbility(5000 / owner.getAttackSpeed());
        // 1 - один хит персеконд (спид атак 1 по умолчанию думаю надо дабл делать)
    }
    @Override
    public void use(Creature to) {
        msg.setTo(to.getAddress());
        if(coolDownAbility.getIsActive()) {
            coolDownAbility.use();
            msg.exec();
        }
    }
    @Override
    public String getInformation() {
        return  "" +information +" - " +damageAbility;
    }
    public int getDamageAbility() {
        return damageAbility;
    }
}
