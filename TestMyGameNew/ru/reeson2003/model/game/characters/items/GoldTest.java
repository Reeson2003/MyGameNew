package ru.reeson2003.model.game.characters.items;

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
        Gold gold1 = new Gold(100);
        Gold gold2 = new Gold(100);
        Gold gold3 = new Gold(100);
        gold3.mergeGold(gold1, gold2, new Gold(100));
        assertEquals(400, gold3.getNumberOfGold());
    }

    @Test
    public void getNumberOfGold() throws Exception {
        final long testGold = 100;
        Gold gold = new Gold(testGold);
        assertEquals(testGold, gold.getNumberOfGold());
    }

    @Test
    public void setNumberOfGold() throws Exception {
        final long testGold = 100;
        Gold gold = new Gold(testGold);
        assertEquals(testGold, gold.getNumberOfGold());
    }

}