package ru.reeson2003.model.characters.creatures.NonPlayerCharacter;

import ru.reeson2003.model.characters.creatures.Parameters;

/**
 * Created by reeson on 11.12.16.
 */
public class TestMonParMan extends MonsterParametersManager {
    public TestMonParMan() {
        super();
        instance = this;
    }

    @Override
    public Parameters getParameters(int monsterID) {
        return new Parameters.ParametersBuilder().
                constitution(5).
                strength(5).
                agility(5).
                wisdom(5).
                intellect(5).
                maximumHealth(1000).
                maximumMana(200).
                healthRegen(5).
                manaRegen(5).
                physicalAttack(20).
                physicalDefence(20).
                criticalChance(30).
                attackSpeed(10).
                evasion(5).
                accuracy(5).
                attackRange(5).
                movingSpeed(10).
                build();
    }
}
