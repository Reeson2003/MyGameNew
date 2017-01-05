package ru.reeson2003.model.characters.battle.abilities;

import ru.reeson2003.model.characters.creatures.Creature;
import ru.reeson2003.model.service.AbonentTable;
import ru.reeson2003.model.service.Address;
import ru.reeson2003.model.service.messages.Msg;

/**
 * Created by nimtego_loc on 21.12.2016.
 */
public class EasyHealMsg extends Msg {
    private int healAmount;
    private int manaCost;

    public static Msg getEasyHealMsg(int healAmount, int manaCost) {
         EasyHealMsg result = new EasyHealMsg(null, null);
         result.healAmount = healAmount;
         result.manaCost = manaCost;
         return result;
    }

    public EasyHealMsg(Address from, Address to) {
        super(from, to);
    }

    @Override
    public void exec() {
        Creature giveHeal = (Creature) AbonentTable.getAbonent(to);
        Creature getHeal = (Creature) AbonentTable.getAbonent(from);
        giveHeal.changeHealth(healAmount);
        getHeal.changeMana(-manaCost);
    }
}
