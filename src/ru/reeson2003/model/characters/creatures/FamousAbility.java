package ru.reeson2003.model.characters.creatures;

import ru.reeson2003.model.characters.battle.Ability;
import ru.reeson2003.model.characters.battle.abilities.HitAbility;
import ru.reeson2003.model.service.exception.MyGameException;
import ru.reeson2003.model.service.exception.NonExistentKeyAbility;
import ru.reeson2003.model.service.exception.NotLearnStillAbility;

import java.util.HashMap;

/**
 * Created by nimtego_loc on 26.12.2016.
 */
public class FamousAbility {
    private HashMap<String, Ability> famousAbility;
    private Creature owner;

    protected FamousAbility(final Creature owner) {
        this.owner = owner;
        this.famousAbility =  new HashMap<>();
        setAbility(new HitAbility(owner));
    }
    final private void setAbility(final Ability ability) {
        famousAbility.put(ability.getName(), ability);
    }
    public void setOwner(Creature owner) {
        this.owner = owner;
    }
    public Creature getOwner() {
        return owner;
    }
    public HashMap<String, Ability> getFamousAbility() {
        return famousAbility;
    }

    public void setFamousAbility(HashMap<String, Ability> famousAbility) {
        this.famousAbility = famousAbility;
    }
    final public Ability getFamousAbilityByName(final String nameKey) throws MyGameException {
        if (!famousAbility.containsKey(nameKey)) {
            throw new NonExistentKeyAbility();
        }
        if (famousAbility.get(nameKey) == null) {
            throw new NotLearnStillAbility();
        }
        return famousAbility.get(nameKey);
    }
    final public void setFamousAbility(final Ability ability) {
        famousAbility.put(ability.getName(), ability);
    }
}
