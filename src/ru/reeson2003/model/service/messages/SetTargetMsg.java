package ru.reeson2003.model.service.messages;

import ru.reeson2003.model.characters.creatures.Creature;
import ru.reeson2003.model.characters.creatures.NonPlayerCharacter.Monster;
import ru.reeson2003.model.service.Abonent;
import ru.reeson2003.model.service.AbonentTable;
import ru.reeson2003.model.service.Address;
import ru.reeson2003.model.service.messages.Msg;

/**
 * Created by reeson on 03.01.17.
 */
public class SetTargetMsg extends Msg {
    private static final long serialVersionUID = -1189150918134123220L;

    public SetTargetMsg(Address from, Address to) {
        this.from = from;
        this.to = to;
    }
    @Override
    public void exec() {
        Abonent fromAbonent = AbonentTable.getAbonent(from);
        Abonent toAbonent = AbonentTable.getAbonent(to);
        Creature fromCreature = (Creature) fromAbonent;
        Creature toCreature = (Creature) toAbonent;
        fromCreature.setTarget(toCreature);
    }
}
