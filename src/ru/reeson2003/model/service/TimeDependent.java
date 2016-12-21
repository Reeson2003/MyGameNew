package ru.reeson2003.model.service;

import java.util.Date;

/**
 * Created by reeson on 20.12.16.
 */
public interface TimeDependent {
    public void tick(Date date);
}
