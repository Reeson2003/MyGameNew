package ru.reeson2003.model.characters.creatures;

import ru.reeson2003.model.characters.WorldObject;
import ru.reeson2003.model.characters.battle.abilities.HitAbility;

/**
 * Created by reeson on 04.12.16.
 */
public abstract class Creature extends WorldObject {
    //    todo : Enum CreatureType or int id or inheritance?
    protected Creature target;
    protected String name;
    protected ParametersController parametersController;

    //for test
    HitAbility hitAbility;

    public Creature(String name, ParametersController parametersController) {
        this.name = name;
        this.parametersController = parametersController;
        //for test
        hitAbility = new HitAbility(300+10000/parametersController.getAttackSpeed());
    }

    public int getStrength() {
        return parametersController.getStrength();
    }

    public int getConstitution() {
        return parametersController.getConstitution();
    }

    public int getAgility() {
        return parametersController.getAgility();
    }

    public int getWisdom() {
        return parametersController.getWisdom();
    }

    public int getIntellect() {
        return parametersController.getIntellect();
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

    public String getName() {
        return name;
    }

    public Creature getTarget() {
        return target;
    }

    public void setTarget(Creature target) {
        this.target = target;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addHealth(int health) {
        parametersController.addHealth(health);
    }

    public void addMana(int mana) {
        parametersController.addMana(mana);
    }

    //for test


    public HitAbility getHitAbility() {
        return hitAbility;
    }

    @Override
    public String toString() {
        return  " ______________________________________________________________\n" +
                "|" + name + "{HP = " + parametersController.getHealth()+ ", MP = " +
                parametersController.getMana() + "}\n" +
                "|Parameters{" +
                "Str=" + parametersController.getStrength() +
                ",Con=" + parametersController.getConstitution() +
                ",Agl=" + parametersController.getAgility() +
                ",Wit=" + parametersController.getWisdom() +
                ",Int=" + parametersController.getIntellect() +
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
