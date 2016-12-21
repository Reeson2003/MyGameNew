package ru.reeson2003.model.characters.battle.abilities;

import ru.reeson2003.model.characters.battle.Ability;
import ru.reeson2003.model.characters.battle.CoolDownAbility;
import ru.reeson2003.model.characters.creatures.Creature;

/**
 * Created by nimtego_loc on 21.12.2016.
 */
public class EasyHealAbility extends Ability {

    private int healSize;

    public EasyHealAbility(Creature owner) {
        this.name = "Easy Heal";
        this.information = "Value of heal";
        this.owner = owner;
        this.msg = new EasyHealMsg(this.owner.getAddress());
        this.healSize = /*AbilityConstant.EASY_HEAL_COEFF*/ 10 + (owner.getIntellect() / 2);
        this.coolDownAbility = /*AbilityConstant.EASY_HEAL_COOLDOWN*/ new CoolDownAbility(10000 / owner.getWisdom());  // 1 - один хит персеконд (спид атак 1 по умолчанию думаю надо дабл делать)
    }
    @Override
    public void use(Creature to) {
        if(to != null)
            msg.setTo(to.getAddress());
        if(coolDownAbility.getIsActive()) {
            coolDownAbility.use();
            msg.exec();
        }
    }
    @Override
    public String getInformation() {
        return  "" +information +" - " +healSize;
    }
}
