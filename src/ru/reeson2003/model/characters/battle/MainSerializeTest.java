package ru.reeson2003.model.characters.battle;

import ru.reeson2003.model.characters.creatures.NonPlayerCharacter.Monster;
import ru.reeson2003.model.characters.creatures.NonPlayerCharacter.MonsterFactoryTestImpl;
import ru.reeson2003.model.characters.creatures.PlayerCharacter.PlayerCharacter;
import ru.reeson2003.model.service.Msg;

import java.io.*;

/**
 * Created by Тоня on 29.12.2016.
 */
public class MainSerializeTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
        Class.forName("ru.reeson2003.model.characters.creatures.NonPlayerCharacter.TestMonParMan").newInstance();
        PlayerCharacter player = PlayerCharacter.NewbiePlayerIstance("Reeson",5,5,5,5,5);
        Monster monster = new MonsterFactoryTestImpl().getMonster(1);
//        HitMsg hitMsg = new HitMsg(monster.getAddress(), player.getAddress());
//        HealMsg healMsg = new HealMsg(player.getAddress(), player.getAddress());
//        FileOutputStream fos = new FileOutputStream("C:/out.txt");
//        ObjectOutputStream outputStream = new ObjectOutputStream(fos);
//        outputStream.writeObject(hitMsg);
//        outputStream.writeObject(healMsg);
//        fos.close();
        FileInputStream fis = new FileInputStream("C:/out.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fis);
        Msg msg = (Msg)objectInputStream.readObject();
        msg.exec();
        System.out.println(player);
        msg = (Msg)objectInputStream.readObject();
        msg.exec();
        System.out.println(player);
        objectInputStream.close();
    }
}
