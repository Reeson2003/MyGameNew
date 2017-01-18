package ru.reeson2003.model.game.characters.creatures.NonPlayerCharacter.monster_factory;

import ru.reeson2003.model.game.characters.creatures.NonPlayerCharacter.Monster;

/**
 * Interface {@code MonsterFactory} produces simple-way
 * to get {@code Monster} by it's {@code ID}.
 */
public interface MonsterFactory {
    Monster getMonster(int monsterID);
}
