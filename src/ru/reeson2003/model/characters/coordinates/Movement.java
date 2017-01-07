package ru.reeson2003.model.characters.coordinates;

import ru.reeson2003.model.characters.creatures.Creature;
import ru.reeson2003.model.service.TimeDependent;

import java.util.Date;

/**
 * Created by reeson on 07.01.17.
 */
public class Movement implements TimeDependent {
    private Coordinate dest;
    private Coordinate dept;
    private Creature creature;
    private double speed;
    private Date start;
    private Date step;
    double vX;
    double vY;
    double vZ;

    public Movement(Creature creature, Coordinate dest, int speed) {
        this.dest = dest;
        this.dept = creature.getCoordinate();
        this.creature = creature;
        this.speed = (double) speed * 10 / 36000;
        this.start = this.step = new Date();
        setSpeedProjection(dept, dest, this.speed);
    }

    public Movement(Creature creature, Coordinate dest) {
        this(creature, dest, creature.getMovingSpeed());
    }

    private void setSpeedProjection(Coordinate from, Coordinate to, double speed) {
        int x0 = from.getX();
        int y0 = from.getY();
        int z0 = from.getZ();
        int x = to.getX();
        int y = to.getY();
        int z = to.getZ();
        int dist = from.distance(to);
        vX = speedProjection(speed, x0, x, dist);
        vY = speedProjection(speed, y0, y, dist);
        vZ = speedProjection(speed, z0, z, dist);
    }

    private double speedProjection(double speed, int x0, int x, int distance) {
        if (distance != 0) {
            double result = (speed * (x - x0)) / distance;
            return result;
        } else
            return 0;
    }

    private void step(Date date) {
        int x = (int) (dept.getX() + vX * (date.getTime() - this.start.getTime()));
        int y = (int) (dept.getY() + vY * (date.getTime() - this.start.getTime()));
        int z = (int) (dept.getZ() + vZ * (date.getTime() - this.start.getTime()));
        if((x-(dest.getX()))*vX > 0) x = dest.getX();
        if((y-(dest.getY()))*vY > 0) y = dest.getY();
        if((z-(dest.getZ()))*vZ > 0) z = dest.getZ();
        Coordinate coordinate = new Coordinate(x, y, z);
        if (coordinate.equals(dest))
            creature.stopMove();
        World.getInstance().move(creature, coordinate);
    }

    @Override
    public void tick(Date date) {
        if (date.getTime() > this.step.getTime() + 999 / CoordinateConstants.STEP_PER_SECOND) {
            step(date);
            step = date;
        }
    }

}
