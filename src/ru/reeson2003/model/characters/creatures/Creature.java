package ru.reeson2003.model.characters.creatures;

import ru.reeson2003.model.characters.WorldObject;
import ru.reeson2003.model.characters.battle.abilities.Ability;
import ru.reeson2003.model.characters.battle.abilities.Abilities;
import ru.reeson2003.model.characters.coordinates.Coordinate;
import ru.reeson2003.model.characters.coordinates.Movement;
import ru.reeson2003.model.service.TimeActivator;
import ru.reeson2003.model.service.TimeDependent;
import ru.reeson2003.model.service.exception.NonExistentAbilityKey;

import java.util.Date;

/**
 * Superclass for game characters. Extends {@link WorldObject} class.
 * Implements {@link TimeDependent}
 * @see WorldObject
 * @see Abilities
 * @see Ability
 * @see ParametersController
 * @see Movement
 * @see TimeActivator
 */
public abstract class Creature extends WorldObject implements TimeDependent {
    /** {@link Abilities} creature can use. */
    private Abilities abilities;
    /** {@code Creature} that is current target. */
    protected Creature target;
    /** {@link ParametersController} manages {@code Creature}'s parameters. */
    protected ParametersController parametersController;
    /** {@link Movement} manages {@code Creature}'s moving. */
    private Movement movement;

    /**
     * Constructs new {@code Creature} with {@code name} and {@code ParametersController}
     * from arguments. Creates new {@code Abilities} and sets it to {@link #abilities}.
     * Uses {@link TimeActivator#addTimeDependent(TimeDependent)} with current {@code Creature}
     * as parameter.
     * @param name {@code String} name of {@code Creature}.
     * @param parametersController {@code ParametersController}.
     */
    public Creature(String name, ParametersController parametersController) {
        this.name = name;
        this.parametersController = parametersController;
        abilities = new Abilities(this);
        TimeActivator.getInstance().addTimeDependent(this);
    }

    /**
     * Uses {@link ParametersController#getMaximumHealth()} method.
     * @return {@code int} maximum health value.
     */
    public int getMaximumHealth() {
        return parametersController.getMaximumHealth();
    }

    public int getMaximumMana() {
        return parametersController.getMaximumMana();
    }

    public int getHealthRegen() {
        return parametersController.getHealthRegen();
    }

    public int getManaRegen() {
        return parametersController.getManaRegen();
    }

    public int getPhysicalAttack() {
        return parametersController.getPhysicalAttack();
    }

    public int getPhysicalDefence() {
        return parametersController.getPhysicalDefence();
    }

    public int getMagicAttack() {
        return parametersController.getMagicAttack();
    }

    public int getMagicDefence() {
        return parametersController.getMagicDefence();
    }

    /**
     * Uses {@link ParametersController#getCriticalChance()} method.
     * @return {@code int} chance of critical hit in <i>percent</i>.
     */
    public int getCriticalChance() {
        return parametersController.getCriticalChance();
    }

    /**
     * Uses {@link ParametersController#getAttackSpeed()} method.
     * @return {@code int} time interval between hits in <i>milliseconds</i>.
     */
    public int getAttackSpeed() {
        return parametersController.getAttackSpeed();
    }

    public int getEvasion() {
        return parametersController.getEvasion();
    }

    public int getAccuracy() {
        return parametersController.getAccuracy();
    }

    /**
     * Uses {@link ParametersController#getAttackRange()} method.
     * @return {@code int} current attack range in <i>centimeters</i>.
     */
    public int getAttackRange() {
        return parametersController.getAttackRange();
    }

    /**
     * Uses {@link ParametersController#getMovingSpeed()} method.
     * @return {@code int} current moving speed in <i>meters per hour</i>.
     */
    public int getMovingSpeed() {
        return parametersController.getMovingSpeed();
    }

    /**
     * Uses {@link ParametersController#getHealth()} method.
     * @return {@code int} current health value.
     */
    public int getHealth() {
        return parametersController.getHealth();
    }

