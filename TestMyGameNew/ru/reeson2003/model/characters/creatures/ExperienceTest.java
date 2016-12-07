package ru.reeson2003.model.characters.creatures;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by nimtego_loc on 07.12.2016.
 */

// TODO: 07.12.2016 Test не коректный изменилась логика методов
public class ExperienceTest {
    @Test
    public void testAddExperiencePositiveAndNegativeNumber() throws Exception {
        Experience experience = new Experience(0);
        int enteringNumber = -18;
        final int  testNumber = 3;
        int countTest = 0;
        for (int i = 0; i < 2; i++) {
            try {
                experience.addExperience(enteringNumber);
                assertEquals(testNumber, experience.getExperience());
                countTest += 2;
            } catch (IllegalArgumentException e) {
                countTest += countTest == 0 ? 1 : 0;
                enteringNumber += 36;
            }
        }
        assertEquals(testNumber, countTest);
    }

    @Test
    public void getLevel() throws Exception {
        Experience exp = new Experience(0);
        exp.addExperience(18);
        assertEquals(1, exp.getLevel());
    }

    @Test
    public void getExperience() throws Exception {
        Experience exp = new Experience(0);
        exp.addExperience(18);
        assertEquals(3, exp.getExperience());
    }

    @Test
    public void getExpToNextLevel() throws Exception {
        Experience exp = new Experience(0);
        exp.addExperience(18);
        assertEquals(19, exp.getExpToNextLevel());
    }

    @Test
    public void getSkillPoints() throws Exception {
        Experience exp = new Experience(0);
        exp.addExperience(18);
        assertEquals(1, exp.getSkillPoints());
    }

}