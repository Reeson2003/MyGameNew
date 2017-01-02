package ru.reeson2003.model.characters.creatures.PlayerCharacter;

import ru.reeson2003.model.characters.creatures.Creature;
import ru.reeson2003.model.characters.creatures.Experience;
import ru.reeson2003.model.characters.creatures.ParametersController;
import ru.reeson2003.model.characters.items.Equip;
import ru.reeson2003.model.characters.items.EquipType;
import ru.reeson2003.model.characters.items.Equipment;

/**
 * Created by reeson on 08.12.16.
 */
public class PlayerCharacter extends Creature {
//    private Account account;  заготовка на будущее
//    private Quests quests;    заготовка на будущее
    private Experience experience;
    private Equipment equipment;


    public PlayerCharacter(String name, ParametersController parametersController, Experience experience, Equipment equipment) {
        super(name, parametersController);
        this.equipment = equipment;
        this.experience = experience;
    }

    public static PlayerCharacter NewbiePlayerIstance(String name, int str, int con, int agl, int wit, int itl) {
        Experience experience = new Experience(0);
        Equipment equipment = new Equipment();
        ParametersController parametersController =
                ParametersController.getPlayerParametersController(str, con, agl, wit, itl, experience, equipment);
        PlayerCharacter playerCharacter = new PlayerCharacter(name, parametersController, experience, equipment);
        return playerCharacter;
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
        return this.equipment.putOn(equip);
    }

    public Equip putOff(EquipType equipType) {
        return this.equipment.putOff(equipType);
    }

    @Override
    public String toString() {
        return super.toString() + "\n|" +
                experience +
                "\n --------------------------------------------------------------";
    }
}
