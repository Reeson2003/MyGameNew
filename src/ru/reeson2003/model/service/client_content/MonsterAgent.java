package ru.reeson2003.model.service.client_content;

import ru.reeson2003.model.characters.creatures.NonPlayerCharacter.Monster;
import ru.reeson2003.model.service.Address;

import java.io.Serializable;

/**
 * Created by reeson on 02.01.17.
 */
public class MonsterAgent implements Serializable {
    Address address;
    private String name;
    private int health;
    private int maximumHealth;
    private int mana;
    private int maximumMana;

    public static MonsterAgent getAgent(Monster monster) {
        return new MonsterAgent(monster);
    }

    private MonsterAgent(Monster monster) {
        this.address = monster.getAddress();
        this.name = monster.getName();
        this.health = monster.getHealth();
        this.maximumHealth = monster.getMaximumHealth();
        this.mana = monster.getMana();
        this.maximumMana = monster.getMaximumMana();
    }

    public MonsterAgent() {

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
