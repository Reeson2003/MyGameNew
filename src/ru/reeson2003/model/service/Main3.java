package ru.reeson2003.model.service;

import ru.reeson2003.model.characters.creatures.Creature;
import ru.reeson2003.model.characters.creatures.NonPlayerCharacter.Monster;
import ru.reeson2003.model.characters.creatures.NonPlayerCharacter.MonsterFactoryTestImpl;
import ru.reeson2003.model.characters.creatures.PlayerCharacter.PlayerCharacter;
import ru.reeson2003.model.service.battle.HitMsg;

/**
 * Created by reeson on 15.12.16.
 */
public class Main3 {
    static class HpAddMsg extends Msg {
        int deltaHp;
        public HpAddMsg(Address from, Address to, int deltaHp) {
            super(from, to);
            this.deltaHp = deltaHp;
        }

        @Override
        public void exec() {
            Abonent abonent = AbonentTable.getAbonent(to);
            Creature creature = (Creature)abonent;
            creature.addHealth(deltaHp);
        }
    }
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class.forName("ru.reeson2003.model.characters.creatures.NonPlayerCharacter.TestMonParMan").newInstance();
        MonsterFactoryTestImpl monsterFactoryTest = new MonsterFactoryTestImpl();
        Monster monster = monsterFactoryTest.getMonster(1);
//        System.out.println(monster);
//        System.out.println(monster.getAddress().getAbonentId());
//        for (int i = 0; i < 1000; i++) {
//            monster = monsterFactoryTest.getMonster(i);
//        }
//        System.out.println(monster.getAddress().getAbonentId());
        PlayerCharacter playerCharacter = PlayerCharacter.NewbiePlayerIstance("Killer",5,5,15,5,5);
//        for (int i = 0; i < 999; i++) {
//            new HpAddMsg(playerCharacter.getAddress(),monster.getAddress(),-1).exec();
//        }
//        System.out.println(monster);
//        Address address = null;
//        for (int i = 0; i < 10000000; i++) {
//            address = new Address();
//        }
//        System.out.println(address.getAbonentId());
        for (int i = 0; i < 50; i++) {
            new HitMsg(playerCharacter.getAddress(), monster.getAddress()).exec();
        }
        for (int i = 0; i < 5; i++) {
            new HitMsg(monster.getAddress(), monster.getTarget().getAddress()).exec();
        }
        System.out.println(monster);
        System.out.println(playerCharacter);
    }

}
