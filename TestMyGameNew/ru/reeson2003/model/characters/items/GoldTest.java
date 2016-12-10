package ru.reeson2003.model.characters.items;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by nimtego_loc on 10.12.2016.
 */
public class GoldTest {
    @Test
    public void removePartOfGold() throws Exception {
        int enteringGold = 100;
        Gold goldTest = new Gold(enteringGold);
        int removeNumber = 50;
        int equalsNumber = enteringGold - removeNumber;
        goldTest.removePartOfGold(removeNumber);
        assertEquals(goldTest.getNumberOfGold(), equalsNumber);
    }

    @Test
    public void removePartOfGoldNegativeArgument() throws Exception {
        int enteringGoldNegative = -100;
        Gold goldTest = new Gold(0);
        try {
            goldTest.addGold(enteringGoldNegative);
            fail();
        } catch (IllegalArgumentException e) {}
    }
    @Test
    public void removePartOfGoldNegative() throws Exception {
        int enteringGold = 100;
        Gold goldTest = new Gold(0);
        try {
            goldTest.addGold(enteringGold);
            fail();
        } catch (IllegalArgumentException e) {}
    }
    @Test
    public void addGold() throws Exception {
        int enteringGold = -100;
        Gold goldTest = new Gold(0);
        try {
            goldTest.addGold(enteringGold);
            fail();
        } catch (IllegalArgumentException e) {}
    }

    @Test
    public void mergeGold() throws Exception {

    }

    @Test
    public void getNumberOfGold() throws Exception {

    }

    @Test
    public void setNumberOfGold() throws Exception {

    }

}