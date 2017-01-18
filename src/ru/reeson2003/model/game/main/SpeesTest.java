package ru.reeson2003.model.game.main;

import ru.reeson2003.model.game.characters.coordinates.Coordinate;
import ru.reeson2003.model.game.characters.coordinates.WorldConstants;
import ru.reeson2003.model.game.characters.coordinates.World;
import ru.reeson2003.model.game.characters.creatures.Creature;
import ru.reeson2003.model.game.characters.creatures.EquipType;
import ru.reeson2003.model.game.characters.creatures.NonPlayerCharacter.monster_factory.MonsterFactory;
import ru.reeson2003.model.game.characters.creatures.NonPlayerCharacter.monster_factory.MonsterFactoryTestImpl;
import ru.reeson2003.model.game.characters.creatures.Parameters;
import ru.reeson2003.model.game.characters.creatures.PlayerCharacter.PlayerCharacter;
import ru.reeson2003.model.game.characters.items.Equip;
import ru.reeson2003.model.game.service.TimeActivator;
import ru.reeson2003.model.game.view.SwingView;

import java.util.Date;
import java.util.Random;

/**
 * Created by reeson on 07.01.17.
 */
public class SpeesTest {
    public static void main(String[] args) throws InterruptedException {
        PlayerCharacter playerCharacter = PlayerCharacter.NewbiePlayerInstance("Pukan");
        Equip gloves = new Equip(EquipType.Gloves);
        gloves.setParameters(new Parameters.ParametersBuilder().movingSpeed(200).build());
        playerCharacter.putOn(gloves);
        MonsterFactory monsterFactory = new MonsterFactoryTestImpl();
        World.getInstance().place(playerCharacter);
        Random random = new Random();
        TimeActivator timeActivator = TimeActivator.getInstance();
        int size = 10000;
        Creature[] creatures = new Creature[size];
        for (int i = 0; i < creatures.length; i++) {
            creatures[i] = monsterFactory.getMonster(i % 4);
            creatures[i].setCoordinate(getCoordinate(random));
            World.getInstance().place(creatures[i]);
        }
        SwingView view = SwingView.getInstance();
        while (true) {
            view.clear();
            for (int i = 0; i < creatures.length; i++) {
                if (creatures[i].getMovement() == null)
                    creatures[i].move(getCoordinate(random));
                if (i < 5)
                    view.append(creatures[i]);
            }
            view.show();
            timeActivator.tick(new Date());
        }
    }

    public static Coordinate getCoordinate(Random random) {
        int x = random.nextInt((WorldConstants.WORLD_WIDTH * WorldConstants.LOC_DIM_PTS) - 1);
        int y = random.nextInt((WorldConstants.WORLD_LENGTH * WorldConstants.LOC_DIM_PTS) - 1);
        int z = random.nextInt((WorldConstants.WORLD_HEIGHT * WorldConstants.LOC_DIM_PTS) - 1);
        return new Coordinate(x, y, z);
    }
}
