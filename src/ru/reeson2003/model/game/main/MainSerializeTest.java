package ru.reeson2003.model.game.main;

import ru.reeson2003.model.game.characters.battle.abilities.HitAbility;
import ru.reeson2003.model.game.characters.battle.abilities.LightHealAbility;
import ru.reeson2003.model.game.characters.coordinates.World;
import ru.reeson2003.model.game.characters.creatures.NonPlayerCharacter.Monster;
import ru.reeson2003.model.game.characters.creatures.NonPlayerCharacter.monster_factory.MonsterFactoryTestImpl;
import ru.reeson2003.model.game.characters.creatures.PlayerCharacter.PlayerCharacter;
import ru.reeson2003.model.game.service.TimeActivator;
import ru.reeson2003.model.game.service.messages.Msg;
import ru.reeson2003.model.game.view.SwingView;

import java.io.*;
import java.util.Date;

/**
 * Created by Тоня on 29.12.2016.
 */
public class MainSerializeTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
//        Class.forName("ru.reeson2003.model.game.characters.creatures.NonPlayerCharacter.monster_factory.TestMonParMan").newInstance();
        PlayerCharacter player = PlayerCharacter.NewbiePlayerInstance("Reeson");
        player.addAbility(new LightHealAbility(player));
        player.setHealth(1000);
        player.setMana(1000);
        World.getInstance().place(player);
        Monster creature = new MonsterFactoryTestImpl().getMonster(1);
        creature.addAbility(new HitAbility(creature));
        TimeActivator.getInstance().addTimeDependent(creature);
        TimeActivator.getInstance().addTimeDependent(player);

//        HitMsg hitMsg = new HitMsg(creature.getAddress(), player.getAddress());
//        LightHealMsg healMsg = new LightHealMsg(player.getAddress(), player.getAddress());
//        MoveMsg moveMsg = new MoveMsg(player.getAddress(),player.getAddress(),new Coordinate(10000,10000,10000));
//        FileOutputStream fos = new FileOutputStream("out.txt");
//        ObjectOutputStream outputStream = new ObjectOutputStream(fos);
//        outputStream.writeObject(hitMsg);
//        outputStream.writeObject(healMsg);
//        outputStream.writeObject(moveMsg);
//        fos.close();

        FileInputStream fis = new FileInputStream("out.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fis);
        System.out.println(player);
        Msg msg = (Msg)objectInputStream.readObject();
        msg.exec();
        System.out.println(player);
        msg = (Msg)objectInputStream.readObject();
        msg.exec();
        System.out.println(player);
        msg = (Msg)objectInputStream.readObject();
        msg.exec();
        objectInputStream.close();

        while (true) {
            SwingView.getInstance().clear().append(player).show();
            TimeActivator.getInstance().tick(new Date());
        }
    }
}
