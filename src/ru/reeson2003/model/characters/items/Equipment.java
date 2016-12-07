package ru.reeson2003.model.characters.items;


import ru.reeson2003.model.characters.creatures.Parameters;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by reeson on 05.12.16.
 */
public class Equipment {
    private Map<EquipType, Equip> equipment;
    private Parameters parameters;
    public Equipment() {
        parameters = new Parameters.ParametersBuilder().build();
        equipment = new HashMap<>();
    }
    public Equip wearEquip(Equip equip) {
        Equip result = equipment.put(equip.getEquipType(), equip);
        parameters.subtractParameters(result.getParameters());
        parameters.addParameters(equip.getParameters());
        return result;
    }
    public Equip undressEquip(Equip equip) {
        Equip result = equipment.remove(equip.getEquipType());
        parameters.subtractParameters(result.getParameters());
        return result;
    }


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
//    todo : getMovingSpeed(), getAttackRange();
}
