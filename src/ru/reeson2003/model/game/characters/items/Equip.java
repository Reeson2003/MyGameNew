package ru.reeson2003.model.game.characters.items;

import ru.reeson2003.model.game.characters.creatures.EquipType;
import ru.reeson2003.model.game.characters.creatures.Parameters;

/**
 * Created by reeson on 07.12.16.
 */
public class Equip extends Item{
    private EquipType equipType;
    private Parameters parameters;
//  todo : add constructor
    public Equip(EquipType equipType) {
        this.equipType = equipType;
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
