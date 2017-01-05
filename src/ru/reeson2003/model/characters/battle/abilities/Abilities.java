package ru.reeson2003.model.characters.battle.abilities;

import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry;
import ru.reeson2003.model.characters.creatures.Creature;
import ru.reeson2003.model.service.TimeDependent;
import ru.reeson2003.model.service.exception.MyGameException;
import ru.reeson2003.model.service.exception.NonExistentKeyAbility;
import ru.reeson2003.model.service.exception.NotLearnStillAbility;

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

    final public Ability getAbility(final String name) throws NonExistentKeyAbility, NotLearnStillAbility {
        if (!abilities.containsKey(name)) {
            throw new NonExistentKeyAbility();
        }
        if (abilities.get(name) == null) {
            throw new NotLearnStillAbility();
        }
        return abilities.get(name);
    }

    @Override
    public void tick(Date date) {
        for (Map.Entry<String, Ability> pair: abilities.entrySet())
            pair.getValue().tick(date);
    }
}
