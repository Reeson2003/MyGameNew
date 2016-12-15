package ru.reeson2003.model.service;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by reeson on 15.12.16.
 */
public class Address {
    private static AtomicInteger abonentIdCreator = new AtomicInteger(0);
    final private int abonentId;

    public Address() {
        this.abonentId = abonentIdCreator.getAndIncrement();
    }

    public int getAbonentId() {
        return abonentId;
    }

    public interface Abonent {
        Address getAddress();
    }
}
