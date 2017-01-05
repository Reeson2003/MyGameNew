package ru.reeson2003.model.characters.battle;

import ru.reeson2003.model.characters.creatures.Creature;
import ru.reeson2003.model.service.TimeActivator;
import ru.reeson2003.model.service.TimeDependent;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by reeson on 20.12.16.
 */
public class TestAI implements TimeDependent {
    private List<Creature> mobs;

    public TestAI() {
        mobs = new ArrayList<>();
        TimeActivator.getInstance().addTimeDependent(this);
    }

    public void addMob(Creature creature) {
        mobs.add(creature);
    }

    public void activate() {
        for (Creature c : mobs) {
        }
    }

    @Override
    public void tick(Date date) {
        activate();
    }
}
