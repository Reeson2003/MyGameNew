package ru.reeson2003.model.characters.creatures.NonPlayerCharacter;

import ru.reeson2003.model.characters.creatures.Creature;
import ru.reeson2003.model.characters.creatures.Experience;
import ru.reeson2003.model.characters.creatures.ParametersController;
import ru.reeson2003.model.characters.items.Equipment;

/**
 * Created by reeson on 11.12.16.
 */
public class Monster extends Creature{
    private final int experienceAfterDeathMonster;
    private boolean aggressionIndicator;
    //если нет equipment то дроп можно генерировать при смерти (Equipment equipment не нужен) хотя нужен какойто маркер чтоб крыса ант квин не генерила 
    public Monster(String name, ParametersController parametersController, int experienceAfterDeathMonster, boolean aggressionIndicator) {
        super(name, parametersController);
        this.experienceAfterDeathMonster = experienceAfterDeathMonster;
        this.aggressionIndicator = aggressionIndicator;
    }
    public void setAggressionIndicator(final boolean aggressionIndicator) {
        this.aggressionIndicator = aggressionIndicator;
    }
    public boolean getAggressionIndicator() {return aggressionIndicator;}
    public int getExperienceAfterDeathMonster() {return experienceAfterDeathMonster;}
}
