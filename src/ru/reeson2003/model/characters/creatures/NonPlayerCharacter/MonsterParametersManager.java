package ru.reeson2003.model.characters.creatures.NonPlayerCharacter;

import ru.reeson2003.model.characters.creatures.Parameters;

/**
 * Created by reeson on 11.12.16.
 */
public abstract class MonsterParametersManager {
    protected static MonsterParametersManager instance = new TestMonParMan();
    protected MonsterParametersManager( ) {
    }
    public static MonsterParametersManager getInstance() {
        return instance;
    }
    public abstract Parameters getParameters(int monsterID);
}
