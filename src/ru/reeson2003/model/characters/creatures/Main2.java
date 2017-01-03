package ru.reeson2003.model.characters.creatures;

import ru.reeson2003.model.characters.battle.Fight;
import ru.reeson2003.model.characters.creatures.NonPlayerCharacter.*;
import ru.reeson2003.model.characters.creatures.NonPlayerCharacter.Creature;
import ru.reeson2003.model.characters.creatures.PlayerCharacter.PlayerCharacter;
import ru.reeson2003.model.characters.items.Equip;
import ru.reeson2003.model.characters.items.EquipType;

/**
 * Created by reeson on 11.12.16.
 */
public class Main2 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class.forName("ru.reeson2003.model.characters.creatures.NonPlayerCharacter.TestMonParMan").newInstance();
        MonsterFactory factory = new MonsterFactoryTestImpl();
        ru.reeson2003.model.characters.creatures.NonPlayerCharacter.Creature creature = factory.getMonster(1);
        System.out.println(creature);
        Creature creature1 = creature.clone();
        System.out.println(creature == creature1);
        creature.changeMana(-15);
        creature.changeHealth(-100);
        System.out.println(creature1);
        System.out.println(creature);
        PlayerCharacter player = PlayerCharacter.NewbiePlayerIstance("xXxTURBOGLAD3000xXx",5,5,5,5,5);
        Equip turboGloves = new Equip(EquipType.Gloves);
        turboGloves.setParameters(new Parameters.ParametersBuilder().attackSpeed(50).build());
        Equip dragonSlayer = new Equip(EquipType.Weapon);
        dragonSlayer.setParameters(new Parameters.ParametersBuilder().physicalAttack(50).build());
        player.putOn(turboGloves);
        player.putOn(dragonSlayer);
        System.out.println(player);
        Fight fight = new Fight(player, creature);
        fight.fight();
        System.out.println(player);
        System.out.println(creature);
        creature.changeHealth(1000);
        player.changeHealth(1000);
        fight.fight();
        System.out.println(player);
        System.out.println(creature);

    }
}
