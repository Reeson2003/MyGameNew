package ru.reeson2003.model.service.messages;

import ru.reeson2003.model.service.Address;

import java.io.Serializable;

/**
 * Message superclass to exchange between client and server.
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

    /**
     * Method for executing on server.
     */
    public abstract void exec();
}
