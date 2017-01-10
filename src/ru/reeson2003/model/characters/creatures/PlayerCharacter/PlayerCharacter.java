package ru.reeson2003.model.characters.creatures.PlayerCharacter;

import ru.reeson2003.model.characters.creatures.*;
import ru.reeson2003.model.characters.items.Equip;

/**
 * Created by reeson on 08.12.16.
 */
public class PlayerCharacter extends Creature {
    private Experience experience;

    public PlayerCharacter(String name, ParametersController parametersController, Experience experience) {
        super(name, parametersController);
        this.experience = experience;
    }

    public static PlayerCharacter NewbiePlayerInstance(String name) {
        Experience experience = new Experience(0);
        Parameters parameters = new Parameters.ParametersBuilder().
                maximumHealth(ParametersConstants.HEALTH_BASE).
                maximumMana(ParametersConstants.MANA_BASE).
                healthRegen(ParametersConstants.HEALTH_REGEN_BASE).
                manaRegen(ParametersConstants.MANA_REGEN_BASE).
                physicalAttack(ParametersConstants.PATACK_BASE).
                physicalDefence(ParametersConstants.PDEF_BASE).
                magicAttack(ParametersConstants.MATACK_BASE).
                magicDefence(ParametersConstants.MDEF_BASE).
                criticalChance(ParametersConstants.CRITCHANCE_BASE).
                attackSpeed(ParametersConstants.ATKSPEED_BASE).
                evasion(ParametersConstants.EVASION_BASE).
                accuracy(ParametersConstants.ACCURACY_BASE).
                attackRange(ParametersConstants.ATTACK_RANGE_BASE).
                movingSpeed(ParametersConstants.MOVING_SPEED_BASE).
                build();
        ParametersController parametersController = new PlayerParametersController(experience);
        parametersController.setParameters(parameters);
        PlayerCharacter playerCharacter = new PlayerCharacter(name, parametersController, experience);
        return playerCharacter;
    }

    @Override
    public void makeDamage(Creature creature, int damage) {
        if (target == null)
            target = creature;
        changeHealth(-damage);
    }

    public void addExperience(int experience) {
        this.experience.addExperience(experience);
    }

    public void subtractExperience() {
        this.experience.subtractExperience();
    }

    public int getExperience() {
        return experience.getExperience();
    }

    public int getLevel() {
        return experience.getLevel();
    }

    public int getSkillPoints() {
        return experience.getSkillPoints();
    }

    public int getExpToNextLevel() {
        return experience.getExpToNextLevel();
    }

    public Equip putOn(Equip equip) {
        return this.parametersController.putOn(equip);
    }

    public Equip putOff(EquipType equipType) {
        return this.parametersController.putOff(equipType);
    }

    @Override
    public String toString() {
        return super.toString() + "\n|" +
                experience +
                "\n --------------------------------------------------------------";
    }
}
