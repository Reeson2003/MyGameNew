package ru.reeson2003.model.characters.battle.abilities;

import ru.reeson2003.model.characters.creatures.Creature;

/**
 * Created by reeson on 10.01.17.
 */
public abstract class AttackAbility extends Ability {
    private int coolDownCoeff;
    protected AttackAbility(Creature owner) {
        super(owner);
    }

    protected int calcCoolDown() {
        return coolDownCoeff*owner.getAttackSpeed();
    }
}
