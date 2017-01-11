package ru.reeson2003.model.characters.battle.abilities;

import ru.reeson2003.model.characters.battle.BattleCalculator;
import ru.reeson2003.model.characters.battle.CoolDown;
import ru.reeson2003.model.characters.creatures.Creature;

/**
 * Created by nimtego_loc on 21.12.2016.
 */
public class FuryHitAbility extends AttackAbility {
    private int coolDownCoeff;
    private int powerCoeff;

    public FuryHitAbility(Creature owner) {
        super(owner);
        this.name = "Fury Hit";
        this.information = "Powerful strike with any weapon type, power: ";
        this.owner = owner;
        this.powerCoeff = AbilityConstants.FURY_HIT_POWER_COEFF;
        this.manaCost = AbilityConstants.FURY_HIT_MANA_COST;
        this.coolDownCoeff = AbilityConstants.FURY_HIT_COOL_DOWN_COEFF;
        this.coolDown =
                new CoolDown(calcCoolDown());
    }

    private int calcPower() {
        return powerCoeff*owner.getPhysicalAttack();
    }

    @Override
    public String getInformation() {
        return information + calcPower() +", consumes " + manaCost + " Mp's";
    }

    @Override
    public void use(Creature target) {
        if (target != null && target != owner) {
            if (owner.getCoordinate().distance(target.getCoordinate()) <= owner.getAttackRange()) {
                if (coolDown.isActive() && owner.getMana() - manaCost >= 0) {
                    coolDown.setCoolDownMilliseconds(calcCoolDown());
                    coolDown.use();
                    int damage = powerCoeff*owner.getPhysicalAttack();
                    damage = BattleCalculator.physicalDamage(owner, target,damage,
                            true,true,false,true);
                    owner.changeMana(-manaCost);
                    target.makeDamage(owner, damage);
                }
            }
        }
    }

    public int getAbilityDamage() {
        return calcPower();
    }
}
