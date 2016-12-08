package ru.reeson2003.model.characters.creatures;

/**
 * Created by User on 12.11.2016.
 * Фабрика выпускает Parameters на основе базовых strength, constitution, agility, wisdom, intellect,
 * используя коэффициенты из ParametersConstants. Фабрика подписывается на события levelUp() и
 * levelDown() объекта Experience, полученного в параметрах, и обновляет выпущенные параметры автоматически.
 */
public class PlayerParametersFactory extends ParametersFactory implements Experience.ExperienceListener{

    private Parameters parameters;
    private Experience experience;

    public PlayerParametersFactory(int str, int con, int agl, int wit, int itl, Experience experience) {
        parameters = new Parameters.ParametersBuilder().strength(str).
                constitution(con).agility(agl).wisdom(wit).intellect(itl).build();
        this.experience = experience;
        experience.addListener(this);
        updateParameters();
    }

    @Override
    public Parameters getParameters() {
        return parameters;
    }

    private void updateParameters(){
        parameters.setMaximumHealth(ParametersConstants.HEALTH_BASE + experience.getLevel()*ParametersConstants.HEALTH_LVL_COEFF
                + parameters.getConstitution()*ParametersConstants.HEALTH_CON_COEFF);
        parameters.setHealthRegen(ParametersConstants.HEALTH_REGEN_BASE +
                parameters.getConstitution()*ParametersConstants.HEALTH_REGEN_COEFF/1000);
        parameters.setMaximumMana(ParametersConstants.MANA_BASE + experience.getLevel()*ParametersConstants.MANA_LVL_COEFF
                + parameters.getWisdom()*ParametersConstants.MANA_WIT_COEFF);
        parameters.setManaRegen(ParametersConstants.MANA_REGEN_BASE +
                parameters.getIntellect()*ParametersConstants.MANA_REGEN_COEFF/1000);
        parameters.setPhysicalAttack(ParametersConstants.PATACK_BASE +
                parameters.getStrength()*ParametersConstants.PATACK_STR_COEFF/1000);
        parameters.setPhysicalDefence(ParametersConstants.PDEF_BASE +
                parameters.getConstitution()*ParametersConstants.PDEF_CON_COEFF/1000);
        parameters.setCriticalChance(ParametersConstants.CRITCHANCE_BASE +
                parameters.getAgility()*ParametersConstants.CRITCHANCE_AGL_COEFF/1000);
        parameters.setAttackSpeed(10000/(ParametersConstants.ATKSPEED_BASE +
                parameters.getAgility()*ParametersConstants.ATKSPEED_AGL_COEFF/1000));
        parameters.setEvasion(ParametersConstants.EVASION_BASE +
                parameters.getAgility()*ParametersConstants.EVASION_AGL_COEFF/1000);
        parameters.setAccuracy(ParametersConstants.ACCURACY_BASE +
                parameters.getAgility()*ParametersConstants.ACCURACY_AGL_COEFF/1000);
        parameters.setAttackRange(ParametersConstants.ATTACK_RANGE_BASE);
        parameters.setMovingSpeed(ParametersConstants.MOVING_SPEED_BASE +
                parameters.getAgility()*ParametersConstants.MOVING_SPEED_AGL_COEFF);
    }
    @Override
    public void levelUpEvent() {
        updateParameters();
    }
    @Override
    public void levelDownEvent() {
        updateParameters();
    }
}
