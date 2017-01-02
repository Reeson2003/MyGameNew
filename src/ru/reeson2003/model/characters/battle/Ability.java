package ru.reeson2003.model.characters.battle;

import ru.reeson2003.model.characters.creatures.Creature;
import ru.reeson2003.model.service.Msg;

/**
 * Created by reeson on 20.12.16.
 */
public abstract class Ability {
    protected String name;
    protected String information;
    protected CoolDownAbility coolDownAbility;
    protected Creature owner;
    protected Msg msg;

    public final String getName() {return name;}
    public final void setName(final String name) {this.name = name;}
    public final CoolDownAbility getCoolDownAbility() {return coolDownAbility;}
    public final void setCoolDownAbility(final CoolDownAbility coolDownAbility) {this.coolDownAbility = coolDownAbility;}
    public abstract void use(Creature to);
    public abstract String getInformation();
}
