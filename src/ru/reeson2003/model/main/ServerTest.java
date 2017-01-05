package ru.reeson2003.model.main;

import ru.reeson2003.model.characters.creatures.Creature;
import ru.reeson2003.model.characters.creatures.NonPlayerCharacter.MonsterFactory;
import ru.reeson2003.model.characters.creatures.NonPlayerCharacter.MonsterFactoryTestImpl;
import ru.reeson2003.model.characters.creatures.PlayerCharacter.PlayerCharacter;
import ru.reeson2003.model.service.AbonentTable;
import ru.reeson2003.model.service.TimeActivator;
import ru.reeson2003.model.client_content.ClientPacketMessage;
import ru.reeson2003.model.service.messages.Msg;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by reeson on 02.01.17.
 */
public class ServerTest {
    public static void main(String[] args) {
        PlayerCharacter player = PlayerCharacter.NewbiePlayerIstance("Reeson");
        TimeActivator timeActivator = TimeActivator.getInstance();
        MonsterFactory mf = new MonsterFactoryTestImpl();
        Creature aq = mf.getMonster(1);
        Creature sk = mf.getMonster(2);
//==============================================================================
        Socket socket = null;
        try {
            socket = new ServerSocket(4242).accept();
            System.out.println("get socket");
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStream is = null;
        OutputStream os = null;
        try {
            is = socket.getInputStream();
            os = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            objectOutputStream= new ObjectOutputStream(os);
            objectInputStream = new ObjectInputStream(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
//========================================================================================

        while (true) {
            timeActivator.tick(new Date());
            ArrayList<Creature> creatureArrayList = new ArrayList<>();
            if (aq.getHealth() > 0)
                creatureArrayList.add(aq);
            if (sk.getHealth() > 0)
                creatureArrayList.add(sk);
            ClientPacketMessage cpm = new ClientPacketMessage(player, creatureArrayList);
            try {
                objectOutputStream.writeObject(cpm);
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(10);
            }
            Msg msg = null;
            try {
                msg = (Msg)objectInputStream.readObject();
                msg.exec();
                ru.reeson2003.model.characters.creatures.Creature creature = (ru.reeson2003.model.characters.creatures.Creature) AbonentTable.getAbonent(msg.getTo());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }
}
