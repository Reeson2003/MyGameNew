package ru.reeson2003.model;

import ru.reeson2003.model.characters.creatures.Parameters;
import ru.reeson2003.model.characters.creatures.PlayerCharacter;
import ru.reeson2003.model.characters.items.Equip;
import ru.reeson2003.model.characters.items.EquipType;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Created by reeson on 04.12.16.
 */
public class Main1 {
    public static void main(String[] args) {
        PlayerCharacter p = PlayerCharacter.NewbiePlayerIstance("",10,15,45,0,4);
        System.out.println(p);
        Equip shirt = new Equip(EquipType.UpperBody);
        shirt.setParameters(new Parameters.ParametersBuilder().physicalDefence(15).constitution(-10).build());
        p.putOn(shirt);
        System.out.println(p);
        p.addExperience(16);
        System.out.println(p);
        p.addHealth(100);
        System.out.println(p);
    }
    public static char getKey() {
        Reader rd = new InputStreamReader(System.in);
        char ch[] = new char[1];
        try {
            rd.read(ch);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ch[0];
    }
}
