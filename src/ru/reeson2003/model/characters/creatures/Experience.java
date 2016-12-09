package ru.reeson2003.model.characters.creatures;

import java.util.List;

/**
 * Created by reeson on 05.12.16.
 */
public class Experience {
	public interface ExperienceListeners {
		public void updateLevelUp();
		public void updateLevelDown();
	}
	private int level;
    private int experience;
    private int expToNextLevel;
    private int expCoeff;
    private int skillPoints;
    private int levelMarkerForSkillPoints;
	
    private List<ExperienceListeners> experienceListeners;

    public Experience(int level) {
        this.level = level;
	    levelMarkerForSkillPoints = this.level;
        experience = 0;
        expCoeff = ParametersConstants.EXP_COEFF;
        expToNextLevel = expCoeff;
        skillPoints = 0;
        calcExpToLevel(level);
		experienceListeners = new ArrayList<ExperienceListeners>();
    }
	public void registerListener(final ExperienceListeners listener) {
        experienceListeners.add(listener);
    }
    public void removeListener(final ExperienceListeners listener) {
		final int indexOfListener = experienceListeners.indexOf(listener);
		if (indexOfListener >= 0) {
			experienceListeners.remove(indexOfListener);
		}
    }
	void notifyListenersAboutLevelUp() {
		for (ExperienceListeners listener : experienceListeners) {
			listener.updateLevelUp();
		}
	}
	void notifyListenersAboutLevelDown() {
		for (ExperienceListeners listener : experienceListeners) {
			listener.updateLevelDown();
		}
	}
    public void subtractExperience() {
        if (experience - expToNextLevel / ParametersConstants.EXP_SUBTRACTION_COEFF > 0) {
	        experience -= ((int)Math.ceil((float)expToNextLevel / ParametersConstants.EXP_SUBTRACTION_COEFF)); // EXP_SUBTRACTION_COEFF = 10 (%) например
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
		expCoeff = (int)Math.ceil((float)expCoeff * 1000 / ParametersConstants.EXP_COEFF_ADDICTION);
		notifyListenersAboutLevelDown();
    }
    public void addExperience(int experience) {
        this.experience += experience;
		levelUp();
    }
    private void calcExpToNextLevel() {
        expCoeff = expCoeff * ParametersConstants.EXP_COEFF_ADDICTION / 1000;
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
	    skillPoints += ParametersConstants.SKILL_POINTS_ADDICTION;
	    if (level % ParametersConstants.EXTRA_SP_EACH_LVL == 0)
	        skillPoints += ParametersConstants.EXTRA_SP_ADDICTION;
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
