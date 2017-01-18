package ru.reeson2003.model.system;

import ru.reeson2003.model.game.characters.creatures.PlayerCharacter.PlayerCharacter;

import java.io.Serializable;
import java.util.List;

/**
 * Created by reeson on 18.01.17.
 */
public class User implements Serializable{
    private static final long serialVersionUID = 4619760882859033778L;
    private String name;
    private String password;
    private String eMail;
    private List<PlayerCharacter> characters;
}
