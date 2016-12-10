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
    protected int health;
    protected int mana;
//    todo : баг: текущее хп и мп не уменьшается при изменении параметров. возможно надо перенести их в контроллер

    public Creature(String name, ParametersController parametersController, Experience experience, Equipment equipment) {
        this.name = name;
        this.parametersController = parametersController;
        this.experience = experience;
        this.equipment = equipment;
        this.health = parametersController.getMaximumHealth();
        this.mana = parametersController.getMaximumMana();
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
        return health;
    }

    public int getMana() {
        return mana;
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

    public void setHealth(int health) {
        this.health = health;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void addHealth(int health) {
        this.health += health;
        if (this.health > parametersController.getMaximumHealth())
            this.health = parametersController.getMaximumHealth();
    }

    public void subtractHealth(int health) {
        this.health -= health;
        if (this.health < 0)
            this.health = 0;
    }

    @Override
    public String toString() {
        return  name + "HP = " + health + ", MP = " + mana + "\n" +
                "Parameters{" +
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
                "}\n" + experience;
    }
}
