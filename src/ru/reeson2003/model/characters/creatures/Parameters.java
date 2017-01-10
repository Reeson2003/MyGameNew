package ru.reeson2003.model.characters.creatures;

/**
 * Parameters class. Contains builder for simple initializing.
 * To get instance:
 * 1. get new Parameters.ParametersBuilder();
 * 2. use strength(),constitution(),agility() etc methods of
 * builder instance to set the initial values of the fields.
 * You can use the chain methods use like:
 * parametersBuilder.strength(10).constitution(10).agility(10) etc,
 * other fields initialized by Zero.
 * 3. use build() method to get the Parameters instance.
 * Method clone() return new instance with same fields values.
 */
public class Parameters implements Cloneable {

    private int maximumHealth;
    private int maximumMana;
    private int healthRegen;
    private int manaRegen;
    private int physicalAttack;
    private int physicalDefence;
    private int magicAttack;
    private int magicDefence;
    private int criticalChance;
    private int attackSpeed;
    private int evasion;
    private int accuracy;
    private int attackRange;
    /**
     * Moving speed in meters per hour.
     */
    private int movingSpeed;

    /**
     * Chain builder pattern implementation.
     */
    public static class ParametersBuilder {
        Parameters parameters;

        public ParametersBuilder() {
            parameters = new Parameters();
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

        public ParametersBuilder magicAttack(int magicAttack) {
            parameters.magicAttack = magicAttack;
            return this;
        }

        public ParametersBuilder magicDefence(int magicDefence) {
            parameters.magicDefence = magicDefence;
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
        maximumHealth = 0;
        maximumMana = 0;
        healthRegen = 0;
        manaRegen = 0;
        physicalAttack = 0;
        physicalDefence = 0;
        magicAttack = 0;
        magicDefence = 0;
        criticalChance = 0;
        attackSpeed = 0;
        evasion = 0;
        accuracy = 0;
    }

    public Parameters addParameters(Parameters parameters) {
        Parameters result = new Parameters();
        result.maximumHealth = this.maximumHealth + parameters.maximumHealth;
        result.maximumMana = this.maximumMana + parameters.maximumMana;
        result.healthRegen = this.healthRegen + parameters.healthRegen;
        result.manaRegen = this.manaRegen + parameters.manaRegen;
        result.physicalAttack = this.physicalAttack + parameters.physicalAttack;
        result.physicalDefence = this.physicalDefence + parameters.physicalDefence;
        result.magicAttack = this.magicAttack + parameters.magicAttack;
        result.magicDefence = this.magicDefence + parameters.magicDefence;
        result.criticalChance = this.criticalChance + parameters.criticalChance;
        result.attackSpeed = this.attackSpeed + parameters.attackSpeed;
        result.evasion = this.evasion + parameters.evasion;
        result.accuracy = this.accuracy + parameters.accuracy;
        result.attackRange = this.attackRange + parameters.attackRange;
        result.movingSpeed = this.movingSpeed + parameters.movingSpeed;
        return result;
    }

    public Parameters subtractParameters(Parameters parameters) {
        Parameters result = new Parameters();
        result.maximumHealth = this.maximumHealth - parameters.maximumHealth;
        result.maximumMana = this.maximumMana - parameters.maximumMana;
        result.healthRegen = this.healthRegen - parameters.healthRegen;
        result.manaRegen = this.manaRegen - parameters.manaRegen;
        result.physicalAttack = this.physicalAttack - parameters.physicalAttack;
        result.physicalDefence = this.physicalDefence - parameters.physicalDefence;
        result.magicAttack = this.magicAttack - parameters.magicAttack;
        result.magicDefence = this.magicDefence - parameters.magicDefence;
        result.criticalChance = this.criticalChance - parameters.criticalChance;
        result.attackSpeed = this.attackSpeed - parameters.attackSpeed;
        result.evasion = this.evasion - parameters.evasion;
        result.accuracy = this.accuracy - parameters.accuracy;
        result.attackRange = this.attackRange - parameters.attackRange;
        result.movingSpeed = this.movingSpeed - parameters.movingSpeed;
        return result;
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

    public int getMagicAttack() {
        return magicAttack;
    }

    public int getMagicDefence() {
        return magicDefence;
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

    public void setMagicAttack(int magicAttack) {
        this.magicAttack = magicAttack;
    }

    public void setMagicDefence(int magicDefence) {
        this.magicDefence = magicDefence;
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
        result.maximumHealth = this.maximumHealth;
        result.maximumMana = this.maximumMana;
        result.healthRegen = this.healthRegen;
        result.manaRegen = this.manaRegen;
        result.physicalAttack = this.physicalAttack;
        result.physicalDefence = this.physicalDefence;
        result.magicAttack = this.magicAttack;
        result.magicDefence = this.magicDefence;
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
                "MaxHP=" + maximumHealth +
                ", MaxMP=" + maximumMana +
                ", HPreg=" + healthRegen +
                ", MPreg=" + manaRegen +
                ", Patk=" + physicalAttack +
                ", Pdef=" + physicalDefence +
                ", Matk=" + magicAttack +
                ", Mdef=" + magicDefence +
                ", Crit=" + criticalChance +
                ", Aspd=" + attackSpeed +
                ", Evas=" + evasion +
                ", Accu=" + accuracy +
                ", Atkr=" + attackRange +
                ", Movs=" + movingSpeed +
                '}';
    }
}
