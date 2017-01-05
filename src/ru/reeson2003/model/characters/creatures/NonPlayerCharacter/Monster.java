package ru.reeson2003.model.characters.creatures.NonPlayerCharacter;

import ru.reeson2003.model.characters.creatures.Creature;
import ru.reeson2003.model.characters.creatures.ParametersController;
import ru.reeson2003.model.service.TimeActivator;

/**
 * Created by reeson on 11.12.16.
 */
public class Monster extends Creature implements Cloneable {
    private int experienceForKill;

    public Monster(String name, ParametersController parametersController, int experienceForKill) {
        super(name, parametersController);
        this.experienceForKill = experienceForKill;
    }

    public void setExperienceForKill(int experienceForKill) {
        this.experienceForKill = experienceForKill;
    }

    @Override
    public void addExperience(int experience) {

    }

    @Override
    public int getExperienceForKill() {
        return experienceForKill;
    }

    @Override
    public void subtractExperienceForKill() {

    }

    @Override
    public boolean kill() {
        if (getHealth() == 0) {
            remove();
            return true;
        }else
            return false;
    }

    @Override
    public void remove() {
        super.remove();
        TimeActivator.getInstance().removeTimeDependent(this);
    }

    @Override
    public Monster clone() {
        Monster result = new Monster(this.name, this.parametersController.clone(), this.experienceForKill);
        return result;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n --------------------------------------------------------------";
    }
}
