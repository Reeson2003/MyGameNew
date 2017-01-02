package ru.reeson2003.model.characters.creatures;


import ru.reeson2003.model.characters.creatures.NonPlayerCharacter.MonsterParametersController;
import ru.reeson2003.model.characters.creatures.PlayerCharacter.PlayerParametersController;
import ru.reeson2003.model.characters.items.Equipment;

/**
 * Created by User on 12.11.2016.
 * фабрика выпускает контроллеры параметров.
 * Базовый класс имеет реализацию методов changeHealth() и changeMana(),
 */
public abstract class ParametersController implements Cloneable {
    protected Parameters parameters;
    protected int health;
    protected int mana;

    public int getStrength() {
        return parameters.getStrength();
    }

    public int getConstitution() {
        return parameters.getConstitution();
    }

    public int getAgility() {
        return parameters.getAgility();
    }

    public int getWisdom() {
        return parameters.getWisdom();
    }

    public int getIntellect() {
        return parameters.getIntellect();
    }

    public int getMaximumHealth() {
        return parameters.getMaximumHealth();
    }

    public int getMaximumMana() {
        return parameters.getMaximumMana();
    }

    public int getHealthRegen() {
        return parameters.getHealthRegen();
    }

    public int getManaRegen() {
        return parameters.getManaRegen();
    }

    public int getPhysicalAttack() {
        return parameters.getPhysicalAttack();
    }

    public int getPhysicalDefence() {
        return parameters.getPhysicalDefence();
    }

    public int getCriticalChance() {
        return parameters.getCriticalChance();
    }

    public int getAttackSpeed() {
        return parameters.getAttackSpeed();
    }

    public int getEvasion() {
        return parameters.getEvasion();
    }

    public int getAccuracy() {
        return parameters.getAccuracy();
    }

    public int getAttackRange() {
        return parameters.getAttackRange();
    }

    public int getMovingSpeed() {
        return parameters.getMovingSpeed();
    }

    public int getHealth() {
        return health;
    }

    public int getMana() {
        return mana;
    }

    public void addHealth(int health) {
        this.health += health;
        if (this.health > this.getMaximumHealth())
            this.health = this.getMaximumHealth();
        if (this.health < 0)
            this.health = 0;
    }

    public void addMana(int mana) {
        this.mana += mana;
        if (this.mana >= this.getMaximumMana())
            this.mana = this.getMaximumMana();
        if (this.mana < 0)
            this.mana = 0;
    }

    @Override
    public  ParametersController clone() {
        return this;
    }

    public static ParametersController getPlayerParametersController(int str, int con, int agl, int wit, int itl, Experience exp, Equipment eq) {
        return new PlayerParametersController(str, con, agl, wit, itl, exp, eq);
    }
    public static ParametersController getMonsterParametersController(int monsterID) {
        return new MonsterParametersController(monsterID);
    }
}
