package ru.reeson2003.model.characters.battle.abilities;

import ru.reeson2003.model.characters.creatures.NonPlayerCharacter.Monster;
import ru.reeson2003.model.characters.creatures.NonPlayerCharacter.MonsterFactoryTestImpl;
import ru.reeson2003.model.characters.creatures.PlayerCharacter.PlayerCharacter;
import ru.reeson2003.model.service.TimeActivator;

import java.util.Date;

/**
 * Created by reeson on 20.12.16.
 */
public class Main4 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class.forName("ru.reeson2003.model.characters.creatures.NonPlayerCharacter.TestMonParMan").newInstance();
        PlayerCharacter player = PlayerCharacter.NewbiePlayerIstance("DanielDefo",20,5,10,10,10);
        HitAbility playerHitAbility = new HitAbility(player);
        Monster antQueen = new MonsterFactoryTestImpl().getMonster(1);
        HitAbility monsterHitAbility = new HitAbility(player);
        while (player.getHealth() > 0 && antQueen.getHealth() >0) {
            TimeActivator.getInstance().tick(new Date());
            playerHitAbility.use(player);
            monsterHitAbility.use(antQueen);
        }
        System.out.println(player.getName() + " HP = " + player.getHealth());
        System.out.println(antQueen.getName() + " HP = " + antQueen.getHealth());
    }
}
