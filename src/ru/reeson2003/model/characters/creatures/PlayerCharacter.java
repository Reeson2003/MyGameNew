package ru.reeson2003.model.characters.creatures;

import ru.reeson2003.model.characters.items.Equip;
import ru.reeson2003.model.characters.items.EquipType;
import ru.reeson2003.model.characters.items.Equipment;

/**
 * Created by reeson on 08.12.16.
 */
public class PlayerCharacter extends Creature {
//    private Account account;  заготовка на будущее
//    private Quests quests;    заготовка на будущее


    public PlayerCharacter(String name, ParametersController parametersController, Experience experience, Equipment equipment) {
        super(name, parametersController, experience, equipment);
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

    public Equip putOn(Equip equip) {
        return this.equipment.putOn(equip);
    }
    public Equip putOff(EquipType equipType) {
        return this.equipment.putOff(equipType);
    }

}
