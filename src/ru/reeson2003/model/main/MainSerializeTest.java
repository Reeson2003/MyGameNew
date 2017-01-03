package ru.reeson2003.model.main;

import ru.reeson2003.model.characters.creatures.NonPlayerCharacter.Creature;
import ru.reeson2003.model.characters.creatures.NonPlayerCharacter.MonsterFactoryTestImpl;
import ru.reeson2003.model.characters.creatures.PlayerCharacter.PlayerCharacter;
import ru.reeson2003.model.service.messages.Msg;

import java.io.*;

/**
 * Created by Тоня on 29.12.2016.
 */
public class MainSerializeTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
//        Class.forName("ru.reeson2003.model.characters.creatures.NonPlayerCharacter.TestMonParMan").newInstance();
        PlayerCharacter player = PlayerCharacter.NewbiePlayerIstance("Reeson",5,5,5,5,5);
        Creature creature = new MonsterFactoryTestImpl().getMonster(1);
//        HitMsgRemote hitMsg = new HitMsgRemote(creature.getAddress(), player.getAddress());
//        EasyHealMsgRemote healMsg = new EasyHealMsgRemote(player.getAddress(), player.getAddress());
//        FileOutputStream fos = new FileOutputStream("out.txt");
//        ObjectOutputStream outputStream = new ObjectOutputStream(fos);
//        outputStream.writeObject(hitMsg);
//        outputStream.writeObject(healMsg);
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
        objectInputStream.close();
    }
}
