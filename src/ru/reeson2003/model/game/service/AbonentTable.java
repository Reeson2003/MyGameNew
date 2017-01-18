package ru.reeson2003.model.game.service;

import java.util.HashMap;
import java.util.Map;

/**
 * Abonents container. Use to get abonent by the address.
 */
public class AbonentTable {
    private static Map<Address, Abonent> abonents = new HashMap<>();

    public static void addAbonent(Abonent abonent) {
        abonents.put(abonent.getAddress(), abonent);
    }

    public static void removeAbonent(Abonent abonent) {
        abonents.remove(abonent.getAddress());
    }

    public static void removeAbonent(Address address) {
        abonents.remove(address);
    }

    public static Abonent getAbonent(Address address) {
        if (!abonents.containsKey(address))
            throw new IllegalArgumentException("Not such Address in AbonentTable.");
        else
            return abonents.get(address);
    }
}
