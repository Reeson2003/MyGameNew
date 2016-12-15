package ru.reeson2003.model.characters.creatures;

import ru.reeson2003.model.characters.creatures.Fight;
import ru.reeson2003.model.characters.creatures.NonPlayerCharacter.Monster;
import ru.reeson2003.model.characters.creatures.NonPlayerCharacter.MonsterFactory;
import ru.reeson2003.model.characters.creatures.NonPlayerCharacter.MonsterFactoryTestImpl;
import ru.reeson2003.model.characters.creatures.Parameters;
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
        Monster monster = factory.getMonster(1);
        System.out.println(monster);
        Monster monster1 = monster.clone();
        System.out.println(monster == monster1);
        monster.addMana(-15);
        monster.addHealth(-100);
        System.out.println(monster1);
        System.out.println(monster);
        PlayerCharacter player = PlayerCharacter.NewbiePlayerIstance("xXxTURBOGLAD3000xXx",5,5,5,5,5);
        Equip turboGloves = new Equip(EquipType.Gloves);
        turboGloves.setParameters(new Parameters.ParametersBuilder().attackSpeed(50).build());
        Equip dragonSlayer = new Equip(EquipType.Weapon);
        dragonSlayer.setParameters(new Parameters.ParametersBuilder().physicalAttack(50).build());
        player.putOn(turboGloves);
        player.putOn(dragonSlayer);
        System.out.println(player);
        Fight fight = new Fight(player, monster);
        fight.fight();
        System.out.println(player);
        System.out.println(monster);
        monster.addHealth(1000);
        player.addHealth(1000);
        fight.fight();
        System.out.println(player);
        System.out.println(monster);

    }
}
