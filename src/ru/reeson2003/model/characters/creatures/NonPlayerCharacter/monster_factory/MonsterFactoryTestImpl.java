package ru.reeson2003.model.characters.creatures.NonPlayerCharacter.monster_factory;

import ru.reeson2003.model.characters.creatures.NonPlayerCharacter.Monster;
import ru.reeson2003.model.characters.creatures.NonPlayerCharacter.MonsterParametersController;

/**
 * тестовая фабрика монстров для экспериментов.
 */
public class MonsterFactoryTestImpl implements MonsterFactory {
    private MonsterParametersManager manager;

    public MonsterFactoryTestImpl() {
        manager = MonsterParametersManager.getInstance();
    }

    @Override
    public Monster getMonster(int monsterID) {
        if (monsterID == 1)
            return new Monster("Ant Queen", new MonsterParametersController(monsterID));
        else if (monsterID == 2)
            return new Monster("Skeleton Raider", new MonsterParametersController(monsterID));
        else if (monsterID == 3)
            return new Monster("Goblin scout", new MonsterParametersController(monsterID));
        else
            return new Monster("Elpy", new MonsterParametersController(monsterID));
    }


}
