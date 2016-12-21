package ru.reeson2003.model.characters.battle;

import ru.reeson2003.model.characters.creatures.Creature;

import java.util.Date;
import java.util.Random;

/**
 * Created by Тоня on 09.10.2016.
 */
public class Fight {
    private static int dispersion = 40;
    Creature opponent1;
    Creature opponent2;
    Random random;

    public Fight(Creature opponent1, Creature opponent2) {
        this.opponent1 = opponent1;
        this.opponent2 = opponent2;
        random = new Random();
    }

    public void fight() {
        Date date = new Date();
        long op1hit = date.getTime();
        long op2hit = date.getTime();
        long healthRegen = date.getTime();
        //System.out.println(opponent1.name + " and " + opponent2.name + " fight!");
        while (opponent1.getHealth() >0 && opponent2.getHealth() >0) {
            date = new Date();
            if (date.getTime() - healthRegen > 2000) {
                opponent1.addHealth(opponent1.getHealthRegen());
                opponent2.addHealth(opponent2.getHealthRegen());
                healthRegen = date.getTime();
            }
            if (date.getTime() - op1hit > 300+10000/opponent1.getAttackSpeed()) {
                hit(opponent1, opponent2);
                op1hit = date.getTime();
                System.out.println(opponent2.getName() + " " + opponent2.getHealth());
            }
            if (date.getTime() - op2hit > 300+10000/opponent2.getAttackSpeed()) {
                hit(opponent2, opponent1);
                op2hit = date.getTime();
                System.out.println(opponent1.getName() + " " + opponent1.getHealth());
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(opponent1.getHealth()>0)
            System.out.println(opponent1.getName() + " won " + opponent2.getName());
        else if(opponent2.getHealth() >0)
            System.out.println(opponent2.getName() + " won " + opponent1.getName());
        else
            System.out.println(opponent1.getName() + " draw " + opponent2.getName());
        //System.out.println(opponent1.getHealth());
        //System.out.println(opponent2.getHealth());
    }

    private void hit(Creature giveDamage, Creature getDamage) {
        int damage = giveDamage.getPhysicalAttack() - getDamage.getPhysicalDefence()/10;
        if (damage < 2)
            damage = 2;
        int check = random.nextInt(100);
        if (check >=0 && check < giveDamage.getCriticalChance())
            damage *= 2;
        check = random.nextInt(100);
        if (check >=0 && check < getDamage.getEvasion() - giveDamage.getAccuracy()/10)
            damage = 0;
        damage = damage*(100 - dispersion/2 + random.nextInt(dispersion))/100;
        getDamage.addHealth(-damage);
        System.out.println(giveDamage.getName() + " hits " +damage);
    }
}
