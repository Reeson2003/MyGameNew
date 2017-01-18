package ru.reeson2003.model.game.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Singleton. Contains list of objects, that are time-depending.
 * Objects must implement TimeDependent interface.
 */
public class TimeActivator {
    private static TimeActivator instance;
    private List<TimeDependent> timeDependents;

    private TimeActivator() {
        timeDependents = new ArrayList<>();
    }

    public static TimeActivator getInstance() {
        if (instance == null)
            instance = new TimeActivator();
        return instance;
    }

    public void addTimeDependent(TimeDependent timeDependent) {
        timeDependents.add(timeDependent);
    }

    public void removeTimeDependent(TimeDependent timeDependent) {
        timeDependents.remove(timeDependent);
    }

    /**
     * Activate all of the {@code TimeDependent}.
     * @param date {@link Date}
     */
    public void tick(Date date) {
        for (TimeDependent d: timeDependents) {
            d.tick(date);
        }
    }
}
