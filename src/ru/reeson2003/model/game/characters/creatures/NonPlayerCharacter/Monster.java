package ru.reeson2003.model.game.characters.creatures.NonPlayerCharacter;

import ru.reeson2003.model.game.characters.creatures.Creature;
import ru.reeson2003.model.game.characters.creatures.NonPlayerCharacter.art_intellect.AI;
import ru.reeson2003.model.game.characters.creatures.ParametersController;

import java.util.Date;

/**
 * Created by reeson on 11.12.16.
 */
public class Monster extends Creature implements Cloneable {

    private AI ai;

    public Monster(String name, ParametersController parametersController) {
        super(name, parametersController);
    }

    @Override
    public void makeDamage(Creature creature, int damage) {
        ai.makeDamage(creature, damage);
    }

    public AI getAi() {
        return ai;
    }

    public void setAi(AI ai) {
        this.ai = ai;
    }

    @Override
    public void tick(Date date) {
        super.tick(date);
        ai.tick(date);
    }

    @Override
    public void addExperience(int experience) {

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
