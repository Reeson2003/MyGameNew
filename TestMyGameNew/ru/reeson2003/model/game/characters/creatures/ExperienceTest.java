package ru.reeson2003.model.game.characters.creatures;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by nimtego_loc on 07.12.2016.
 */

public class ExperienceTest {
    @Test
    public void subtractExperience() throws Exception {
        final int validated = 1;
        final int expected = 11;
        Experience experience = new Experience(validated);
        experience.subtractExperience();
        assertEquals(expected, experience.getExperience());
    }

    @Test
    public void addExperience() throws Exception {
        final int validated = 10;
        final int expected = 25;
        Experience experience = new Experience(1);
        experience.addExperience(validated);
        assertEquals(expected, experience.getExperience());
    }

    @Test
    public void getLevel() throws Exception {
        Experience exp = new Experience(0);
        exp.addExperience(18);
        assertEquals(1, exp.getLevel());
    }

    @Test
    public void getExpCoeff() throws Exception {
        Experience exp = new Experience(0);
        assertEquals(15, exp.getExpCoeff());
    }

    @Test
    public void getExperience() throws Exception {
        Experience exp = new Experience(0);
        exp.addExperience(18);
        assertEquals(18, exp.getExperience());
    }

    @Test
    public void getExpToNextLevel() throws Exception {
        Experience exp = new Experience(0);
        exp.addExperience(18);
        assertEquals(34, exp.getExpToNextLevel());
    }

    @Test
    public void getSkillPoints() throws Exception {
        Experience exp = new Experience(0);
        exp.addExperience(18);
        assertEquals(1, exp.getSkillPoints());
    }

    @Test
    public void testAddExperienceNegativeNumber() throws Exception {
        Experience experience = new Experience(0);
        int enteringNumber = -18;
        try {
            experience.addExperience(enteringNumber);
            fail();
        } catch (IllegalArgumentException e) {}
    }
}