package ru.reeson2003.model.game.characters.creatures.NonPlayerCharacter.art_intellect;


import ru.reeson2003.model.game.characters.creatures.Creature;
import ru.reeson2003.model.game.service.TimeDependent;


/**
 * Created by reeson on 20.12.16.
 */
public abstract class AI implements TimeDependent {
    public abstract void makeDamage(Creature creature, int damage);
    public abstract void kill();
}
