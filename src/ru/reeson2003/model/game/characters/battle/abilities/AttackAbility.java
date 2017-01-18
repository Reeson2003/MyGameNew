package ru.reeson2003.model.game.characters.battle.abilities;

import ru.reeson2003.model.game.characters.creatures.Creature;

/**
 * Created by reeson on 10.01.17.
 */
public abstract class AttackAbility extends Ability {
    protected int coolDownCoeff;
    protected AttackAbility(Creature owner) {
        super(owner);
    }

    protected int calcCoolDown() {
        return coolDownCoeff*owner.getAttackSpeed();
    }
}
