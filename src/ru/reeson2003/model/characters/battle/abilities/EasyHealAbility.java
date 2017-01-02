package ru.reeson2003.model.characters.battle.abilities;

import ru.reeson2003.model.characters.battle.Ability;
import ru.reeson2003.model.characters.battle.CoolDown;
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
        this.healSize = AbilityConstants.EASY_HEAL_COEFF + (owner.getIntellect() / 2);
        this.manaCost = AbilityConstants.EASY_HEAL_MANACOST;
        this.msg = EasyHealMsg.getEasyHealMsg(healSize, manaCost);
        this.msg.setFrom(this.owner.getAddress());
        this.coolDown = new CoolDown(AbilityConstants.EASY_HEAL_COOLDOWN);  // 1 - один хит персеконд (спид атак 1 по умолчанию думаю надо дабл делать)
        this.information = name + ". Value of heal: " + healSize + ". Mana cost: " + manaCost + ".";
    }

    @Override
    public void use(Creature to) {
        if(to != null)
            msg.setTo(to.getAddress());
        else
            msg.setTo(owner.getAddress());
        if(coolDown.isActive() && owner.getMana() - manaCost > 0) {
            coolDown.use();
            msg.exec();
        }
    }
}
