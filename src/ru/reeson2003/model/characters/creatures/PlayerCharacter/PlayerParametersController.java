package ru.reeson2003.model.characters.creatures.PlayerCharacter;

import ru.reeson2003.model.characters.creatures.Experience;
import ru.reeson2003.model.characters.creatures.Parameters;
import ru.reeson2003.model.characters.creatures.ParametersConstants;
import ru.reeson2003.model.characters.creatures.ParametersController;
import ru.reeson2003.model.characters.items.Equipment;

/**
 * Created by User on 12.11.2016.
 * Контроллер создает объект Parameters, на основе базовых strength, constitution, agility, wisdom, intellect,
 * используя коэффициенты из ParametersConstants и инкапуслирует его. Контроллер подписывается на события levelUp() и
 * levelDown() объекта Experience, putOn() и putOff() объекта Equipment, полученных в параметрах , и обновляет параметры автоматически.
 */
public class PlayerParametersController extends ParametersController
        implements Experience.ExperienceListener, Equipment.EquipmentListener {

    private Experience experience;
    private Equipment equipment;

    public PlayerParametersController(int str, int con, int agl, int wit, int itl, Experience exp, Equipment eq) {
        parameters = new Parameters.ParametersBuilder().strength(str).
                constitution(con).agility(agl).wisdom(wit).intellect(itl).build();
        this.experience = exp;
        experience.addListener(this);
        this.equipment = eq;
        equipment.addListener(this);
        calculateParameters();
        this.health = parameters.getMaximumHealth();
        this.mana = parameters.getMaximumMana();
    }

    @Override
    public int getStrength() {
        return parameters.getStrength();
    }

    @Override
    public int getConstitution() {
        return parameters.getConstitution() > 0 ? parameters.getConstitution() : 0;
    }

    @Override
    public int getAgility() {
        return parameters.getAgility() > 0 ? parameters.getAgility() : 0;
    }

    @Override
    public int getWisdom() {
        return parameters.getWisdom() > 0 ? parameters.getWisdom() : 0;
    }

    @Override
    public int getIntellect() {
        return parameters.getIntellect() > 0 ? parameters.getIntellect() : 0;
    }

    @Override
    public int getMaximumHealth() {
        return parameters.getMaximumHealth() > ParametersConstants.MIN_HEALTH ?
                parameters.getMaximumHealth() : ParametersConstants.MIN_HEALTH;
    }

    @Override
    public int getMaximumMana() {
        return parameters.getMaximumMana() > ParametersConstants.MIN_MANA ?
                parameters.getMaximumMana() : ParametersConstants.MIN_MANA;
    }

    @Override
    public int getHealthRegen() {
        return parameters.getHealthRegen() > ParametersConstants.MIN_HEALTH_REGEN ?
                parameters.getHealthRegen() : ParametersConstants.MIN_HEALTH_REGEN;
    }

    @Override
    public int getManaRegen() {
        return parameters.getManaRegen() > ParametersConstants.MIN_MANA_REGEN ?
                parameters.getManaRegen() : ParametersConstants.MIN_MANA_REGEN;
    }

    @Override
    public int getPhysicalAttack() {
        return parameters.getPhysicalAttack() > ParametersConstants.MIN_PATACK ?
                parameters.getPhysicalAttack() : ParametersConstants.MIN_PATACK;
    }

    @Override
    public int getPhysicalDefence() {
        return parameters.getPhysicalDefence() > ParametersConstants.MIN_PDEF ?
                parameters.getPhysicalDefence() : ParametersConstants.MIN_PDEF;
    }

    @Override
    public int getCriticalChance() {
        return parameters.getCriticalChance() > ParametersConstants.MIN_CRITCHANCE ?
                parameters.getCriticalChance() : ParametersConstants.MIN_CRITCHANCE;
    }

    @Override
    public int getAttackSpeed() {
        return parameters.getAttackSpeed() > ParametersConstants.MIN_ATKSPEED ?
                parameters.getAttackSpeed() : ParametersConstants.MIN_ATKSPEED;
    }

    @Override
    public int getEvasion() {
        return parameters.getEvasion() > ParametersConstants.MIN_EVASION ?
                parameters.getEvasion() : ParametersConstants.MIN_EVASION;
    }

    @Override
    public int getAccuracy() {
        return parameters.getAccuracy() > ParametersConstants.MIN_ACCURACY ?
                parameters.getAccuracy() : ParametersConstants.MIN_ACCURACY;
    }

    @Override
    public int getAttackRange() {
        return parameters.getAttackRange() > ParametersConstants.MIN_ATTACK_RANGE ?
                parameters.getAttackRange() : ParametersConstants.MIN_ATTACK_RANGE;
    }

    @Override
    public int getMovingSpeed() {
        return parameters.getMovingSpeed() > ParametersConstants.MIN_MOVING_SPEED ?
                parameters.getMovingSpeed() : ParametersConstants.MIN_MOVING_SPEED;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getMana() {
        return mana;
    }

    private void calculateParameters() {
        parameters.setMaximumHealth(ParametersConstants.HEALTH_BASE + experience.getLevel() * ParametersConstants.HEALTH_LVL_COEFF
                + parameters.getConstitution() * ParametersConstants.HEALTH_CON_COEFF);

        parameters.setHealthRegen(ParametersConstants.HEALTH_REGEN_BASE +
                parameters.getConstitution() * ParametersConstants.HEALTH_REGEN_COEFF / ParametersConstants.COEFF_DIVISOR);

        parameters.setMaximumMana(ParametersConstants.MANA_BASE + experience.getLevel() * ParametersConstants.MANA_LVL_COEFF
                + parameters.getWisdom() * ParametersConstants.MANA_WIT_COEFF);

        parameters.setManaRegen(ParametersConstants.MANA_REGEN_BASE +
                parameters.getIntellect() * ParametersConstants.MANA_REGEN_COEFF / ParametersConstants.COEFF_DIVISOR);

        parameters.setPhysicalAttack(ParametersConstants.PATACK_BASE +
                parameters.getStrength() * ParametersConstants.PATACK_STR_COEFF / ParametersConstants.COEFF_DIVISOR);

        parameters.setPhysicalDefence(ParametersConstants.PDEF_BASE +
                parameters.getConstitution() * ParametersConstants.PDEF_CON_COEFF / ParametersConstants.COEFF_DIVISOR);

        parameters.setCriticalChance(ParametersConstants.CRITCHANCE_BASE +
                parameters.getAgility() * ParametersConstants.CRITCHANCE_AGL_COEFF / ParametersConstants.COEFF_DIVISOR);

        parameters.setAttackSpeed(ParametersConstants.ATKSPEED_BASE +
                parameters.getAgility() * ParametersConstants.ATKSPEED_AGL_COEFF / ParametersConstants.COEFF_DIVISOR);

        parameters.setEvasion(ParametersConstants.EVASION_BASE +
                parameters.getAgility() * ParametersConstants.EVASION_AGL_COEFF / ParametersConstants.COEFF_DIVISOR);

        parameters.setAccuracy(ParametersConstants.ACCURACY_BASE +
                parameters.getAgility() * ParametersConstants.ACCURACY_AGL_COEFF / ParametersConstants.COEFF_DIVISOR);

        parameters.setAttackRange(ParametersConstants.ATTACK_RANGE_BASE);

        parameters.setMovingSpeed(ParametersConstants.MOVING_SPEED_BASE +
                parameters.getAgility() * ParametersConstants.MOVING_SPEED_AGL_COEFF / ParametersConstants.COEFF_DIVISOR);
        if (health > parameters.getMaximumHealth())
            health = parameters.getMaximumHealth();
        if (mana > parameters.getMaximumMana())
            mana = parameters.getMaximumMana();
    }

    @Override
    public void levelUpEvent() {
        System.out.println("LVL UP!!! parameters controller");
        calculateParameters();
    }

    @Override
    public void levelDownEvent() {
        System.out.println("DNIWE EBANOE parameters controller");
        calculateParameters();
    }

//  todo : не работает пересчет производных параметров при надевании эквипа,
//  todo : изменяющего базовые параметры.

    @Override
    public void putOnEvent() {
        System.out.println("PUT ON parameters controller");
        parameters = parameters.addParameters(equipment.getParameters());
//        calculateParameters();
    }

    @Override
    public void putOffEvent() {
        System.out.println("PUT OFF parameters controller");
        parameters = parameters.addParameters(equipment.getParameters());
//        calculateParameters();
    }
}
