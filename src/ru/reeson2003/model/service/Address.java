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
//  todo : taking back id's when object disappears and make ability to use them.
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
    protected void finalize() {
        AbonentTable.removeAbonent(this);
        freeIDs.add(abonentId);
    }
}
