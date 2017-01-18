package ru.reeson2003.model.game.service.messages;

import ru.reeson2003.model.game.characters.creatures.Creature;
import ru.reeson2003.model.game.service.AbonentTable;
import ru.reeson2003.model.game.service.Address;
import ru.reeson2003.model.game.service.exception.MyGameException;
import ru.reeson2003.model.game.service.exception.NonExistentAbilityKey;

/**
 * Created by nimtego_loc on 21.12.2016.
 */
public class LightHealMsg extends Msg {

    private static final long serialVersionUID = -8790437694525063495L;

    public LightHealMsg(Address from, Address to) {
        super(from, to);
    }

    @Override
    public void exec() {
        Creature giveHeal = (Creature) AbonentTable.getAbonent(to);
        Creature getHeal = (Creature) AbonentTable.getAbonent(from);
        try {
            giveHeal.getAbility("Light Heal").use(getHeal);
        } catch (NonExistentAbilityKey e) {
            e.printStackTrace();
            System.err.println(e.getInfo());
        } catch (MyGameException e) {
            e.printStackTrace();
        }
    }
}
