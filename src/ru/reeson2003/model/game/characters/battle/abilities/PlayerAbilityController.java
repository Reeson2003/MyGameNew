package ru.reeson2003.model.game.characters.battle.abilities;

import ru.reeson2003.model.game.characters.creatures.Creature;

/**
 * Created by nimtego_loc on 26.12.2016.
 */
public class PlayerAbilityController{
    private TreeAvailableAbility treeAvailableAbility;

    private PlayerAbilityController() {
        super();
    }

    public static PlayerAbilityController playerAbility(Creature owner) {
        PlayerAbilityController creatureAbility = new PlayerAbilityController();
        return creatureAbility;
    }
}
