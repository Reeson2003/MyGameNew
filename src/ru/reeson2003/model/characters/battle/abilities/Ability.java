package ru.reeson2003.model.characters.battle.abilities;

import ru.reeson2003.model.characters.battle.CoolDown;
import ru.reeson2003.model.characters.creatures.Creature;
import ru.reeson2003.model.service.exception.MyGameException;
import ru.reeson2003.model.service.messages.Msg;

/**
 * Created by reeson on 20.12.16.
 */
public abstract class Ability {
    protected String name;
    protected String information;
    protected CoolDown coolDown;
    protected Creature owner;
    protected int manaCost = 0;
    protected int healCost = 0;
    protected Msg msg;

    public final String getName() {
        return name;
    }

    public final String getInformation() {
        return information;
    }

    public final void setName(final String name) {
        this.name = name;
    }

    public final void setInformation(String information) {
        this.information = information;
    }

    public final CoolDown getCoolDown() {
        return coolDown;
    }

    public final void setCoolDown(final CoolDown coolDown) {
        this.coolDown = coolDown;
    }

    public final void setCoolDownMilliseconds(int milliseconds) {
        if (milliseconds < 0)
            throw new IllegalArgumentException("Cooldown time must be 0 or more");
        else
            this.coolDown.setCoolDownMilliseconds(milliseconds);
    }

    public final void setCoolDownSeconds(int seconds) {
        if (seconds < 0)
            throw new IllegalArgumentException("Cooldown time must be 0 or more");
        else
            this.coolDown.setCoolDownMilliseconds(seconds*1000);
    }

    public final void setCoolDownMinutes(int minutes) {
        if (minutes < 0)
            throw new IllegalArgumentException("Cooldown time must be 0 or more");
        else
            this.coolDown.setCoolDownMilliseconds(minutes * 60000);
    }

    public abstract void use(Creature to) throws MyGameException;
}
