package ru.reeson2003.model.game.characters.coordinates;

import ru.reeson2003.model.game.characters.creatures.Creature;
import ru.reeson2003.model.game.service.TimeDependent;

import java.util.Date;

/**
 * Class {@code Movement} used to move {@code Creatures} depending on its speed.
 * It takes begin {@code Coordinate} from creature and finish {@code Coordinate}.
 * Class {@code Movement} implements {@code TimeDependent}.
 *
 * @see Coordinate
 * @see Creature
 * @see TimeDependent
 */
public class Movement implements TimeDependent {
    /**
     * Start coordinate {@link Coordinate}
     */
    private Coordinate start;
    /**
     * Finish coordinate {@link Coordinate}
     */
    private Coordinate finish;
    /**
     * Creature that is moving {@link Creature}
     */
    private Creature creature;
    /**
     * Date when moving began {@link Date}
     */
    private Date begin;
    /**
     * Distance between start and finish
     */
    private double distance;
    /**
     * Distance projection on "X" axis
     */
    private int dX;
    /**
     * Distance projection on "Y" axis
     */
    private int dY;
    /**
     * Distance projection on "Z" axis
     */
    private int dZ;
    /**
     * Speed projection on "X" axis
     */
    private double vX;
    /**
     * Speed projection on "Y" axis
     */
    private double vY;
    /**
     * Speed projection on "Z" axis
     */
    private double vZ;

    /**
     * Creates new {@code Movement}. Initializes fields.
     *
     * @param creature {@code Creature} to move.
     * @param finish   {@code Coordinate} of destination.
     */
    public Movement(Creature creature, Coordinate finish) {
        this.finish = finish;
        this.start = creature.getCoordinate();
        this.creature = creature;
        calcDistance();
        calcDxDyDz();
    }

    /**
     * Calculates and sets {@link #dX}, {@link #dY}, {@link #dZ} fields
     */
    private void calcDxDyDz() {
        dX = finish.getX() - start.getX();
        dY = finish.getY() - start.getY();
        dZ = finish.getZ() - start.getZ();
    }

    /**
     * Calculates and sets {@link #vX}, {@link #vY}, {@link #vZ} fields
     */
    private void setSpeedProjection() {
        vX = speedProjection(dX);
        vY = speedProjection(dY);
        vZ = speedProjection(dZ);
    }

    /**
     * Calculates speed projection on axis.
     * @param delta projection of distance on axis.
     * @return projection of speed on axis.
     */
    private double speedProjection(int delta) {
        double result = (calcSpeed() * (delta)) / distance;
        return result;
    }

    /**
     * Calculates and initializes {@link #distance} field
     */
    private void calcDistance() {
        int dX = finish.getX() - start.getX();
        int dY = finish.getY() - start.getY();
        int dZ = finish.getZ() - start.getZ();
        distance = Math.sqrt((long) dX * dX + (long) dY * dY + (long) dZ * dZ);
    }

    /**
     * Gets speed from creature and convert it into points per millisecond scale.
     * Constant {@code 3_600_000} to convert speed from <i>meters per hour</i>
     * into <i>meters per millisecond</i>.
     * @return speed in points per millisecond scale.
     */
    private double calcSpeed() {
        return (double) creature.getMovingSpeed() / (3_600_000 / WorldConstants.SCALE);
    }

    /**
     * Checks if {@link #creature} does not get {@link #finish}.
     * Calculates current {@code x}, {@code y}, {@code z}. Creates new {@code Coordinate}.
     * Moves a {@link #creature} otherwise uses {@link Creature#stopMove()} method.
     * @param date current {@code Date}.
     */
    private void step(Date date) {
        if (begin == null)
            begin = date;
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
        } else
            creature.stopMove();
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
     * Uses {@link #step(Date)} method with {@code Date} argument.
     * @param date current {@code Date}
     */
    @Override
    public void tick(Date date) {
        step(date);
    }

}
