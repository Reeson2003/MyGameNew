package ru.reeson2003.model.map;

import ru.reeson2003.model.characters.creatures.NonPlayerCharacter.MonsterParametersManager;

/**
 * Created by reeson on 11.12.16.
 */
public class Main2 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class.forName("ru.reeson2003.model.characters.creatures.NonPlayerCharacter.TestMonParMan").newInstance();
        System.out.println(MonsterParametersManager.getInstance().getParameters(1));
    }
}
