package ru.reeson2003.model.characters.creatures;


import ru.reeson2003.model.characters.items.Equipment;

/**
 * Created by reeson on 04.12.16.
 */
public abstract class Creature {
    //    todo : Enum CreatureType or int id or inheritance?
//    todo : getLevel and other exp methods
    protected String name;
    protected ParametersController parametersController;
    protected Experience experience;
    protected Equipment equipment;

    public Creature(String name, ParametersController parametersController, Experience experience, Equipment equipment) {
        this.name = name;
        this.parametersController = parametersController;
        this.experience = experience;
        this.equipment = equipment;
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

    public int getExperience() {
        return experience.getExperience();
    }

    public int getLevel() {
        return experience.getLevel();
    }

    public int getSkillPoints() {
        return experience.getSkillPoints();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExperience(Experience experience) {
        this.experience = experience;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public void addHealth(int health) {
        parametersController.addHealth(health);
    }

    public void addMana(int mana) {
        parametersController.addMana(mana);
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
                "}\n" + "|" + experience +
                "\n --------------------------------------------------------------";
    }
}
