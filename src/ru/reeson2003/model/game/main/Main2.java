package ru.reeson2003.model.game.main;

import ru.reeson2003.model.game.characters.battle.abilities.LightHealAbility;
import ru.reeson2003.model.game.characters.battle.abilities.FuryHitAbility;
import ru.reeson2003.model.game.characters.battle.abilities.HitAbility;
import ru.reeson2003.model.game.characters.creatures.NonPlayerCharacter.Monster;
import ru.reeson2003.model.game.characters.creatures.NonPlayerCharacter.monster_factory.MonsterFactory;
import ru.reeson2003.model.game.characters.creatures.NonPlayerCharacter.monster_factory.MonsterFactoryTestImpl;
import ru.reeson2003.model.game.characters.creatures.Parameters;
import ru.reeson2003.model.game.characters.creatures.PlayerCharacter.PlayerCharacter;
import ru.reeson2003.model.game.characters.items.Equip;
import ru.reeson2003.model.game.characters.creatures.EquipType;
import ru.reeson2003.model.game.service.TimeActivator;
import ru.reeson2003.model.game.service.exception.MyGameException;
import ru.reeson2003.model.game.view.SwingView;

import java.util.Date;

/**
 * Created by reeson on 11.12.16.
 */
public class Main2 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class.forName("ru.reeson2003.model.game.characters.creatures.NonPlayerCharacter.monster_factory.TestMonParMan").newInstance();
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
        PlayerCharacter player = PlayerCharacter.NewbiePlayerInstance("xXxTURBOGLAD3000xXx");
        Equip turboGloves = new Equip(EquipType.Gloves);
        turboGloves.setParameters(new Parameters.ParametersBuilder().attackSpeed(0).manaRegen(10).build());
        Equip dragonSlayer = new Equip(EquipType.Weapon);
        dragonSlayer.setParameters(new Parameters.ParametersBuilder().physicalAttack(40).build());
        player.putOn(turboGloves);
        player.putOn(dragonSlayer);
       creature.changeHealth(-500);
        player.addAbility(new LightHealAbility(player));
        player.addAbility(new FuryHitAbility(player));
        player.addAbility(new HitAbility(player));
        creature.addAbility((new FuryHitAbility(creature)));
        TimeActivator timeActivator = TimeActivator.getInstance();
//        AI AI = new AI();
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
