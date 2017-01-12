package ru.reeson2003.model.characters.battle;

import ru.reeson2003.model.service.TimeDependent;

import java.util.Date;

/**
 * Class for check cool-down of an abilities and others.
 */
public class CoolDown implements TimeDependent {
    private boolean isActive;
    private Date useDate;
    private Date currentDate;
    private int coolDownMilliseconds;

    public CoolDown(int coolDownMilliseconds) {
        isActive = true;
        this.coolDownMilliseconds = coolDownMilliseconds;
    }

    public CoolDown() {
    }

    /**
     * Starts countdown.
     */
    public void use() {
        if (isActive) {
            useDate = currentDate;
            isActive = false;
        }
    }

    public boolean isActive() {
        return isActive;
    }

    public int getCoolDownMilliseconds() {
        return coolDownMilliseconds;
    }

    public void setCoolDownMilliseconds(int coolDownMilliseconds) {
        this.coolDownMilliseconds = coolDownMilliseconds;
    }

    @Override
    public void tick(Date date) {
        if (useDate == null)
            useDate = date;
        currentDate = date;
        if (!isActive) {
            if((useDate.getTime() + coolDownMilliseconds) <= date.getTime())
                isActive = true;
        }
    }
}
