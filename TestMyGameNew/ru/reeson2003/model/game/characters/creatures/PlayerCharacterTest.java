package ru.reeson2003.model.game.characters.creatures;

import org.junit.Test;
import ru.reeson2003.model.game.characters.creatures.PlayerCharacter.PlayerCharacter;

import static org.junit.Assert.assertEquals;

/**
 * Created by nimtego_loc on 09.12.2016.
 */
public class PlayerCharacterTest {
    @Test
    public void newbiePlayerInstance() throws Exception {
        final String testName = "Test Name";
        PlayerCharacter testNewbiePlayer = PlayerCharacter.NewbiePlayerInstance(testName);
        assertEquals(testNewbiePlayer, testNewbiePlayer);

    }

    @Test
    public void addExperience() throws Exception {

    }

    @Test
    public void subtractExperience() throws Exception {

    }

    @Test
    public void putOn() throws Exception {

    }

    @Test
    public void putOff() throws Exception {

    }
}