package ru.reeson2003.model.characters.creatures;

/**
 * Created by reeson on 05.12.16.
 */
class Experience {
    private int level;
    private int experience;
    private int expToNextLevel;
    private int expCoeff;
    private int skillPoints;
    private int levelMarkerForSkillPoints;

    public Experience(int level) {
        this.level = level;
	levelMarkerForSkillPoints = this.level;
        experience = 0;
        expCoeff = ParametersConstants.EXP_COEFF;
        expToNextLevel = expCoeff;
        skillPoints = 0;
        calcExpToLevel(level);
    }
    public void subtractExperience() {
        if (experience - expToNextLevel / ParametersConstants.EXP_SUBTRACTION_COEFF > 0) {
	    experience -= expToNextLevel / ParametersConstants.EXP_SUBTRACTION_COEFF ; // EXP_SUBTRACTION_COEFF = 10 (%) например
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
	    levelUp();
	}
    }
    private void addSkillPoints() {
	skillPoints += ParametersConstants.SKILL_POINTS_ADDICTION;
	if (level % ParametersConstants.EXTRA_SP_EACH_LVL == 0)
	    skillPoints += ParametersConstants.EXTRA_SP_ADDICTION;
    }
//    todo : продумать выдачу скилпоинтов - ?

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
