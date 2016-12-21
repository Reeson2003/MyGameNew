package ru.reeson2003.model.characters.battle.abilities;

import ru.reeson2003.model.service.Address;
import ru.reeson2003.model.service.Msg;

/**
 * Created by nimtego_loc on 21.12.2016.
 */
public class EasyHealMsg extends Msg {

    public EasyHealMsg(Address from) {this(from, null);}
    public EasyHealMsg(Address from, Address to) {super(from, to);}

    @Override
    public void exec() {
        // TODO: 21.12.2016
    }
}
