package ru.reeson2003.model.main;

import ru.reeson2003.model.characters.coordinates.Coordinate;
import ru.reeson2003.model.characters.coordinates.CoordinateConstants;
import ru.reeson2003.model.characters.coordinates.Movement;
import ru.reeson2003.model.characters.coordinates.World;
import ru.reeson2003.model.characters.creatures.EquipType;
import ru.reeson2003.model.characters.creatures.Parameters;
import ru.reeson2003.model.characters.creatures.PlayerCharacter.PlayerCharacter;
import ru.reeson2003.model.characters.items.Equip;
import ru.reeson2003.model.service.TimeActivator;
import ru.reeson2003.view.SwingView;

import java.util.Date;
import java.util.Random;

/**
 * Created by reeson on 07.01.17.
 */
public class SpeesTest {
    public static void main(String[] args) throws InterruptedException {
        PlayerCharacter playerCharacter = PlayerCharacter.NewbiePlayerIstance("Pukan");
        Equip gloves = new Equip(EquipType.Gloves);
        gloves.setParameters(new Parameters.ParametersBuilder().movingSpeed(2000).build());
        playerCharacter.putOn(gloves);
        World.getInstance().place(playerCharacter);
        Random random = new Random();
        TimeActivator timeActivator = TimeActivator.getInstance();
        SwingView view = SwingView.getInstance();
        while (true) {
            Coordinate to = getCoordinate(random);
            Coordinate from = playerCharacter.getCoordinate();
            System.out.println(to);
            Movement movement = new Movement(playerCharacter,to);
            TimeActivator.getInstance().addTimeDependent(movement);
            while (!playerCharacter.getCoordinate().equals(to)) {
                TimeActivator.getInstance().tick(new Date());
                view.clear().append(playerCharacter).append("From:" + from).append("To:" + to).show();
            }
        }
    }

    public static Coordinate getCoordinate(Random random) {
        int x = random.nextInt((CoordinateConstants.WORLD_WIDTH * CoordinateConstants.LOCATION_DIMENSION) - 1);
        int y = random.nextInt((CoordinateConstants.WORLD_LENGTH * CoordinateConstants.LOCATION_DIMENSION) - 1);
        int z = random.nextInt((CoordinateConstants.WORLD_HEIGHT * CoordinateConstants.LOCATION_DIMENSION) - 1);
        return new Coordinate(x, y, z);
    }
}
