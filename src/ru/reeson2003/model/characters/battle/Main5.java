package ru.reeson2003.model.characters.battle;

import ru.reeson2003.model.characters.creatures.Creature;
import ru.reeson2003.model.characters.creatures.NonPlayerCharacter.Monster;
import ru.reeson2003.model.characters.creatures.NonPlayerCharacter.MonsterFactoryTestImpl;
import ru.reeson2003.model.characters.creatures.PlayerCharacter.PlayerCharacter;
import ru.reeson2003.model.service.TimeActivator;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by reeson on 20.12.16.
 */
public class Main5 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class.forName("ru.reeson2003.model.characters.creatures.NonPlayerCharacter.TestMonParMan").newInstance();
        PlayerCharacter player = PlayerCharacter.NewbiePlayerIstance("DanielDefo",500,100,50,10,10);
        MonsterFactoryTestImpl factory = new MonsterFactoryTestImpl();
        Monster m1 = factory.getMonster(1);
        Monster m2 = factory.getMonster(2);
        Monster m3 = factory.getMonster(3);
        Monster m4 = factory.getMonster(4);
        TestAI ai = new TestAI();
        ai.addMob(m1);
        ai.addMob(m2);
        ai.addMob(m3);
        ai.addMob(m4);
        List<Creature> targets = new ArrayList<>();
        targets.add(m1);
        targets.add(m2);
        targets.add(m3);
        targets.add(m4);
        Iterator<Creature> iterator = targets.iterator();
        while (player.getHealth() > 0 && (m1.getHealth() >0 || m2.getHealth() >0 || m3.getHealth() >0 || m4.getHealth() >0)) {
            TimeActivator.getInstance().tick(new Date());
            if(iterator.hasNext())
                player.getHitAbility().use(player);
            else
                iterator = targets.iterator();
        }
        System.out.println(player.getName() + " HP = " + player.getHealth());
        for(Creature c:targets)
            System.out.println(c.getName() + " HP = " + c.getHealth());
    }
}
