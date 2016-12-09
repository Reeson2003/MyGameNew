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
    private ParametersFactory parametersFactory;
    public PlayerCharacter() {

    }

    public static PlayerCharacter NewbiePlayerIstance(String name, int str, int con, int agl, int wit, int itl) {
        PlayerCharacter playerCharacter = new PlayerCharacter();
        playerCharacter.name = name;
        playerCharacter.experience = new Experience(0);
        playerCharacter.parametersFactory =
                ParametersFactory.getPlayerParametersFactory(str, con, agl, wit, itl, playerCharacter.experience);
        playerCharacter.parameters = playerCharacter.parametersFactory.getParameters();
        playerCharacter.equipment = new Equipment();
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

    @Override
    public String toString() {
        return "{" +
                "str=" + (parameters.getStrength()+ equipment.getStrength()) +
                ", con=" + (parameters.getConstitution() + equipment.getConstitution() +
                ", agl=" + (parameters.getAgility() + equipment.getAgility()) +
                ", wit=" + (parameters.getWisdom() + equipment.getWisdom()) +
                ", int=" + (parameters.getIntellect() + equipment.getIntellect()) +
                ", MaxHP=" + (parameters.getMaximumHealth() + equipment.getMaximumHealth()) +
                ", MaxMP=" + (parameters.getMaximumMana() + equipment.getMaximumMana()) +
                ", HPreg=" + (parameters.getHealthRegen() + equipment.getHealthRegen()) +
                ", MPreg=" + (parameters.getManaRegen() + equipment.getManaRegen()) +
                ", Patk=" + (parameters.getPhysicalAttack() + equipment.getPhysicalAttack()) +
                ", Pdef=" + (parameters.getPhysicalDefence() + equipment.getPhysicalDefence()) +
                ", Crit=" + (parameters.getCriticalChance() + equipment.getCriticalChance())) +
                ", Aspd=" + (parameters.getAttackSpeed() + equipment.getAttackSpeed()) +
                ", Evas=" + (parameters.getEvasion() + equipment.getEvasion()) +
                ", Accu=" + (parameters.getAccuracy() + equipment.getAccuracy()) +
                ", Atkr=" + (parameters.getAttackRange() + equipment.getAttackRange()) +
                ", Movs=" + (parameters.getMovingSpeed() + equipment.getMovingSpeed()) +
                '}';
    }
}
