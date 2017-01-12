package ru.reeson2003.model.characters.creatures.NonPlayerCharacter.art_intellect.behavior;

import ru.reeson2003.model.characters.coordinates.Coordinate;
import ru.reeson2003.model.characters.creatures.Creature;

import java.util.Date;
import java.util.Random;

/**
 * Created by reeson on 12.01.17.
 */
public class CalmBehavior extends MonsterBehavior {
    private static int MOVEMENT_RADIUS = 2_000;
    private static int INTERVAL_MIN = 5_000;
    private static int INTERVAL_MAX = 20_000;
    private Date lastMove;
    private int interval;
    private Coordinate center;
    private Random random;

    public CalmBehavior(Creature creature) {
        super(creature);
        center = creature.getCoordinate();
        random = new Random(creature.getAddress().getAbonentId() + new Date().getTime());
        updateInterval();
    }

    private void randomMove(Date date) {
        if (lastMove == null)
            lastMove = date;
        if (lastMove.getTime() + interval < date.getTime() && creature.getMovement() == null) {
            creature.move(randomCoordinate());
            lastMove = date;
            updateInterval();
        }
    }

    private Coordinate randomCoordinate() {
        int dX = MOVEMENT_RADIUS / 2 - random.nextInt(MOVEMENT_RADIUS);
        int dY = MOVEMENT_RADIUS / 2 - random.nextInt(MOVEMENT_RADIUS);
        int dZ = MOVEMENT_RADIUS / 2 - random.nextInt(MOVEMENT_RADIUS);
        int x = center.getX() + dX;
        int y = center.getY() + dY;
        int z = center.getZ() + dZ;
        return new Coordinate(x, y, z);
    }

    private void updateInterval() {
        interval = random.nextInt(INTERVAL_MAX - INTERVAL_MIN) + INTERVAL_MIN;
    }

    @Override
    public void tick(Date date) {
        randomMove(date);
    }
}
