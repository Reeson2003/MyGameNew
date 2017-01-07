package ru.reeson2003.model.main;

import ru.reeson2003.model.characters.battle.Fight;
import ru.reeson2003.model.characters.battle.TestAI;
import ru.reeson2003.model.characters.battle.abilities.EasyHealAbility;
import ru.reeson2003.model.characters.battle.abilities.FuryHitAbility;
import ru.reeson2003.model.characters.battle.abilities.HitAbility;
import ru.reeson2003.model.characters.creatures.NonPlayerCharacter.*;
import ru.reeson2003.model.characters.creatures.NonPlayerCharacter.Monster;
import ru.reeson2003.model.characters.creatures.Parameters;
import ru.reeson2003.model.characters.creatures.PlayerCharacter.PlayerCharacter;
import ru.reeson2003.model.characters.items.Equip;
import ru.reeson2003.model.characters.creatures.EquipType;
import ru.reeson2003.model.service.TimeActivator;
import ru.reeson2003.model.service.exception.MyGameException;
import ru.reeson2003.view.SwingView;

import java.util.Date;

/**
 * Created by reeson on 11.12.16.
 */
public class Main2 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class.forName("ru.reeson2003.model.characters.creatures.NonPlayerCharacter.TestMonParMan").newInstance();
        MonsterFactory factory = new MonsterFactoryTestImpl();
        int i = 1;
        Monster creature = factory.getMonster(i++);
//        System.out.println(creature);
//        Monster creature1 = creature.clone();
//        System.out.println(creature == creature1);
//        creature.changeMana(-15);
//        creature.changeHealth(-100);
//        System.out.println(creature1);
//        System.out.println(creature);
        PlayerCharacter player = PlayerCharacter.NewbiePlayerIstance("xXxTURBOGLAD3000xXx");
        Equip turboGloves = new Equip(EquipType.Gloves);
        turboGloves.setParameters(new Parameters.ParametersBuilder().attackSpeed(0).manaRegen(10).build());
        Equip dragonSlayer = new Equip(EquipType.Weapon);
        dragonSlayer.setParameters(new Parameters.ParametersBuilder().physicalAttack(40).build());
        player.putOn(turboGloves);
        player.putOn(dragonSlayer);
        Fight fight = new Fight(player, creature);
        creature.changeHealth(-500);
        player.addAbility(new EasyHealAbility(player));
        player.addAbility(new FuryHitAbility(player));
        player.addAbility(new HitAbility(player));
        creature.addAbility((new FuryHitAbility(creature)));
        TimeActivator timeActivator = TimeActivator.getInstance();
        TestAI AI = new TestAI();
        while (true) {
            timeActivator.tick(new Date());
            SwingView.getInstance().clear()
                    .append(player)
                    .append(creature)
                    .show();
            try {
                if (player.getHealth() < player.getMaximumHealth())
                    player.getAbility("Easy Heal").use(player);
                else
                    player.getAbility("Fury Hit").use(creature);
                player.getAbility("Attack").use(creature);
            } catch (MyGameException e) {
            }
            if (creature.getHealth() == 0) {
                creature = factory.getMonster(i++);
                creature.addAbility(new FuryHitAbility(creature));
                creature.addAbility(new HitAbility(creature));
            }
            if (i > 4)
                i = 1;
        }
    }
}
