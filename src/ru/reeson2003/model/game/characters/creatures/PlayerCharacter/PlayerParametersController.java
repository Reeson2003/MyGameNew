package ru.reeson2003.model.game.characters.creatures.PlayerCharacter;

import ru.reeson2003.model.game.characters.creatures.Experience;
import ru.reeson2003.model.game.characters.creatures.ParametersController;

/**
 *
 */
public class PlayerParametersController extends ParametersController
        implements Experience.ExperienceListener {
    private Experience experience;

    public PlayerParametersController(Experience experience) {
        super();
        this.experience =  experience;
        experience.addListener(this);
        this.health = parameters.getMaximumHealth();
        this.mana = parameters.getMaximumMana();
    }

    @Override
    public void levelUpEvent() {
    }

    @Override
    public void levelDownEvent() {
    }

    @Override
    public void putOnEvent() {
        parameters = parameters.addParameters(equipment.getParameters());
    }

    @Override
    public void putOffEvent() {
        parameters = parameters.addParameters(equipment.getParameters());
    }

    @Override
    public ParametersController clone() {
        return null;
    }
}