    /**
     * Uses {@link ParametersController#getMana()} method.
     * @return {@code int} current mana value.
     */
    public int getMana() {
        return parametersController.getMana();
    }

    /**
     * Uses {@link Abilities#getAbility(String)} with {@code String} name as parameter.
     * @param name {@code String} name of {@code Ability}.
     * @return {@code Ability}.
     * @throws NonExistentAbilityKey if {@code Abilities} does not contain {@code Ability}.
     * with {@code String} name from argument.
     */
    public Ability getAbility(String name) throws NonExistentAbilityKey {
        return abilities.getAbility(name);
    }

    /**
     * Uses {@link Abilities#add(Ability)}.
     * @param ability {@code Ability} to add in {@code Abilities}.
     */
    public void addAbility(Ability ability) {
        this.abilities.add(ability);
    }

    public Creature getTarget() {
        return target;
    }

    public void setTarget(Creature target) {
        this.target = target;
    }

    /**
     * Changes {@code health} value by using {@link ParametersController#changeHealth(int)}.
     * @param deltaHealth positive for increase, negative for decrease.
     */
    public void changeHealth(int deltaHealth) {
        parametersController.changeHealth(deltaHealth);
    }

    /**
     * Changes {@code mana} value by using {@link ParametersController#changeMana(int)}.
     * @param deltaMana positive for increase, negative for decrease.
     */
    public void changeMana(int deltaMana) {
        parametersController.changeMana(deltaMana);
    }

    /**
     * Sets {@code health} value by using {@link ParametersController#setHealth(int)}.
     * @param health {@code health} value.
     */
    public void setHealth(int health) {
        parametersController.setHealth(health);
    }

    /**
     * Sets {@code mana} value by using {@link ParametersController#setMana(int)}.
     * @param mana {@code mana} value.
     */
    public void setMana(int mana) {
        parametersController.setMana(mana);
    }

    /**
     * Sets {@link #movement} by new {@link Movement} instance with
     * {@code this Creature} and {@code Coordinate} from argument.
     * @param coordinate {@code Coordinate} of destination of movement.
     */
    public void move(Coordinate coordinate) {
        movement = new Movement(this, coordinate);
    }

    public void stopMove() {
        this.movement = null;
    }

    /**
     * General method for damaging the {@code Creature}. Use this method for
     * correct damaging, with death-checking, experience distributing etc.
     * @param creature {@code Creature} which causes damage to this {@code Creature}.
     * @param damage value of damage.
     */
    public abstract void makeDamage(Creature creature, int damage);

    public Movement getMovement() {
        return movement;
    }

    /**
     * General method for adding experience.
     * @param experience value of experience.
     */
    public abstract void addExperience(int experience);

    /**
     * Uses {@link ParametersController#tick(Date)} method.
     * Uses {@link Movement#tick(Date)} method.
     * @param date {@code Date} object.
     */
    @Override
    public void tick(Date date) {
        parametersController.tick(date);
        if (movement != null)
            movement.tick(date);
    }

    @Override
    public String toString() {
        return " ______________________________________________________________\n" +
                "|" + name + "{HP = " + parametersController.getHealth() + ", MP = " +
                parametersController.getMana() + "}\n" +
                "|Parameters{" +
                "MaxHP=" + parametersController.getMaximumHealth() +
                ",MaxMP=" + parametersController.getMaximumMana() +
                ",HPreg=" + parametersController.getHealthRegen() +
                ",MPreg=" + parametersController.getManaRegen() +
                ",Patk=" + parametersController.getPhysicalAttack() +
                ",Pdef=" + parametersController.getPhysicalDefence() +
                ",Crit=" + parametersController.getCriticalChance() +
                ",Aspd=" + parametersController.getAttackSpeed() +
                ",Evas=" + parametersController.getEvasion() +
                ",Accu=" + parametersController.getAccuracy() +
                ",Atkr=" + parametersController.getAttackRange() +
                ",Movs=" + parametersController.getMovingSpeed() +
                "}";
    }
}
