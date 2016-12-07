package ru.reeson2003.model.characters.creatures;

/**
 * Created by reeson on 05.12.16.
 */
public class Parameters {
//    todo : to add: movingSpeed, attackRange; (+methods and builderMethods)
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

    public static class ParametersBuilder {
        Parameters parameters;
        public ParametersBuilder() {
            parameters = new Parameters();
        }
        public ParametersBuilder strength(int strength) {
            parameters.strength = strength;
            return this;
        }
        public ParametersBuilder constitution(int constitution) {
            parameters.constitution = constitution;
            return this;
        }
        public ParametersBuilder agility(int agility) {
            parameters.agility = agility;
            return this;
        }
        public ParametersBuilder wisdom(int wisdom) {
            parameters.wisdom = wisdom;
            return this;
        }
        public ParametersBuilder intellect(int intellect) {
            parameters.intellect = intellect;
            return this;
        }
        public ParametersBuilder maximumHealth(int maximumHealth) {
            parameters.maximumHealth = maximumHealth;
            return this;
        }
        public ParametersBuilder maximumMana(int maximumMana) {
            parameters.maximumMana = maximumMana;
            return this;
        }
        public ParametersBuilder healthRegen(int healthRegen) {
            parameters.healthRegen = healthRegen;
            return this;
        }
        public ParametersBuilder manaRegen(int manaRegen) {
            parameters.manaRegen = manaRegen;
            return this;
        }
        public ParametersBuilder physicalAttack(int physicalAttack) {
            parameters.physicalAttack = physicalAttack;
            return this;
        }
        public ParametersBuilder physicalDefence(int physicalDefence) {
            parameters.physicalDefence = physicalDefence;
            return this;
        }
        public ParametersBuilder criticalChance(int criticalChance) {
            parameters.criticalChance = criticalChance;
            return this;
        }
        public ParametersBuilder atackSpeed(int atackSpeed) {
            parameters.attackSpeed = atackSpeed;
            return this;
        }
        public ParametersBuilder evasion(int evasion) {
            parameters.evasion = evasion;
            return this;
        }
        public ParametersBuilder accuracy(int accuracy) {
            parameters.accuracy = accuracy;
            return this;
        }
        public Parameters build() {
            return parameters;
        }
    }

    private Parameters() {
        strength = 0;
        constitution = 0;
        agility = 0;
        wisdom = 0;
        intellect = 0;
        maximumHealth = 0;
        maximumMana = 0;
        healthRegen = 0;
        manaRegen = 0;
        physicalAttack = 0;
        physicalDefence = 0;
        criticalChance = 0;
        attackSpeed = 0;
        evasion = 0;
        accuracy = 0;
    }

    public void addParameters(Parameters parameters) {
        this.strength += parameters.strength;
        this.constitution += parameters.constitution;
        this.agility += parameters.agility;
        this.wisdom += parameters.wisdom;
        this.intellect += parameters.intellect;
        this.maximumHealth += parameters.maximumHealth;
        this.maximumMana += parameters.maximumMana;
        this.healthRegen += parameters.healthRegen;
        this.manaRegen += parameters.manaRegen;
        this.physicalAttack += parameters.physicalAttack;
        this.physicalDefence += parameters.physicalDefence;
        this.criticalChance += parameters.criticalChance;
        this.attackSpeed += parameters.attackSpeed;
        this.evasion += parameters.evasion;
        this.accuracy += parameters.accuracy;
    }
    public void subtractParameters(Parameters parameters) {
        this.strength -= parameters.strength;
        this.constitution -= parameters.constitution;
        this.agility -= parameters.agility;
        this.wisdom -= parameters.wisdom;
        this.intellect -= parameters.intellect;
        this.maximumHealth -= parameters.maximumHealth;
        this.maximumMana -= parameters.maximumMana;
        this.healthRegen -= parameters.healthRegen;
        this.manaRegen -= parameters.manaRegen;
        this.physicalAttack -= parameters.physicalAttack;
        this.physicalDefence -= parameters.physicalDefence;
        this.criticalChance -= parameters.criticalChance;
        this.attackSpeed -= parameters.attackSpeed;
        this.evasion -= parameters.evasion;
        this.accuracy -= parameters.accuracy;
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

    @Override
    public String toString() {
        return "Parameters{" +
                "strength=" + strength +
                ",\n\t constitution=" + constitution +
                ",\n\t agility=" + agility +
                ",\n\t wisdom=" + wisdom +
                ",\n\t intellect=" + intellect +
                ",\n\t maximumHealth=" + maximumHealth +
                ",\n\t maximumMana=" + maximumMana +
                ",\n\t healthRegen=" + healthRegen +
                ",\n\t manaRegen=" + manaRegen +
                ",\n\t physicalAttack=" + physicalAttack +
                ",\n\t physicalDefence=" + physicalDefence +
                ",\n\t criticalChance=" + criticalChance +
                ",\n\t attackSpeed=" + attackSpeed +
                ",\n\t evasion=" + evasion +
                ",\n\t accuracy=" + accuracy +
                '}';
    }
}
