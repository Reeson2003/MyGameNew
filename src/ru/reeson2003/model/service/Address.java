package ru.reeson2003.model.service;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by reeson on 15.12.16.
 */
public class Address {
    private static long abonentIdCreator = 100;
    private static Queue<Long> freeIDs = new ArrayDeque<>();
    final private long abonentId;

    public Address() {
        Long id = freeIDs.poll();
        if (id == null)
            this.abonentId = abonentIdCreator++;
        else
            this.abonentId = id;
    }

    public long getAbonentId() {
        return abonentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        return abonentId == address.abonentId;
    }

    @Override
    public int hashCode() {
        return (int) (abonentId ^ (abonentId >>> 32));
    }

    @Override
    protected void finalize() {
        AbonentTable.removeAbonent(this);
        freeIDs.add(abonentId);
    }
}
