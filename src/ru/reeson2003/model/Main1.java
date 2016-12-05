package ru.reeson2003.model;

import ru.reeson2003.model.characters.creatures.Experience;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Created by reeson on 04.12.16.
 */
public class Main1 {
    public static void main(String[] args) {
        Experience e = new Experience(0);
        e.addExperience(1000+245-217);
        System.out.println(e);
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
