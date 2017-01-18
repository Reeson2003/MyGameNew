package ru.reeson2003.model.game.characters.creatures.NonPlayerCharacter.monster_factory;

import ru.reeson2003.model.game.characters.battle.abilities.FuryHitAbility;
import ru.reeson2003.model.game.characters.battle.abilities.HitAbility;
import ru.reeson2003.model.game.characters.coordinates.Coordinate;
import ru.reeson2003.model.game.characters.coordinates.World;
import ru.reeson2003.model.game.characters.creatures.NonPlayerCharacter.Monster;
import ru.reeson2003.model.game.characters.creatures.NonPlayerCharacter.MonsterParametersController;
import ru.reeson2003.model.game.characters.creatures.NonPlayerCharacter.art_intellect.AntQueenAI;

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
            monster.setBonusExperience(100);
            monster.addAbility(new HitAbility(monster));
            monster.addAbility(new FuryHitAbility(monster));
            monster.setCoordinate(new Coordinate(100_000, 100_000, 100_000));
            monster.setAi(new AntQueenAI(monster));
            World.getInstance().place(monster);
            return monster;
        }
        else if (monsterID == 2) {
            Monster monster = new Monster("Skeleton Raider", new MonsterParametersController(monsterID));
            monster.setBonusExperience(15);
            monster.setCoordinate(new Coordinate(100_000, 100_000, 100_000));
            World.getInstance().place(monster);
            return monster;
        }
        else if (monsterID == 3) {
            Monster monster = new Monster("Goblin scout", new MonsterParametersController(monsterID));
            monster.setBonusExperience(9);
            monster.setCoordinate(new Coordinate(100_000, 100_000, 100_000));
            World.getInstance().place(monster);
            return monster;
        }
        else {
            Monster monster = new Monster("Elpy", new MonsterParametersController(monsterID));
            monster.setBonusExperience(2);
            monster.setCoordinate(new Coordinate(100_000, 100_000, 100_000));
            World.getInstance().place(monster);
            return monster;
        }
    }


}
