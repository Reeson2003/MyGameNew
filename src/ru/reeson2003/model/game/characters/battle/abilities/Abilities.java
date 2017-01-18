package ru.reeson2003.model.game.characters.battle.abilities;

import ru.reeson2003.model.game.characters.creatures.Creature;
import ru.reeson2003.model.game.service.TimeDependent;
import ru.reeson2003.model.game.service.exception.NonExistentAbilityKey;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by nimtego_loc on 26.12.2016.
 */
public class Abilities implements TimeDependent {
    private HashMap<String, Ability> abilities;
    private Creature owner;

    public Abilities(final Creature owner) {
        this.owner = owner;
        this.abilities = new HashMap<>();
    }

    public void add(final Ability ability) {
        abilities.put(ability.getName(), ability);
        ability.setOwner(this.owner);
    }

    public void remove(String name) {
        abilities.remove(abilities);
    }

    public void setOwner(Creature owner) {
        this.owner = owner;
    }

    public Creature getOwner() {
        return owner;
    }

    public HashMap<String, Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(HashMap<String, Ability> abilities) {
        this.abilities = abilities;
    }

    final public Ability getAbility(final String name) throws NonExistentAbilityKey {
        if (!abilities.containsKey(name)) {
            throw new NonExistentAbilityKey();
        }
        return abilities.get(name);
    }

    @Override
    public void tick(Date date) {
        for (Map.Entry<String, Ability> pair: abilities.entrySet())
            pair.getValue().tick(date);
    }
}
