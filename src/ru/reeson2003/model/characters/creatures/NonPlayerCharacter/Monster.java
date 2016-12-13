package ru.reeson2003.model.characters.creatures.NonPlayerCharacter;

import ru.reeson2003.model.characters.creatures.Creature;
import ru.reeson2003.model.characters.creatures.ParametersController;

/**
 * Created by reeson on 11.12.16.
 */
public class Monster extends Creature implements Cloneable{

    public Monster(String name, ParametersController parametersController) {
        super(name, parametersController);
    }

    @Override
    public Monster clone() {
        Monster result = new Monster(this.name, this.parametersController.clone());
        return result;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n --------------------------------------------------------------";
    }
}
