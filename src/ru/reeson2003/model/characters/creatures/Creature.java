package ru.reeson2003.model.characters.creatures;

import ru.reeson2003.model.characters.WorldObject;
import ru.reeson2003.model.characters.battle.abilities.Ability;
import ru.reeson2003.model.characters.battle.abilities.Abilities;
import ru.reeson2003.model.characters.coordinates.Coordinate;
import ru.reeson2003.model.characters.coordinates.Movement;
import ru.reeson2003.model.service.TimeActivator;
import ru.reeson2003.model.service.TimeDependent;
import ru.reeson2003.model.service.exception.MyGameException;

import java.util.Date;

/**
 * Superclass for NPCs and PCs.
 *
 */
public abstract class Creature extends WorldObject implements TimeDependent {
    private Abilities abilities;
    protected Creature target;
    protected ParametersController parametersController;
    private Movement movement;

    public Creature(String name, ParametersController parametersController) {
        this.name = name;
        this.parametersController = parametersController;
        abilities = new Abilities(this);
        TimeActivator.getInstance().addTimeDependent(this);
    }

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

    public int getCriticalChance() {
        return parametersController.getCriticalChance();
    }

    public int getAttackSpeed() {
        return parametersController.getAttackSpeed();
    }

    public int getEvasion() {
        return parametersController.getEvasion();
    }

    public int getAccuracy() {
        return parametersController.getAccuracy();
    }

    public int getAttackRange() {
        return parametersController.getAttackRange();
    }

    public int getMovingSpeed() {
        return parametersController.getMovingSpeed();
    }

    public int getHealth() {
        return parametersController.getHealth();
    }

    public int getMana() {
        return parametersController.getMana();
    }

    public Ability getAbility(String name) throws MyGameException {
        return abilities.getAbility(name);
    }

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
     * Method for healing or damaging creature.
     * @param deltaHealth Positive for heal, negative for damage.
     */
    public void changeHealth(int deltaHealth) {
        parametersController.changeHealth(deltaHealth);
    }

    /**
     * Method for change of current mana amount.
     * @param deltaMana Positive for add, negative for subtract.
     */
    public void changeMana(int deltaMana) {
        parametersController.changeMana(deltaMana);
    }

    public void setHealth(int health) {
        parametersController.setHealth(health);
    }

    public void setMana(int mana) {
        parametersController.setMana(mana);
    }

    public void move(Coordinate coordinate) {
        movement = new Movement(this,coordinate);
    }

    public Movement getMovement() {
        return movement;
    }

    public abstract boolean kill();

    public abstract int getExperienceForKill();

    public abstract void subtractExperienceForKill();

    public abstract void addExperience(int experience);
    @Override
    public void tick(Date date) {
        parametersController.tick(date);
        if (movement != null)
            movement.tick(date);
    }

    @Override
    public String toString() {
        return  " ______________________________________________________________\n" +
                "|" + name + "{HP = " + parametersController.getHealth()+ ", MP = " +
                parametersController.getMana() + "}\n" +
                "|Parameters{" +
                ",MaxHP=" + parametersController.getMaximumHealth() +
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
