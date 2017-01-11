package ru.reeson2003.model.characters.creatures.NonPlayerCharacter.art_intellect;


import ru.reeson2003.model.characters.creatures.NonPlayerCharacter.Monster;
import ru.reeson2003.model.service.TimeDependent;


/**
 * Created by reeson on 20.12.16.
 */
public abstract class AI implements TimeDependent {
    private Monster owner;
    private AggressionList aggressionList;

    public Monster getOwner() {
        return owner;
    }

    public AggressionList getAggressionList() {
        return aggressionList;
    }

    public void setOwner(Monster owner) {
        this.owner = owner;
    }

    public void setAggressionList(AggressionList aggressionList) {
        this.aggressionList = aggressionList;
    }
}
