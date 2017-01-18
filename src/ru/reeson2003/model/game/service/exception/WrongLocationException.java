package ru.reeson2003.model.game.service.exception;

/**
 * Created by reeson on 16.01.17.
 */
public class WrongLocationException extends MyGameException {
    private static final long serialVersionUID = -875130838517050743L;
    private String info = "";

    public WrongLocationException() {
    }

    public WrongLocationException(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
