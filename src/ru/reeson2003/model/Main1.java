package ru.reeson2003.model;

import ru.reeson2003.model.characters.creatures.Experience;
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
//        System.out.println(p);
//        p.addExperience(1000);
//        System.out.println(p);
//        for (int i = 0; i < 5; i++) {
//            p.subtractExperience();
//        }
//        System.out.println(p);
        System.out.println(p);
        System.out.println("PutOn");
        Equip shirt = new Equip(EquipType.UpperBody);
        shirt.setParameters(new Parameters.ParametersBuilder().physicalDefence(15).build());
        Equip pants = new Equip(EquipType.LowerBody);
        pants.setParameters(new Parameters.ParametersBuilder().movingSpeed(100).
                maximumMana(100).criticalChance(100).build());
        p.putOn(pants);
        p.putOn(shirt);
        System.out.println(p);
        Equip e = p.putOff(EquipType.LowerBody);
        p.putOff(EquipType.Boots);
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
