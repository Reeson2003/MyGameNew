package ru.reeson2003.model.service;

import java.io.Serializable;

/**
 * Created by reeson on 15.12.16.
 */
public abstract class Msg implements Serializable{
    private static final long serialVersionUID = 1L;

    protected Address from;
    protected Address to;

    public Msg() {
    }

    public Msg(Address from, Address to) {
        this.from = from;
        this.to = to;
    }

    public Address getFrom() {
        return from;
    }

    public Address getTo() {
        return to;
    }

    public void setFrom(Address from) {
        this.from = from;
    }

    public void setTo(Address to) {
        this.to = to;
    }

    public abstract void exec();
}
