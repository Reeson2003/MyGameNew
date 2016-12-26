package ru.reeson2003.model.characters.creatures;

/**
 * Created by nimtego_loc on 26.12.2016.
 */
public class PlayerAbilityController extends AbilityController{
    private TreeAvailableAbility treeAvailableAbility;

    private PlayerAbilityController() {
        super();
    }

    public static PlayerAbilityController playerAbility(Creature owner) {
        PlayerAbilityController creatureAbility = new PlayerAbilityController();
        creatureAbility.owner = owner;
 //       creatureAbility.tackedAbility.get(0).setOwner(owner);
 //       creatureAbility.treeAvailableAbility.getTreeAbilityByLevel(owner.getLevel());
        return creatureAbility;
    }

    public void setOwner(Creature owner) {
        this.owner = owner;
    }
}
