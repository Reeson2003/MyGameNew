package ru.reeson2003.model.characters.creatures;

/**
 * Created by User on 12.11.2016.
 */
public abstract class ParametersStrategy {
    private static ParametersStrategy instance = SimpleParametersStrategy.getInstance();
    public abstract int getMaximumHealth(Parameters parameters, Experience experience);
    public abstract int getHealthRegen(Parameters parameters, Experience experience);
    public abstract int getMaximumMana(Parameters parameters, Experience experience);
    public abstract int getManaRegen(Parameters parameters, Experience experience);
    public abstract int getPhysicalAttack(Parameters parameters, Experience experience);
    public abstract int getPhysicalDefence(Parameters parameters, Experience experience);
    public abstract int getCriticalChance(Parameters parameters, Experience experience);
    public abstract int getAttackSpeed(Parameters parameters, Experience experience);
    public abstract int getEvasion(Parameters parameters, Experience experience);
    public abstract int getAccuracy(Parameters parameters, Experience experience);
    public static ParametersStrategy getInstance() {
        return instance;
    }
}
