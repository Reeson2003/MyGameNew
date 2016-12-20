package ru.reeson2003.model.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by reeson on 20.12.16.
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

    public void tick(Date date) {
        for (TimeDependent d: timeDependents) {
            d.tick(date);
        }
    }
}
