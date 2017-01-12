package ru.reeson2003.model.characters.creatures.NonPlayerCharacter.monster_factory;

import ru.reeson2003.model.characters.battle.abilities.FuryHitAbility;
import ru.reeson2003.model.characters.battle.abilities.HitAbility;
import ru.reeson2003.model.characters.coordinates.Coordinate;
import ru.reeson2003.model.characters.creatures.NonPlayerCharacter.Monster;
import ru.reeson2003.model.characters.creatures.NonPlayerCharacter.MonsterParametersController;
import ru.reeson2003.model.characters.creatures.NonPlayerCharacter.art_intellect.AntQueenAI;

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
        if (monsterID == 1) {
            Monster monster = new Monster("Ant Queen", new MonsterParametersController(monsterID));
            monster.setBonusExperience(1000);
            monster.addAbility(new HitAbility(monster));
            monster.addAbility(new FuryHitAbility(monster));
            monster.setCoordinate(new Coordinate(100_000, 100_000, 100_000));
            monster.setAi(new AntQueenAI(monster));
            return monster;
        }
        else if (monsterID == 2)
            return new Monster("Skeleton Raider", new MonsterParametersController(monsterID));
        else if (monsterID == 3)
            return new Monster("Goblin scout", new MonsterParametersController(monsterID));
        else
            return new Monster("Elpy", new MonsterParametersController(monsterID));
    }


}
