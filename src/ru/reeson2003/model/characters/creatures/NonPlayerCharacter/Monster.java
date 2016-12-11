package ru.reeson2003.model.characters.creatures.NonPlayerCharacter;

import ru.reeson2003.model.characters.creatures.Creature;
import ru.reeson2003.model.characters.creatures.Experience;
import ru.reeson2003.model.characters.creatures.ParametersController;
import ru.reeson2003.model.characters.items.Equipment;

/**
 * Created by reeson on 11.12.16.
 */
public class Monster extends Creature {

    public Monster(final String name) { //For test
        this(name, ParametersController.getMonsterParametersController(1), new Experience(0),
                new Equipment());
    }
    public Monster(String name, ParametersController parametersController, Experience experience, Equipment equipment) {
        super(name, parametersController);
    }
}
