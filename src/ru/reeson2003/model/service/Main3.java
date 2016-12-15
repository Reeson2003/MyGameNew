package ru.reeson2003.model.service;

import ru.reeson2003.model.characters.creatures.Creature;
import ru.reeson2003.model.characters.creatures.NonPlayerCharacter.Monster;
import ru.reeson2003.model.characters.creatures.NonPlayerCharacter.MonsterFactoryTestImpl;
import ru.reeson2003.model.characters.creatures.PlayerCharacter.PlayerCharacter;

/**
 * Created by reeson on 15.12.16.
 */
public class Main3 {
    static class HpAddMsg extends Msg {
        int hp;
        public HpAddMsg(Address from, Address to, int hp) {
            super(from, to);
            this.hp = hp;
        }

        @Override
        public void exec(Address.Abonent abonent) {
            Creature creature = (Creature)abonent;
            creature.addHealth(hp);
        }
    }
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class.forName("ru.reeson2003.model.characters.creatures.NonPlayerCharacter.TestMonParMan").newInstance();
        MonsterFactoryTestImpl monsterFactoryTest = new MonsterFactoryTestImpl();
        Monster monster = monsterFactoryTest.getMonster(1);
        System.out.println(monster);
        System.out.println(monster.getAddress().getAbonentId());
        for (int i = 0; i < 1000; i++) {
            monster = monsterFactoryTest.getMonster(i);
        }
        System.out.println(monster.getAddress().getAbonentId());
        PlayerCharacter playerCharacter = PlayerCharacter.NewbiePlayerIstance("Killer",5,5,5,5,5);
        for (int i = 0; i < 999; i++) {
            new HpAddMsg(playerCharacter.getAddress(),monster.getAddress(),-1).exec(monster);
        }
        System.out.println(monster);
    }

}
