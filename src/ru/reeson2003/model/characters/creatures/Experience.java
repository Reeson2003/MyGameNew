package ru.reeson2003.model.characters.creatures;

/**
 * Created by reeson on 05.12.16.
 */
public class Experience {
    private int level;
    private int experience;
    private int expToNextLevel;
    private int expCoeff;
    private int skillPoints;

    public Experience(int level) { // test push 2
        this.level = level;
        experience = 0;
        expCoeff = ParametersConstants.EXP_COEFF;
        expToNextLevel = expCoeff;
        skillPoints = 0;
        calcExpToLevel(level);
    }
    public void addExperience(int experience) {
        if (this.experience + experience < expToNextLevel) {
            this.experience += experience;
        } else {
            experience -= (expToNextLevel - this.experience);
            this.experience = 0;
          //this.experience = expToNextLevel; //если необходимо будет всё-таки не обнулять текущую exp
            levelUp();
            skillPoints += ParametersConstants.SKILL_POINTS_ADDICTION;
            if (level % ParametersConstants.EXTRA_SP_EACH_LVL == 0)
                skillPoints += ParametersConstants.EXTRA_SP_ADDICTION;
            calcExpToNextLevel();
            addExperience(experience);
        }
    }

    private void calcExpToNextLevel() {
        expCoeff = expCoeff * ParametersConstants.EXP_COEFF_ADDICTION / 1000;
        expToNextLevel = expCoeff;
    }
    private void calcExpToLevel(int level) {
        if (level >0)
            calcExpToNextLevel();
        if (level-1 > 0)
            calcExpToLevel(level-1);
    }

    private void levelUp() {
        level++;
    }

    public int getLevel() {
        return level;
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
