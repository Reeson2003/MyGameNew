package ru.reeson2003.model.service.client_content;

import ru.reeson2003.model.characters.creatures.PlayerCharacter.PlayerCharacter;
import ru.reeson2003.model.service.Address;

import java.io.Serializable;

/**
 * Agent for PlayerCharacter to send to client
 */
public class PlayerCharacterSurrogate implements Serializable{
    private static final long serialVersionUID = 13L;
    private Address address;
    private String name;
    private int health;
    private int mana;

    private int strength;
    private int constitution;
    private int agility;
    private int wisdom;
    private int intellect;

    private int maximumHealth;
    private int maximumMana;
    private int healthRegen;
    private int manaRegen;

    private int physicalAttack;
    private int physicalDefence;
    private int criticalChance;
    private int attackSpeed;
    private int evasion;
    private int accuracy;
    private int attackRange;
    private int movingSpeed;

    private int level;
    private int experience;
    private int expToNextLevel;
    private int skillPoints;

    public static PlayerCharacterSurrogate getAgent(PlayerCharacter playerCharacter) {
        return new PlayerCharacterSurrogate(playerCharacter);
    }

    private PlayerCharacterSurrogate(PlayerCharacter playerCharacter) {
        this.address = playerCharacter.getAddress();

        this.name = playerCharacter.getName();
        this.health = playerCharacter.getHealth();
        this.mana = playerCharacter.getMana();

        this.strength = playerCharacter.getStrength();
        this.constitution = playerCharacter.getConstitution();
        this.agility = playerCharacter.getAgility();
        this.wisdom = playerCharacter.getWisdom();
        this.intellect = playerCharacter.getIntellect();

        this.maximumHealth = playerCharacter.getMaximumHealth();
        this.maximumMana = playerCharacter.getMaximumMana();
        this.healthRegen = playerCharacter.getHealthRegen();
        this.manaRegen = playerCharacter.getManaRegen();

        this.physicalAttack = playerCharacter.getPhysicalAttack();
        this.physicalDefence = playerCharacter.getPhysicalDefence();
        this.criticalChance = playerCharacter.getCriticalChance();
        this.attackSpeed = playerCharacter.getAttackSpeed();
        this.evasion = playerCharacter.getEvasion();
        this.accuracy = playerCharacter.getAccuracy();
        this.attackRange = playerCharacter.getAttackRange();
        this.movingSpeed = playerCharacter.getMovingSpeed();

        this.level = playerCharacter.getLevel();
        this.experience = playerCharacter.getExperience();
        this.expToNextLevel = playerCharacter.getExpToNextLevel();
        this.skillPoints = playerCharacter.getSkillPoints();
    }

    public PlayerCharacterSurrogate() {

    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getMana() {
        return mana;
    }

    public int getStrength() {
        return strength;
    }

    public int getConstitution() {
        return constitution;
    }

    public int getAgility() {
        return agility;
    }

    public int getWisdom() {
        return wisdom;
    }

    public int getIntellect() {
        return intellect;
    }

    public int getMaximumHealth() {
        return maximumHealth;
    }

    public int getMaximumMana() {
        return maximumMana;
    }

    public int getHealthRegen() {
        return healthRegen;
    }

    public int getManaRegen() {
        return manaRegen;
    }

    public int getPhysicalAttack() {
        return physicalAttack;
    }

    public int getPhysicalDefence() {
        return physicalDefence;
    }

    public int getCriticalChance() {
        return criticalChance;
    }

    public int getAttackSpeed() {
        return attackSpeed;
    }

    public int getEvasion() {
        return evasion;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public int getAttackRange() {
        return attackRange;
    }

    public int getMovingSpeed() {
        return movingSpeed;
    }

    public int getLevel() {
        return level;
    }

    public int getExperience() {
        return experience;
    }

    public int getExpToNextLevel() {
        return expToNextLevel;
    }

    public int getSkillPoints() {
        return skillPoints;
    }

    public Address getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public void setIntellect(int intellect) {
        this.intellect = intellect;
    }

    public void setMaximumHealth(int maximumHealth) {
        this.maximumHealth = maximumHealth;
    }

    public void setMaximumMana(int maximumMana) {
        this.maximumMana = maximumMana;
    }

    public void setHealthRegen(int healthRegen) {
        this.healthRegen = healthRegen;
    }

    public void setManaRegen(int manaRegen) {
        this.manaRegen = manaRegen;
    }

    public void setPhysicalAttack(int physicalAttack) {
        this.physicalAttack = physicalAttack;
    }

    public void setPhysicalDefence(int physicalDefence) {
        this.physicalDefence = physicalDefence;
    }

    public void setCriticalChance(int criticalChance) {
        this.criticalChance = criticalChance;
    }

    public void setAttackSpeed(int attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public void setEvasion(int evasion) {
        this.evasion = evasion;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public void setAttackRange(int attackRange) {
        this.attackRange = attackRange;
    }

    public void setMovingSpeed(int movingSpeed) {
        this.movingSpeed = movingSpeed;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setExpToNextLevel(int expToNextLevel) {
        this.expToNextLevel = expToNextLevel;
    }

    public void setSkillPoints(int skillPoints) {
        this.skillPoints = skillPoints;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return name + ", health: " + health + "\\" + maximumHealth +
                ", mana: " + mana + "\\" + maximumMana +
                ", Address: " + address.getAbonentId();
    }
}
