package ru.reeson2003.model.game.service;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Instance contains unique long field abonentID.
 */
public class Address implements Serializable{
    private static final long serialVersionUID = 1L;
    private static int abonentIdCreator = Integer.MIN_VALUE;
    private static Queue<Integer> freeIDs = new ArrayDeque<>();
    final private int abonentId;

    /**
     * makes unique abonentID.
     */
    public Address() {
        Integer id = freeIDs.poll();
        if (id == null)
            this.abonentId = abonentIdCreator++;
        else
            this.abonentId = id;
    }

    public int getAbonentId() {
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
        return abonentId;
    }

    /**
     * after finalizing returns its abonentID into freeId's queue.
     */
    @Override
    protected void finalize() {
        AbonentTable.removeAbonent(this);
        freeIDs.add(abonentId);
    }
}
