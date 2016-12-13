package ru.reeson2003.model.characters.creatures.NonPlayerCharacter;

import ru.reeson2003.model.characters.creatures.ParametersController;

/**
 * Created by reeson on 13.12.16.
 */
public class MonsterFactoryTestImpl implements MonsterFactory {
    private MonsterParametersManager manager;
    public MonsterFactoryTestImpl() {
        manager = MonsterParametersManager.getInstance();
    }
    @Override
    public Monster getMonster(int monsterID) {
        return new Monster("Ant Qeen", ParametersController.getMonsterParametersController(monsterID));
    }
}
