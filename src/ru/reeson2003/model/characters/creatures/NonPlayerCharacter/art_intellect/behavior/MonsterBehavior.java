package ru.reeson2003.model.characters.creatures.NonPlayerCharacter.art_intellect.behavior;

import ru.reeson2003.model.characters.creatures.Creature;
import ru.reeson2003.model.service.TimeDependent;

/**
 * Created by reeson on 12.01.17.
 */
public abstract class MonsterBehavior implements TimeDependent{
    protected Creature creature;

    public MonsterBehavior(Creature creature) {
        this.creature = creature;
    }
}
