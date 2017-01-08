package ru.reeson2003.model.characters.coordinates;

import ru.reeson2003.model.characters.creatures.Creature;
import ru.reeson2003.model.service.TimeDependent;

import java.util.Date;

/**
 * Class for move creatures depending on its speed.
 * It takes begin coordinate from creature and finish
 * coordinate in parameters.
 */
public class Movement implements TimeDependent {
    /**
     * Start coordinate.
     */
    private Coordinate start;
    /**
     * Finish coordinate.
     */
    private Coordinate finish;
    /**
     * Creature that is moving.
     */
    private Creature creature;
    /**
     * Date when moving began.
     */
    private Date begin;
    /**
     * Distance between start and finish.
     */
    private double distance;
    /**
     * Distance projection on "X" axis.
     */
    private int dX;
    /**
     * Distance projection on "Y" axis.
     */
    private int dY;
    /**
     * Distance projection on "Z" axis.
     */
    private int dZ;
    /**
     * Speed projection on "X" axis.
     */
    private double vX;
    /**
     * Speed projection on "Y" axis.
     */
    private double vY;
    /**
     * Speed projection on "Z" axis.
     */
    private double vZ;

    /**
     * Creates movement. Initializes fields.
     * @param creature creature to move.
     * @param finish coordinate to move to.
     */
    public Movement(Creature creature, Coordinate finish) {
        this.finish = finish;
        this.start = creature.getCoordinate();
        this.creature = creature;
        this.begin = new Date();
        calcDistance();
        calcDxDyDz();
    }

    /**
     * Calculates and initializes dX, dY, dZ fields.
     */
    private void calcDxDyDz() {
        dX = finish.getX() - start.getX();
        dY = finish.getY() - start.getY();
        dZ = finish.getZ() - start.getZ();
    }

    /**
     * Calculates and sets vX, vY, vZ fields.
     */
    private void setSpeedProjection() {
        vX = speedProjection(dX);
        vY = speedProjection(dY);
        vZ = speedProjection(dZ);
    }

    /**
     * Calculates speed projection on axis.
     * @param delta projection of distance on axis.
     * @return  projection of speed on axis.
     */
    private double speedProjection(int delta) {
            double result = (calcSpeed() * (delta)) / distance;
            return result;
    }

    /**
     * Calculates and initializes distance field.
     */
    private void calcDistance() {
        int dX = finish.getX() - start.getX();
        int dY = finish.getY() - start.getY();
        int dZ = finish.getZ() - start.getZ();
        distance = Math.sqrt((long)dX * dX + (long)dY * dY + (long)dZ * dZ);
    }

    /**
     * Gets speed from creature and convert it into points per millisecond scale.
     * Constant 3_600_000 to convert speed from meters per hour into meters per millisecond.
     * @return speed in points per millisecond scale.
     */
    private double calcSpeed() {
        return (double) creature.getMovingSpeed() / (3_600_000/WorldConstants.SCALE);
    }

    /**
     * Checks if creature does not get finish.
     * Calculates current X, Y, Z. Creates new Coordinate. Moves a creature.
     * @param date current date.
     */
    private void step(Date date) {
        if (!creature.getCoordinate().equals(finish)) {
            setSpeedProjection();
            int x = (int) (start.getX() + vX * (date.getTime() - this.begin.getTime()));
            int y = (int) (start.getY() + vY * (date.getTime() - this.begin.getTime()));
            int z = (int) (start.getZ() + vZ * (date.getTime() - this.begin.getTime()));
            if ((x - (finish.getX())) * vX > 0) x = finish.getX();
            if ((y - (finish.getY())) * vY > 0) y = finish.getY();
            if ((z - (finish.getZ())) * vZ > 0) z = finish.getZ();
            Coordinate coordinate = new Coordinate(x, y, z);
            World.getInstance().move(creature, coordinate);
        }
    }

    public Coordinate getStart() {
        return start;
    }

    public Coordinate getFinish() {
        return finish;
    }

    public Date getBegin() {
        return begin;
    }

    /**
     * @param date current date.
     */
    @Override
    public void tick(Date date) {
        step(date);
    }

}
