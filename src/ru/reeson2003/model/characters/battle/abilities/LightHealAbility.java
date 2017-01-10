package ru.reeson2003.model.characters.battle.abilities;

import ru.reeson2003.model.characters.battle.CoolDown;
import ru.reeson2003.model.characters.creatures.Creature;

/**
 * Created by nimtego_loc on 21.12.2016.
 */
public class LightHealAbility extends Ability {
    private double healCoeff;

    public LightHealAbility(Creature owner) {
        super(owner);
        this.name = "Light Heal";
        this.information = "Heals target with ";
        this.healCoeff = AbilityConstants.LIGHT_HEAL_COEFF;
        this.manaCost = AbilityConstants.LIGHT_HEAL_MANA_COST;
        this.coolDown = new CoolDown(AbilityConstants.LIGHT_HEAL_COOL_DOWN);

    }

    private int calcHealSize() {
        return (int)healCoeff*owner.getMagicAttack();
    }

    @Override
    public String getInformation() {
        return information + calcHealSize() + " Hp's, consumes " + manaCost + " Mp's";
    }

    @Override
    public void use(Creature target) {
        if(target != null) {
            if (coolDown.isActive() && owner.getMana() - manaCost >= 0) {
                coolDown.use();
                owner.changeMana(-manaCost);
                int healSize = calcHealSize();
                target.changeHealth(healSize);
            }
        }
    }
}
