package ru.reeson2003.model.characters.battle;

import ru.reeson2003.model.service.TimeActivator;
import ru.reeson2003.model.service.TimeDependent;

import java.util.Date;

/**
 * Created by reeson on 20.12.16.
 */
public abstract class CoolDownAbility extends Ability implements TimeDependent {
    protected boolean isActive;
    Date useDate;
    Date currentDate;
    int coolDownMilliseconds;

    protected CoolDownAbility(int coolDownMilliseconds) {
        TimeActivator.getInstance().addTimeDependent(this);
        isActive = true;
        this.coolDownMilliseconds = coolDownMilliseconds;
    }

    public void use() {
        useDate = currentDate;
        isActive = false;
    }

    @Override
    public void tick(Date date) {
        currentDate = date;
        if (!isActive) {
            if((useDate.getTime() + coolDownMilliseconds) <= date.getTime())
                isActive = true;
        }
    }

    @Override
    protected void finalize() {
        TimeActivator.getInstance().removeTimeDependent(this);
    }
}
