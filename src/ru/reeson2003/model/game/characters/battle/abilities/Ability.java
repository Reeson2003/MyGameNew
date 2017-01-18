package ru.reeson2003.model.game.characters.battle.abilities;

import ru.reeson2003.model.game.characters.battle.CoolDown;
import ru.reeson2003.model.game.characters.creatures.Creature;
import ru.reeson2003.model.game.service.exception.MyGameException;
import ru.reeson2003.model.game.service.TimeDependent;

import java.util.Date;

/**
 * Created by reeson on 20.12.16.
 */
public abstract class Ability implements TimeDependent {
    protected String name;
    protected String information;
    protected CoolDown coolDown;
    protected Creature owner;
    protected int manaCost = 0;
    protected int healthCost = 0;

    protected Ability(Creature owner) {
        this.owner = owner;
    }

    public final String getName() {
        return name;
    }

    public String getInformation() {
        return information;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public CoolDown getCoolDown() {
        return coolDown;
    }

    public void setCoolDown(final CoolDown coolDown) {
        this.coolDown = coolDown;
    }

    public void setCoolDownMilliseconds(int milliseconds) {
        if (milliseconds < 0)
            throw new IllegalArgumentException("Cool down time must be 0 or more");
        else
            this.coolDown.setCoolDownMilliseconds(milliseconds);
    }

    public void setCoolDownSeconds(int seconds) {
        if (seconds < 0)
            throw new IllegalArgumentException("Cool down time must be 0 or more");
        else
            this.coolDown.setCoolDownMilliseconds(seconds*1000);
    }

    public void setCoolDownMinutes(int minutes) {
        if (minutes < 0)
            throw new IllegalArgumentException("Cool down time must be 0 or more");
        else
            this.coolDown.setCoolDownMilliseconds(minutes * 60000);
    }

    public void setOwner(Creature creature) {
        this.owner = creature;
    }


    @Override
    public void tick(Date date) {
        coolDown.tick(date);
    }
    public abstract void use(Creature to) throws MyGameException;



}
