package ru.reeson2003.model.main;

import ru.reeson2003.model.characters.coordinates.Coordinate;
import ru.reeson2003.model.characters.coordinates.WorldConstants;
import ru.reeson2003.model.characters.coordinates.World;
import ru.reeson2003.model.characters.creatures.Creature;
import ru.reeson2003.model.characters.creatures.NonPlayerCharacter.Monster;
import ru.reeson2003.model.characters.creatures.NonPlayerCharacter.MonsterFactory;
import ru.reeson2003.model.characters.creatures.NonPlayerCharacter.MonsterFactoryTestImpl;
import ru.reeson2003.model.characters.creatures.PlayerCharacter.PlayerCharacter;
import ru.reeson2003.view.SwingView;

import java.util.List;
import java.util.Random;

/**
 * Created by reeson on 07.01.17.
 */
public class WorldTest {
    public static void main(String[] args) {
        MonsterFactory monsterFactory = new MonsterFactoryTestImpl();
        Monster monster;
        Random random = new Random();
        int n = 1;
        for (int i = 0; i < 100; i++) {
            monster = monsterFactory.getMonster(n++);
            Coordinate coordinate = getCoordinate(random);
            monster.setCoordinate(coordinate);
            System.out.println(coordinate);
            World.getInstance().place(monster);
            if (n > 4)
                n = 1;
        }
        PlayerCharacter playerCharacter = PlayerCharacter.NewbiePlayerIstance("Nagibator");
        Coordinate coordinate = getCoordinate(random);
        playerCharacter.setCoordinate(coordinate);
        System.out.println(coordinate);
        List<Creature> creatures = World.getInstance().getVisibleCreatures(playerCharacter);
        SwingView view = SwingView.getInstance();
        view.clear();
        view.append(playerCharacter);
        for (Creature c : creatures) {
            view.append(c);
            int distance = c.getCoordinate().distance(playerCharacter.getCoordinate());
            view.append(new Integer(distance).toString());
        }
        view.show();
    }

    public static Coordinate getCoordinate(Random random) {
        int x = random.nextInt((WorldConstants.WORLD_WIDTH * WorldConstants.LOC_DIM_PTS) - 1);
        int y = random.nextInt((WorldConstants.WORLD_LENGTH * WorldConstants.LOC_DIM_PTS) - 1);
        int z = random.nextInt((WorldConstants.WORLD_HEIGHT * WorldConstants.LOC_DIM_PTS) - 1);
        return new Coordinate(x, y, z);
    }
}
