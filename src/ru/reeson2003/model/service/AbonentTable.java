package ru.reeson2003.model.service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by reeson on 16.12.16.
 */
public class AbonentTable {
    private static Map<Long, Abonent> abonents = new HashMap<>();

    public static void addAbonent(Abonent abonent) {
        abonents.put(abonent.getAddress().getAbonentId(),abonent);
    }

    public static void removeAbonent(Abonent abonent) {
        abonents.remove(abonent.getAddress().getAbonentId());
    }

    public static void removeAbonent(Address address) {
        abonents.remove(address.getAbonentId());
    }

    public static Abonent getAbonent(Address address) {
        return abonents.get(address.getAbonentId());
    }
}
