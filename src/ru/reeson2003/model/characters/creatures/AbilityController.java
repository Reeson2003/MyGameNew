package ru.reeson2003.model.characters.creatures;

import ru.reeson2003.model.characters.battle.Ability;
import ru.reeson2003.model.characters.battle.abilities.HitAbility;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nimtego_loc on 26.12.2016.
 */
public abstract class AbilityController {
    protected List<Ability> tackedAbility;
    protected Creature owner;

    protected AbilityController() {
        tackedAbility = new ArrayList<>();
        tackedAbility.add(new HitAbility(null));
    }
    public void setOwner(Creature owner) {
        this.owner = owner;
    }
}
