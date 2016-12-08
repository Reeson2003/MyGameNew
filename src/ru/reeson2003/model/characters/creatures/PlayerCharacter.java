package ru.reeson2003.model.characters.creatures;

/**
 * Created by reeson on 08.12.16.
 */
public class PlayerCharacter extends Creature {
//    private Account account;  заготовка на будущее
//    private Quests quests;    заготовка на будущее
    private ParametersFactory parametersFactory;
    public PlayerCharacter() {

    }

    public static PlayerCharacter NewbiePlayerIstance(String name, int str, int con, int agl, int wit, int itl) {
        PlayerCharacter playerCharacter = new PlayerCharacter();
        playerCharacter.name = name;
        playerCharacter.experience = new Experience(0);
        playerCharacter.parametersFactory =
                ParametersFactory.getPlayerParametersFactory(str, con, agl, wit, itl, playerCharacter.experience);
        return playerCharacter;
    }
}
