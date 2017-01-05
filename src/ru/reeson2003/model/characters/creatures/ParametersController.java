package ru.reeson2003.model.characters.creatures;


import ru.reeson2003.model.characters.items.Equip;
import ru.reeson2003.model.service.TimeDependent;

import java.util.Date;

/**
 * Абстрактный класс ParametersController.
 * Геттеры имеют проверку на отрицательные значения параметров.
 */
public abstract class ParametersController implements Equipment.EquipmentListener, TimeDependent, Cloneable {
    protected Parameters parameters;
    protected int health;
    protected int mana;
    protected Equipment equipment;
    private Date healthTick;
    private Date manaTick;

    protected ParametersController() {
        this.parameters = new Parameters.ParametersBuilder().build();
        this.equipment = new Equipment();
        equipment.addListener(this);
        Date date = new Date();
        this.healthTick = date;
        this.manaTick = date;
    }

    public int getMaximumHealth() {
        int result = parameters.getMaximumHealth() + equipment.getParameters().getMaximumHealth();
        return result < 0 ? 0 : result;
    }

    public int getMaximumMana() {
        int result = parameters.getMaximumMana() + equipment.getParameters().getMaximumMana();
        return result < 0 ? 0 : result;
    }

    public int getHealthRegen() {
        int result = parameters.getHealthRegen() + equipment.getParameters().getHealthRegen();
        return result < 0 ? 0 : result;
    }

    public int getManaRegen() {
        int result = parameters.getManaRegen() + equipment.getParameters().getManaRegen();
        return result < 0 ? 0 : result;
    }

    public int getPhysicalAttack() {
        int result = parameters.getPhysicalAttack() + equipment.getParameters().getPhysicalAttack();
        return result < 0 ? 0 : result;
    }

    public int getPhysicalDefence() {
        int result = parameters.getPhysicalDefence() + equipment.getParameters().getPhysicalDefence();
        return result < 0 ? 0 : result;
    }

    public int getMagicAttack() {
        int result = parameters.getMagicAttack() + equipment.getParameters().getMagicAttack();
        return result < 0 ? 0 : result;    }

    public int getMagicDefence() {
        int result = parameters.getMagicDefence() + equipment.getParameters().getMagicDefence();
        return result < 0 ? 0 : result;
    }

    public int getCriticalChance() {
        int result = parameters.getCriticalChance() + equipment.getParameters().getCriticalChance();
        return result < 0 ? 0 : result;
    }

    public int getAttackSpeed() {
        int result = parameters.getAttackSpeed() + equipment.getParameters().getAttackSpeed();
        return result < 0 ? 0 : result;
    }

    public int getEvasion() {
        int result = parameters.getEvasion() + equipment.getParameters().getEvasion();
        return result < 0 ? 0 : result;
    }

    public int getAccuracy() {
        int result = parameters.getAccuracy() + equipment.getParameters().getAccuracy();
        return result < 0 ? 0 : result;
    }

    public int getAttackRange() {
        int result = parameters.getAttackRange() + equipment.getParameters().getAttackRange();
        return result < 0 ? 0 : result;
    }

    public int getMovingSpeed() {
        int result = parameters.getMovingSpeed() + equipment.getParameters().getAttackSpeed();
        return result < 0 ? 0 : result;
    }

    public int getHealth() {
        return health;
    }

    public int getMana() {
        return mana;
    }

    public void changeHealth(int deltaHealth) {
        this.health += deltaHealth;
        if (this.health > this.getMaximumHealth())
            this.health = this.getMaximumHealth();
        if (this.health < 0)
            this.health = 0;
    }

    public void changeMana(int deltaMana) {
        this.mana += deltaMana;
        if (this.mana >= this.getMaximumMana())
            this.mana = this.getMaximumMana();
        if (this.mana < 0)
            this.mana = 0;
    }

    public void setHealth(int health) {
        if (health < 0)
            this.health = 0;
        else if (health > getMaximumHealth())
            this.health = getMaximumHealth();
        else
            this.health = health;
    }

    public void setMana(int mana) {
        if (mana < 0)
            this.mana = 0;
        else if (mana > getMaximumMana())
            this.mana = getMaximumMana();
        else
            this.mana = mana;
    }

    public Equip putOn(Equip equip) {
        return this.equipment.putOn(equip);
    }

    public Equip putOff(EquipType equipType) {
        return this.equipment.putOff(equipType);
    }

    @Override
    public void putOnEvent() {

    }

    @Override
    public void putOffEvent() {

    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    public Parameters getParameters() {
        return parameters;
    }

    @Override
    public abstract ParametersController clone();

    @Override
    public void tick(Date date) {
        healthTick(date);
        manaTick(date);
    }

    private void healthTick(Date date) {
        if (healthTick.getTime() + ParametersConstants.HEALTH_REGEN_MILLISECONDS < date.getTime()) {
            healthTick = date;
            changeHealth(+getHealthRegen());
        }
    }

    private void manaTick(Date date) {
        if (manaTick.getTime() + ParametersConstants.MANA_REGEN_MILLISECONDS < date.getTime()) {
            manaTick = date;
            changeMana(+getManaRegen());
        }
    }
}
