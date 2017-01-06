package ru.reeson2003.model.characters.battle;

import ru.reeson2003.model.characters.creatures.Creature;
import ru.reeson2003.model.service.TimeActivator;
import ru.reeson2003.model.service.TimeDependent;
import ru.reeson2003.model.service.exception.MyGameException;

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
            try {
                c.getAbility("Attack").use(c.getTarget());
            } catch (MyGameException e) {
                e.printStackTrace();
                return;
            }catch (NullPointerException e) {
                System.err.println(c.getName() + " doe's not have any target");
                return;
            }
        }
    }

    @Override
    public void tick(Date date) {
        activate();
    }
}
