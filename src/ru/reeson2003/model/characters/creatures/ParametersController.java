package ru.reeson2003.model.characters.creatures;


import ru.reeson2003.model.characters.creatures.PlayerCharacter.PlayerParametersController;
import ru.reeson2003.model.characters.items.Equipment;

/**
 * Created by User on 12.11.2016.
 * фабрика выпускает контроллеры параметров.
 */
public abstract class ParametersController {

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

    public abstract void addHealth(int health);

    public abstract void addMana(int mana);

    public static ParametersController getPlayerParametersController(int str, int con, int agl, int wit, int itl, Experience exp, Equipment eq) {
        return new PlayerParametersController(str, con, agl, wit, itl, exp, eq);
    }
    public static ParametersController getMonsterParametersController(int monsterID) {
        return null;
    };
}
