package ru.reeson2003.model.characters.creatures;

/**
 * Created by User on 12.11.2016.
 */
public class SimpleParametersStrategy extends ParametersStrategy {
    private static ParametersStrategy parametersStrategy = null;
    public static ParametersStrategy getInstance() {
        if (parametersStrategy == null)
            parametersStrategy = new SimpleParametersStrategy();
        return parametersStrategy;
    }
    private SimpleParametersStrategy() {

    }
    @Override
    public int getMaximumHealth(Parameters parameters, Experience experience) {
        return ParametersConstants.HEALTH_BASE + experience.getLevel()*ParametersConstants.HEALTH_LVL_COEFF
                + parameters.getConstitution()*ParametersConstants.HEALTH_CON_COEFF;
    }
    @Override
    public int getHealthRegen(Parameters parameters, Experience experience) {
        return ParametersConstants.HEALTH_REGEN_BASE +
                parameters.getConstitution()*ParametersConstants.HEALTH_REGEN_COEFF/1000;
    }
    @Override
    public int getMaximumMana(Parameters parameters, Experience experience) {
        return ParametersConstants.MANA_BASE + experience.getLevel()*ParametersConstants.MANA_LVL_COEFF
                + parameters.getWisdom()*ParametersConstants.MANA_WIT_COEFF;
    }
    @Override
    public int getManaRegen(Parameters parameters, Experience experience) {
        return ParametersConstants.MANA_REGEN_BASE +
                parameters.getIntellect()*ParametersConstants.MANA_REGEN_COEFF/1000;
    }
    @Override
    public int getPhysicalAttack(Parameters parameters, Experience experience) {
        return ParametersConstants.PATACK_BASE +
                parameters.getStrength()*ParametersConstants.PATACK_STR_COEFF/1000;
    }
    @Override
    public int getPhysicalDefence(Parameters parameters, Experience experience) {
        return ParametersConstants.PDEF_BASE +
                parameters.getConstitution()*ParametersConstants.PDEF_CON_COEFF/1000;
    }
    @Override
    public int getCriticalChance(Parameters parameters, Experience experience) {
        return ParametersConstants.CRITCHANCE_BASE +
                parameters.getAgility()*ParametersConstants.CRITCHANCE_AGL_COEFF/1000;
    }
    @Override
    public int getAttackSpeed(Parameters parameters, Experience experience) {
        return 10000/(ParametersConstants.ATKSPEED_BASE +
                parameters.getAgility()*ParametersConstants.ATKSPEED_AGL_COEFF/1000);
    }
    @Override
    public int getEvasion(Parameters parameters, Experience experience) {
        return ParametersConstants.EVASION_BASE +
                parameters.getAgility()*ParametersConstants.EVASION_AGL_COEFF/1000;
    }
    @Override
    public int getAccuracy(Parameters parameters, Experience experience) {
        return ParametersConstants.ACCURACY_BASE +
                parameters.getAgility()*ParametersConstants.ACCURACY_AGL_COEFF/1000;
    }
}
