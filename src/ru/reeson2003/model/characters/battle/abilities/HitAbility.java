package ru.reeson2003.model.characters.battle.abilities;

import ru.reeson2003.model.characters.battle.Ability;
import ru.reeson2003.model.characters.battle.CoolDown;
import ru.reeson2003.model.characters.battle.HitMsg;
import ru.reeson2003.model.characters.creatures.Creature;


/**
 * Created by reeson on 20.12.16.
 */
public class HitAbility extends Ability {

    public HitAbility(Creature owner) {
        this.name = "Attack";
        this.owner = owner;
        this.msg = new HitMsg(this.owner.getAddress(), null);
        this.coolDown = new CoolDown(owner.getAttackSpeed() * 50);  // 1 - один хит персеконд (спид атак 1 по умолчанию думаю надо дабл делать)
        this.information = name + ", Causes a loss: " + owner.getPhysicalAttack();
    }
    @Override
    public void use(Creature to) {
        msg.setTo(to.getAddress());
        if(coolDown.isActive()) {
            coolDown.use();
            msg.exec();
        }
    }
}

