package ru.reeson2003.model.characters.creatures;


import ru.reeson2003.model.characters.creatures.NonPlayerCharacter.MonsterParametersController;
import ru.reeson2003.model.characters.creatures.PlayerCharacter.PlayerParametersController;
import ru.reeson2003.model.characters.items.Equipment;

/**
 * Created by User on 12.11.2016.
 * фабрика выпускает контроллеры параметров.
 * Базовый класс имеет реализацию методов addHealth() и addMana(),
 */
public abstract class ParametersController {
    protected int health;

    protected int mana;

    public abstract int getStrength();

    public abstract int getConstitution();

    public abstract int getAgility();

    public abstract int getWisdom();

    public abstract int getIntellect();

    public abstract int getMaximumHealth();

    public abstract int getMaximumMana();

    public abstract int getHealthRegen();

    public abstract int getManaRegen();

    public abstract int getPhysicalAttack();

    public abstract int getPhysicalDefence();

    public abstract int getCriticalChance();

    public abstract int getAttackSpeed();

    public abstract int getEvasion();

    public abstract int getAccuracy();

    public abstract int getAttackRange();

    public abstract int getMovingSpeed();

    public abstract int getHealth();

    public abstract int getMana();

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

    public static ParametersController getPlayerParametersController(int str, int con, int agl, int wit, int itl, Experience exp, Equipment eq) {
        return new PlayerParametersController(str, con, agl, wit, itl, exp, eq);
    }
    public static ParametersController getMonsterParametersController(int monsterID) {
        return new MonsterParametersController(monsterID);
    }
}
