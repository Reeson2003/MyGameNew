package ru.reeson2003.model.main;

import ru.reeson2003.model.service.client_content.ClientPacketMessage;
import ru.reeson2003.model.service.client_content.MonsterAgent;
import ru.reeson2003.model.service.client_content.PlayerCharacterAgent;
import ru.reeson2003.model.service.messages.Msg;
import ru.reeson2003.model.service.messages.remote_messages.HitMsgRemote;

import java.io.*;
import java.net.Socket;

/**
 * Created by reeson on 02.01.17.
 */
public class ClientTest {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("localhost", 4242);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("can not open client socket");
        }
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            outputStream = socket.getOutputStream();
            inputStream = socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("can not get client i/o stream");
        }
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            objectInputStream = new ObjectInputStream(inputStream);
            objectOutputStream = new ObjectOutputStream(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ClientPacketMessage clientPacketMessage = null;
        while (true) {
            try {
                Object message = objectInputStream.readObject();
                clientPacketMessage = (ClientPacketMessage) message;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            PlayerCharacterAgent player = clientPacketMessage.getPlayerCharacter();
            MonsterAgent[] monsters = clientPacketMessage.getMonsters();
            System.out.println(player);
            for (int i = 0; i < monsters.length; i++) {
                System.out.println(monsters[i]);
            }
            System.out.println("\n\n\n\n\n");
            Msg toServer = new HitMsgRemote(player.getAddress(), monsters[0].getAddress());
            try {
                objectOutputStream.writeObject(toServer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
