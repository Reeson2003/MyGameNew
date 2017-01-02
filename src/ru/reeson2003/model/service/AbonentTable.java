package ru.reeson2003.model.service;

import java.util.HashMap;
import java.util.Map;

/**
 * Abonents container. Use to get abonent by the address.
 */
public class AbonentTable {
    private static Map<Address, Abonent> abonents = new HashMap<>();

    public static void addAbonent(Abonent abonent) {
        abonents.put(abonent.getAddress(),abonent);
    }

    public static void removeAbonent(Abonent abonent) {
        abonents.remove(abonent.getAddress());
    }

    public static void removeAbonent(Address address) {
        abonents.remove(address);
    }

    public static Abonent getAbonent(Address address) {
        return abonents.get(address);
    }
}
