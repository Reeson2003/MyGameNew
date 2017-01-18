package ru.reeson2003.model.game.characters.items;


/**
 * Created by Тоня on 01.10.2016.
 */
public class ItemPacket extends Item{
//    todo : dummy for future
    int amount;
    int elementPrice;
    int elementWeight;

    public int getElementPrice() {
        return elementPrice;
    }
    public int getElementWeight() {
        return elementWeight;
    }
    public int getAmount() {
        return amount;
    }

}
