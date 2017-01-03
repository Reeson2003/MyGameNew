package ru.reeson2003.model.characters.creatures.NonPlayerCharacter;

import ru.reeson2003.model.characters.creatures.ParametersController;

/**
 * Created by reeson on 11.12.16.
 */
public class Creature extends ru.reeson2003.model.characters.creatures.Creature implements Cloneable{

    public Creature(String name, ParametersController parametersController) {
        super(name, parametersController);
    }

    @Override
    public Creature clone() {
        Creature result = new Creature(this.name, this.parametersController.clone());
        return result;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n --------------------------------------------------------------";
    }
}
