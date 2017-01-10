package ru.reeson2003.model.main;

import ru.reeson2003.model.client.ClientPacketMessage;
import ru.reeson2003.model.client.CreatureSurrogate;
import ru.reeson2003.model.client.PlayerCharacterSurrogate;

import java.io.*;
import java.net.Socket;
import java.util.List;

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
            PlayerCharacterSurrogate player = clientPacketMessage.getPlayerSurrogate();
            List<CreatureSurrogate> creatureSurrogates = clientPacketMessage.getCreatures();
            System.out.println(player);
            for (CreatureSurrogate c: creatureSurrogates) {
                System.out.println(c);
            }
            System.out.println("\n\n\n\n\n");
            if (creatureSurrogates.size() == 0)
                break;
//            Msg toServer = new HitMsgRemote(player.getAddress(), creatureSurrogates.get(0).getAddress());
//            try {
//                objectOutputStream.writeObject(toServer);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
    }
}
