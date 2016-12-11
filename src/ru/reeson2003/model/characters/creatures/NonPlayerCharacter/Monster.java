package ru.reeson2003.model.characters.creatures.NonPlayerCharacter;

import ru.reeson2003.model.characters.creatures.Creature;
import ru.reeson2003.model.characters.creatures.Experience;
import ru.reeson2003.model.characters.creatures.ParametersController;
import ru.reeson2003.model.characters.items.Equipment;

/**
 * Created by reeson on 11.12.16.
 */
public class Monster extends Creature{

    public Monster(String name, ParametersController parametersController, Experience experience, Equipment equipment) {
        super(name, parametersController);
    }
}
