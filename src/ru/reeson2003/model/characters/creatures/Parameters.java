package ru.reeson2003.model.characters.creatures;

/**
 * Created by reeson on 05.12.16.
 */
public class Parameters implements Cloneable{
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

        public ParametersBuilder attackSpeed(int atackSpeed) {
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

        public ParametersBuilder attackRange(int attackRange) {
            parameters.attackRange = attackRange;
            return this;
        }

        public ParametersBuilder movingSpeed(int movingSpeed) {
            parameters.movingSpeed = movingSpeed;
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

    public Parameters addParameters(Parameters parameters) {
        Parameters result = new Parameters();
        result.strength = this.strength + parameters.strength;
        result.constitution = this.constitution + parameters.constitution;
        result.agility = this.agility + parameters.agility;
        result.wisdom = this.wisdom + parameters.wisdom;
        result.intellect = this.intellect + parameters.intellect;
        result.maximumHealth = this.maximumHealth + parameters.maximumHealth;
        result.maximumMana = this.maximumMana + parameters.maximumMana;
        result.healthRegen = this.healthRegen + parameters.healthRegen;
        result.manaRegen = this.manaRegen + parameters.manaRegen;
        result.physicalAttack = this.physicalAttack + parameters.physicalAttack;
        result.physicalDefence = this.physicalDefence + parameters.physicalDefence;
        result.criticalChance = this.criticalChance + parameters.criticalChance;
        result.attackSpeed = this.attackSpeed + parameters.attackSpeed;
        result.evasion = this.evasion + parameters.evasion;
        result.accuracy = this.accuracy + parameters.accuracy;
        result.attackRange = this.attackRange + parameters.attackRange;
        result.movingSpeed = this.movingSpeed + parameters.movingSpeed;
        return result;
    }

    public Parameters subtractParameters(Parameters parameters) {
//        this.strength -= parameters.strength;
//        this.constitution -= parameters.constitution;
//        this.agility -= parameters.agility;
//        this.wisdom -= parameters.wisdom;
//        this.intellect -= parameters.intellect;
//        this.maximumHealth -= parameters.maximumHealth;
//        this.maximumMana -= parameters.maximumMana;
//        this.healthRegen -= parameters.healthRegen;
//        this.manaRegen -= parameters.manaRegen;
//        this.physicalAttack -= parameters.physicalAttack;
//        this.physicalDefence -= parameters.physicalDefence;
//        this.criticalChance -= parameters.criticalChance;
//        this.attackSpeed -= parameters.attackSpeed;
//        this.evasion -= parameters.evasion;
//        this.accuracy -= parameters.accuracy;
//        this.attackRange -= parameters.attackRange;
//        this.movingSpeed -= parameters.movingSpeed;
        Parameters result = new Parameters();
        result.strength = this.strength - parameters.strength;
        result.constitution = this.constitution - parameters.constitution;
        result.agility = this.agility - parameters.agility;
        result.wisdom = this.wisdom - parameters.wisdom;
        result.intellect = this.intellect - parameters.intellect;
        result.maximumHealth = this.maximumHealth - parameters.maximumHealth;
        result.maximumMana = this.maximumMana - parameters.maximumMana;
        result.healthRegen = this.healthRegen - parameters.healthRegen;
        result.manaRegen = this.manaRegen - parameters.manaRegen;
        result.physicalAttack = this.physicalAttack - parameters.physicalAttack;
        result.physicalDefence = this.physicalDefence - parameters.physicalDefence;
        result.criticalChance = this.criticalChance - parameters.criticalChance;
        result.attackSpeed = this.attackSpeed - parameters.attackSpeed;
        result.evasion = this.evasion - parameters.evasion;
        result.accuracy = this.accuracy - parameters.accuracy;
        result.attackRange = this.attackRange - parameters.attackRange;
        result.movingSpeed = this.movingSpeed - parameters.movingSpeed;
        return result;
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

    @Override
    public Parameters clone() {
        Parameters result = new Parameters();
        result.strength = this.strength;
        result.constitution = this.constitution;
        result.agility = this.agility;
        result.wisdom = this.wisdom;
        result.intellect = this.intellect;
        result.maximumHealth = this.maximumHealth;
        result.maximumMana = this.maximumMana;
        result.healthRegen = this.healthRegen;
        result.manaRegen = this.manaRegen;
        result.physicalAttack = this.physicalAttack;
        result.physicalDefence = this.physicalDefence;
        result.criticalChance = this.criticalChance;
        result.attackSpeed = this.attackSpeed;
        result.evasion = this.evasion;
        result.accuracy = this.accuracy;
        result.attackRange = this.attackRange;
        result.movingSpeed = this.getMovingSpeed();
        return result;
    }

    @Override
    public String toString() {
        return "{" +
                "str=" + strength +
                ", con=" + constitution +
                ", agl=" + agility +
                ", wit=" + wisdom +
                ", int=" + intellect +
                ", MaxHP=" + maximumHealth +
                ", MaxMP=" + maximumMana +
                ", HPreg=" + healthRegen +
                ", MPreg=" + manaRegen +
                ", Patk=" + physicalAttack +
                ", Pdef=" + physicalDefence +
                ", Crit=" + criticalChance +
                ", Aspd=" + attackSpeed +
                ", Evas=" + evasion +
                ", Accu=" + accuracy +
                ", Atkr=" + attackRange +
                ", Movs=" + movingSpeed +
                '}';
    }
}
