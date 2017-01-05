package ru.reeson2003.model.service.messages.remote_messages;

import ru.reeson2003.model.characters.creatures.NonPlayerCharacter.Monster;
import ru.reeson2003.model.service.Abonent;
import ru.reeson2003.model.service.AbonentTable;
import ru.reeson2003.model.service.Address;
import ru.reeson2003.model.service.messages.Msg;

/**
 * Created by reeson on 03.01.17.
 */
public class SetTargetMsgRemote extends Msg {
    public SetTargetMsgRemote(Address from, Address to) {
        this.from = from;
        this.to = to;
    }
    @Override
    public void exec() {
        Abonent fromAbonent = AbonentTable.getAbonent(from);
        Abonent toAbonent = AbonentTable.getAbonent(to);
        Monster fromCreature = (Monster)fromAbonent;
        Monster toCreature = (Monster)toAbonent;
        fromCreature.setTarget(toCreature);
    }
}
