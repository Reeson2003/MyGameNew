package ru.reeson2003.model.characters.creatures;


import ru.reeson2003.model.characters.items.Equipment;

/**
 * Created by reeson on 04.12.16.
 */
public abstract class Creature{
//    todo : Enum CreatureType or int id or inheritance?
//    todo : getLevel and other exp methods
    protected String name;
    protected Parameters parameters;
    protected Experience experience;
    protected Equipment equipment;
    protected int health;
    protected int mana;

    protected Creature() {
    }

    public int getStrength() {
        return parameters.getStrength() + equipment.getStrength();
    }
    public int getConstitution() {
        return parameters.getConstitution() + equipment.getConstitution();
    }
    public int getAgility() {
        return parameters.getAgility() + equipment.getAgility();
    }
    public int getWisdom() {
        return parameters.getWisdom() + equipment.getWisdom();
    }
    public int getIntellect() {
        return parameters.getIntellect() + equipment.getIntellect();
    }
    public int getMaximumHealth() {
        return parameters.getMaximumHealth() + equipment.getMaximumHealth();
    }
    public int getMaximumMana() {
        return parameters.getMaximumMana() + equipment.getMaximumMana();
    }
    public int getHealthRegen() {
        return parameters.getHealthRegen() + equipment.getHealthRegen();
    }
    public int getManaRegen() {
        return parameters.getManaRegen() + equipment.getManaRegen();
    }
    public int getPhysicalAttack() {
        return parameters.getPhysicalAttack() + equipment.getPhysicalAttack();
    }
    public int getPhysicalDefence() {
        return parameters.getPhysicalDefence() + equipment.getPhysicalDefence();
    }
    public int getCriticalChance() {
        return parameters.getCriticalChance() + equipment.getCriticalChance();
    }
    public int getAttackSpeed() {
        return parameters.getAttackSpeed() + equipment.getAttackSpeed();
    }
    public int getEvasion() {
        return parameters.getEvasion() + equipment.getEvasion();
    }
    public int getAccuracy() {
        return parameters.getAccuracy() + equipment.getAccuracy();
    }
    public int getAttackRange() {
        return parameters.getAttackRange() + equipment.getAttackRange();
    }
    public int getMovingSpeed() {
        return parameters.getMovingSpeed() + equipment.getMovingSpeed();
    }
    public int getHealth() {
        return health;
    }
    public int getMana() {
        return mana;
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
    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
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
}
