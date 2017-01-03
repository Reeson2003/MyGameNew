package ru.reeson2003.model.service.client_content;

import ru.reeson2003.model.characters.creatures.Creature;
import ru.reeson2003.model.service.Address;

import java.io.Serializable;

/**
 * Created by reeson on 02.01.17.
 */
public class CreatureSurrogate implements Serializable {
    private static final long serialVersionUID = 14L;
    Address address;
    private String name;
    private int health;
    private int maximumHealth;
    private int mana;
    private int maximumMana;

    public static CreatureSurrogate createSurrogate(Creature creature) {
        return new CreatureSurrogate(creature);
    }

    private CreatureSurrogate(Creature creature) {
        this.address = creature.getAddress();
        this.name = creature.getName();
        this.health = creature.getHealth();
        this.maximumHealth = creature.getMaximumHealth();
        this.mana = creature.getMana();
        this.maximumMana = creature.getMaximumMana();
    }

    public CreatureSurrogate() {

    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getMaximumHealth() {
        return maximumHealth;
    }

    public Address getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setMaximumHealth(int maximumHealth) {
        this.maximumHealth = maximumHealth;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return name + ", health: " + health + "\\" + maximumHealth +
                ", mana: " + mana + "\\" + maximumMana +
                ", Address: " + address.getAbonentId();
    }
}
