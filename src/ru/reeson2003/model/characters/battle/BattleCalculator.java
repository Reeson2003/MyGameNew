package ru.reeson2003.model.characters.battle;

import ru.reeson2003.model.characters.creatures.Creature;

import java.util.Date;
import java.util.Random;

/**
 * Created by reeson on 10.01.17.
 */
public class BattleCalculator {
    public static int phisicalDamage(Creature from, Creature to, int damage,
                                     boolean critical, boolean pDefence,
                                     boolean evasion, boolean dispersion) {
        Random random = new Random(new Date().getTime());
        int dmg = damage;
        if (critical) {
            int checkCrit = random.nextInt(100);
            if (checkCrit >= 0 && checkCrit <= from.getCriticalChance())
                dmg *= BattleCalculatorConstants.CRITICAL_COEFF;
        }
        if (pDefence) {
            int pAtk = from.getPhysicalAttack() < 1 ? 1 : from.getPhysicalAttack();
            double coeff = to.getPhysicalDefence() / pAtk;
            if (coeff > 1)
                dmg /= coeff;
        }
        if (evasion) {
            int checkDodge = random.nextInt(100);
            int evas = from.getEvasion() < 1 ? 1 : from.getEvasion();
            double coeff = 1 - to.getAccuracy() / evas;
            coeff *= BattleCalculatorConstants.MAX_DODGE_CHANCE;
            if (checkDodge <= coeff)
                dmg = 0;
        }
        if (dispersion) {
            dmg = (dmg * (100 - BattleCalculatorConstants.DISPERSION +
                    random.nextInt(BattleCalculatorConstants.DISPERSION * 2))) / 100;
        }
        return dmg;
    }
}
