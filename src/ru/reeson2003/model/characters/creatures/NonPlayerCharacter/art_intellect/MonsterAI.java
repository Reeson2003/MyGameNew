package ru.reeson2003.model.characters.creatures.NonPlayerCharacter.art_intellect;

import ru.reeson2003.model.characters.creatures.Creature;
import ru.reeson2003.model.characters.creatures.NonPlayerCharacter.art_intellect.behavior.MonsterBehavior;

import java.util.Date;

/**
 * Created by reeson on 12.01.17.
 */
public abstract class MonsterAI extends AI {
    protected boolean isDead = false;
    protected Creature owner;
    protected AggressionList aggressionList;
    protected MonsterBehavior behavior;


    public MonsterAI(Creature owner) {
        this.aggressionList = new AggressionList();
        this.owner = owner;
    }

    @Override
    public void tick(Date date) {
        behavior.tick(date);
    }

    @Override
    public void makeDamage(Creature creature, int damage) {
        if (!isDead) {
            aggressionList.changeAggression(creature, damage);
            if (owner.getHealth() - damage < 0) {
                kill();
                distributeExperience();
                owner.remove();
            }
            owner.changeHealth(-damage);
        }
    }

    @Override
    public void kill() {
        isDead = true;
    }

    private void distributeExperience() {
        ExperienceDistributor.distributeExperience(aggressionList.getAggressionMap(),
                owner.getBonusExperience());
    }
}
