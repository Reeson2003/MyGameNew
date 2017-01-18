package ru.reeson2003.model.game.service;

import java.util.Date;

/**
 * Interface for time-depending objects.
 */
public interface TimeDependent {
    public void tick(Date date);
}
