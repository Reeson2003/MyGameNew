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
        if (monsterID == 1)
            return new Monster("Ant Qeen", ParametersController.getMonsterParametersController(monsterID));
        else if (monsterID == 2)
            return new Monster("Skeleton Raider", ParametersController.getMonsterParametersController(monsterID));
        else if (monsterID == 3)
            return new Monster("Goblin scout", ParametersController.getMonsterParametersController(monsterID));
        else
            return new Monster("Elpy", ParametersController.getMonsterParametersController(monsterID));
    }
}
