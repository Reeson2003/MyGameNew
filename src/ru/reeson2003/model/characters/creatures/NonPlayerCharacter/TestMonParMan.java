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
        return new Parameters.ParametersBuilder().constitution(5).
                strength(5).
                accuracy(5).
                agility(5).
                atackSpeed(5).
                attackRange(5).
                criticalChance(5).
                evasion(5).
                maximumHealth(100).
                build();
    }
}