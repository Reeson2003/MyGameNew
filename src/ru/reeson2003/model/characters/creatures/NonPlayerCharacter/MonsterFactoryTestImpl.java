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
    public Creature getMonster(int monsterID) {
        if (monsterID == 1)
            return new Creature("Ant Qeen", ParametersController.getMonsterParametersController(monsterID));
        else if (monsterID == 2)
            return new Creature("Skeleton Raider", ParametersController.getMonsterParametersController(monsterID));
        else if (monsterID == 3)
            return new Creature("Goblin scout", ParametersController.getMonsterParametersController(monsterID));
        else
            return new Creature("Elpy", ParametersController.getMonsterParametersController(monsterID));
    }
}
