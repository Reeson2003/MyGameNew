package ru.reeson2003.model.characters.items;

import ru.reeson2003.model.characters.creatures.Parameters;

/**
 * Created by reeson on 07.12.16.
 */
public class Equip extends Item{
    private EquipType equipType;
    private Parameters parameters;
//  todo : add constructor
    protected Equip() {
    }

    public EquipType getEquipType() {
        return equipType;
    }
    public Parameters getParameters() {
        return parameters;
    }
    public void setEquipType(EquipType equipType) {
        this.equipType = equipType;
    }
    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }
}
