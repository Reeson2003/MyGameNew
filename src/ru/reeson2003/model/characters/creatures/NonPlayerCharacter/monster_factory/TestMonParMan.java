package ru.reeson2003.model.characters.creatures.NonPlayerCharacter.monster_factory;

import ru.reeson2003.model.characters.creatures.Parameters;

/**
 * Тестовый мэнеджер параметров для экспериментов.
 */
public class TestMonParMan extends MonsterParametersManager {
    public TestMonParMan() {
        super();
        instance = this;
    }

    @Override
    public Parameters getParameters(int monsterID) {
        switch (monsterID) {
            case 1:
                return new Parameters.ParametersBuilder().
                        maximumHealth(1000).
                        maximumMana(200).
                        healthRegen(5).
                        manaRegen(5).
                        physicalAttack(20).
                        physicalDefence(20).
                        magicAttack(10).
                        magicDefence(10).
                        criticalChance(30).
                        attackSpeed(2000).
                        evasion(5).
                        accuracy(5).
                        attackRange(5).
                        movingSpeed(20000).
                        build();
            case 2:
                return new Parameters.ParametersBuilder().
                        maximumHealth(200).
                        maximumMana(50).
                        healthRegen(2).
                        manaRegen(1).
                        physicalAttack(7).
                        physicalDefence(3).
                        magicAttack(2).
                        magicDefence(3).
                        criticalChance(10).
                        attackSpeed(700).
                        evasion(5).
                        accuracy(5).
                        attackRange(5).
                        movingSpeed(10000).
                        build();
            case 3:
                return new Parameters.ParametersBuilder().
                        maximumHealth(160).
                        maximumMana(30).
                        healthRegen(2).
                        manaRegen(5).
                        physicalAttack(10).
                        physicalDefence(8).
                        magicAttack(2).
                        magicDefence(1).
                        criticalChance(15).
                        attackSpeed(600).
                        evasion(5).
                        accuracy(5).
                        attackRange(5).
                        movingSpeed(7000).
                        build();
            default:
                return new Parameters.ParametersBuilder().
                        maximumHealth(50).
                        maximumMana(1).
                        healthRegen(1).
                        manaRegen(1).
                        physicalAttack(1).
                        physicalDefence(1).
                        magicAttack(0).
                        magicDefence(0).
                        criticalChance(1).
                        attackSpeed(100).
                        evasion(5).
                        accuracy(5).
                        attackRange(5).
                        movingSpeed(3000).
                        build();
        }
    }
}
