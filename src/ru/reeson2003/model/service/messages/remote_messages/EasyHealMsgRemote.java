package ru.reeson2003.model.service.messages.remote_messages;

import ru.reeson2003.model.characters.creatures.Creature;
import ru.reeson2003.model.service.Abonent;
import ru.reeson2003.model.service.AbonentTable;
import ru.reeson2003.model.service.Address;
import ru.reeson2003.model.service.messages.Msg;

/**
 * Created by reeson on 02.01.17.
 */
public class EasyHealMsgRemote extends Msg {
    public EasyHealMsgRemote(Address from, Address to) {
        this.from = from;
        this.to = to;
    }
    @Override
    public void exec() {
        Abonent fromAbonent = AbonentTable.getAbonent(from);
        Abonent toAbonent = AbonentTable.getAbonent(to);
        Creature giveHeal = (Creature)fromAbonent;
        Creature getHeal = (Creature)toAbonent;
        getHeal.getHealAbility().use(getHeal);
    }
}
