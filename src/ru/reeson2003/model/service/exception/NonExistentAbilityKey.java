package ru.reeson2003.model.service.exception;

/**
 * Created by nimtego_loc on 04.01.2017.
 */
public class NonExistentAbilityKey extends MyGameException{
    private static final long serialVersionUID = -4565567984617226709L;
    private String info = "Target does not have this ability";

    public String getInfo() {
        return info;
    }
}
