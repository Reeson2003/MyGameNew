package ru.reeson2003.model.characters.creatures.NonPlayerCharacter.art_intellect;

import ru.reeson2003.model.characters.creatures.Creature;
import ru.reeson2003.model.characters.creatures.NonPlayerCharacter.art_intellect.behavior.CalmBehavior;

/**
 * Created by reeson on 12.01.17.
 */
public class AntQueenAI extends MonsterAI {
    public AntQueenAI(Creature owner) {
        super(owner);
        this.behavior = new CalmBehavior(owner);
    }
}
