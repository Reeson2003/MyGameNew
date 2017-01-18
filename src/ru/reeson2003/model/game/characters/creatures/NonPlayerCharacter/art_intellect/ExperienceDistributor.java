package ru.reeson2003.model.game.characters.creatures.NonPlayerCharacter.art_intellect;

import ru.reeson2003.model.game.characters.creatures.Creature;

import java.util.Map;

/**
 * Created by nimtego_loc on 06.01.2017.
 */
public class ExperienceDistributor {
    public static void distributeExperience(Map<Creature, Integer> map, int experience) {
        if (experience != 0) {
            int totalAggression = 0;
            for (Map.Entry<Creature, Integer> pair : map.entrySet()) {
                totalAggression += pair.getValue();
            }
            for (Map.Entry<Creature, Integer> pair : map.entrySet()) {
                int exp = pair.getValue() * experience / totalAggression;
                pair.getKey().addExperience(exp);
            }
        }
    }
}
