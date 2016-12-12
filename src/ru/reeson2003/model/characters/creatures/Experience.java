package ru.reeson2003.model.characters.creatures;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by reeson on 05.12.16.
 */
public class Experience {
	public interface ExperienceListener {
		void levelUpEvent();
		void levelDownEvent();
	}
	private int level;
    private int experience;
    private int expToNextLevel;
    private int expCoeff;
    private int skillPoints;
    private int levelMarkerForSkillPoints;
	
    private List<ExperienceListener> experienceListeners;
	
	public Experience() {
		this(0);
	}
    public Experience(int level) {
        this.level = level;
	    levelMarkerForSkillPoints = this.level;
        experience = 0;
        expCoeff = ExperienceConstants.EXP_COEFF;
        expToNextLevel = expCoeff;
        skillPoints = 0;
        calcExpToLevel(level);
		experienceListeners = new ArrayList<ExperienceListener>();
    }
	public void addListener(final ExperienceListener listener) {
        experienceListeners.add(listener);
    }
    public void removeListener(final ExperienceListener listener) {
		final int indexOfListener = experienceListeners.indexOf(listener);
		if (indexOfListener >= 0) {
			experienceListeners.remove(indexOfListener);
		}
    }
	private void notifyListenersAboutLevelUp() {
		for (ExperienceListener listener : experienceListeners) {
			listener.levelUpEvent();
		}
	}
	private void notifyListenersAboutLevelDown() {
		for (ExperienceListener listener : experienceListeners) {
			listener.levelDownEvent();
		}
	}

//	todo : неплохо было бы заложить такой же метод с интом, чтобы другой класс мог определять сколько опыта потерял плеер
    public void subtractExperience() {
        if (experience - expToNextLevel / ExperienceConstants.EXP_SUBTRACTION_COEFF > 0) {
	        experience -= ((int)Math.ceil((float)expToNextLevel / ExperienceConstants.EXP_SUBTRACTION_COEFF)); // EXP_SUBTRACTION_COEFF = 10 (%) например
	        if (experience < expToNextLevel - expCoeff) {	
	            calcExpToPreviousLevel();
            }
		}
		else
			experience = 0;
    }
    private void calcExpToPreviousLevel() {
        level--;
		expToNextLevel -= expCoeff;
		expCoeff = (int)Math.ceil((float)expCoeff * 1000 / ExperienceConstants.EXP_COEFF_ADDICTION);
		notifyListenersAboutLevelDown();
    }
    public void addExperience(int experience) throws IllegalArgumentException{
        if (experience < 0)
            throw new IllegalArgumentException();
        this.experience += experience;
		levelUp();
    }
    private void calcExpToNextLevel() {
        expCoeff = expCoeff * ExperienceConstants.EXP_COEFF_ADDICTION / 1000;
        expToNextLevel += expCoeff;
    }
    private void calcExpToLevel(int level) {
        if (level > 0) {
            if (level - 1 >= 0) {
        	    experience = expToNextLevel;
            }
	    	addSkillPoints();
            calcExpToNextLevel();
            calcExpToLevel(level - 1);
		}
    }

    private void levelUp() {
	    if (this.experience > expToNextLevel) {
	        level++;
	        if (levelMarkerForSkillPoints < level) {
            	addSkillPoints();
		    	levelMarkerForSkillPoints = level;
	        }
	        calcExpToNextLevel();
			notifyListenersAboutLevelUp();
	        levelUp();
	    }
    }
    private void addSkillPoints() {
	    skillPoints += ExperienceConstants.SKILL_POINTS_ADDICTION;
	    if (level % ExperienceConstants.EXTRA_SP_EACH_LVL == 0)
	        skillPoints += ExperienceConstants.EXTRA_SP_ADDICTION;
    }
    public int getLevel() {
        return level;
    }
    public int getExpCoeff() {
        return expCoeff;
    }
    public int getExperience() {
        return experience;
    }
    public int getExpToNextLevel() {
        return expToNextLevel;
    }
    public int getSkillPoints() {
        return skillPoints;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "level=" + level +
                ", experience=" + experience +
                ", expToNextLevel=" + expToNextLevel +
                ", skillPoints=" + skillPoints +
                '}';
    }
	
}
