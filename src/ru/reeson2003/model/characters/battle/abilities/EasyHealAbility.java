package ru.reeson2003.model.characters.battle.abilities;

import ru.reeson2003.model.characters.battle.Ability;
import ru.reeson2003.model.characters.battle.CoolDownAbility;
import ru.reeson2003.model.characters.creatures.Creature;

/**
 * Created by nimtego_loc on 21.12.2016.
 */
public class EasyHealAbility extends Ability {

    private int healSize;
    private int manaCost;

    public EasyHealAbility(Creature owner) {
        this.name = "Easy Heal";
        this.information = "Value of heal";
        this.owner = owner;
        this.msg = new EasyHealMsg(this.owner.getAddress());
        this.healSize = AbilityConstant.EASY_HEAL_COEFF + (owner.getIntellect() / 2);
        this.manaCost = AbilityConstant.EASY_HEAL_MANACOST;
        this.coolDownAbility = new CoolDownAbility(AbilityConstant.EASY_HEAL_COOLDOWN / (owner.getWisdom() / 10));  // 1 - один хит персеконд (спид атак 1 по умолчанию думаю надо дабл делать)
    }
    @Override
    public void use(Creature to) {
        if(to != null)
            msg.setTo(to.getAddress());
        else
            msg.setTo(owner.getAddress());
        if(coolDownAbility.getIsActive() && owner.getMana() - manaCost > 0) {
            coolDownAbility.use();
            msg.exec();
        }
    }
    
    @Override
    public String getInformation() {
        return  "" +information +" - " +healSize;
    }
}
