package ru.reeson2003.model.characters.battle.abilities;

import ru.reeson2003.model.characters.battle.BattleCalculator;
import ru.reeson2003.model.characters.battle.CoolDown;
import ru.reeson2003.model.characters.creatures.Creature;


/**
 * Created by reeson on 20.12.16.
 */
public class HitAbility extends AttackAbility {

    public HitAbility(Creature owner) {
        super(owner);
        this.name = "Hit";
        this.coolDown = new CoolDown(owner.getAttackSpeed());
        this.information = "Regular attack with weapon";
    }

    @Override
    public void use(Creature target) {
        if (target != null && target != owner) {
            if (owner.getCoordinate().distance(target.getCoordinate()) <= owner.getAttackRange()) {
                if (coolDown.isActive()) {
                    coolDown.use();
                    int damage = BattleCalculator.physicalDamage(owner, target, owner.getPhysicalAttack(),
                            true, true, true, true);
                    target.makeDamage(owner, damage);
                }
            }
        }
    }
}

