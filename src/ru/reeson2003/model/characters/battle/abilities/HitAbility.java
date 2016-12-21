package ru.reeson2003.model.characters.battle.abilities;

import ru.reeson2003.model.characters.battle.Ability;
import ru.reeson2003.model.characters.battle.CoolDownAbility;
import ru.reeson2003.model.characters.battle.HitMsg;
import ru.reeson2003.model.characters.creatures.Creature;


/**
 * Created by reeson on 20.12.16.
 */
public class HitAbility extends Ability {

    public HitAbility(Creature owner) {
        this.name = "Atack";
        this.information = "Causes a loss";
        this.owner = owner;
        this.msg = new HitMsg(this.owner.getAddress(), null);
        this.coolDownAbility = new CoolDownAbility(owner.getAttackSpeed() * 1000);  // 1 - один хит персеконд (спид атак 1 по умолчанию думаю надо дабл делать)
    }
    @Override
    public void use(Creature to) {
        msg.setTo(to.getAddress());
        if(coolDownAbility.getIsActive()) {
            coolDownAbility.use();
            msg.exec();
        }
    }
    @Override
    public String getInformation() {
        return  "" +information +" - " +owner.getPhysicalAttack();
    }
}

