package ru.reeson2003.model.game.characters.items;


import ru.reeson2003.model.game.characters.WorldObject;

/**
 * Created by Тоня on 03.10.2016.
 */
public abstract class Item extends WorldObject {
//    todo : Enum ItemType or int id or inheritance?
    String name;
    int price;
    int weight;
//  todo : add constructor
    protected Item() {
        super();
        this.name = "NO NAME";
        this.price = 0;
        this.weight = 0;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

}
