package ru.reeson2003.model.characters.creatures;

import ru.reeson2003.model.service.Address;

/**
 * Created by reeson on 04.12.16.
 */
public abstract class Creature implements Address.Abonent{
    //    todo : Enum CreatureType or int id or inheritance?
    protected String name;
    protected ParametersController parametersController;
    protected final Address address;

    public Creature(String name, ParametersController parametersController) {
        this.address = new Address();
        this.name = name;
        this.parametersController = parametersController;
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

    public void setName(String name) {
        this.name = name;
    }

    public void addHealth(int health) {
        parametersController.addHealth(health);
    }

    public void addMana(int mana) {
        parametersController.addMana(mana);
    }

    @Override
    public Address getAddress() {
        return address;
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
