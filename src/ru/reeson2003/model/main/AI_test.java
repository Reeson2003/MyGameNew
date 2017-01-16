package ru.reeson2003.model.main;

import ru.reeson2003.model.characters.coordinates.Coordinate;
import ru.reeson2003.model.characters.coordinates.World;
import ru.reeson2003.model.characters.creatures.Creature;
import ru.reeson2003.model.characters.creatures.EquipType;
import ru.reeson2003.model.characters.creatures.NonPlayerCharacter.Monster;
import ru.reeson2003.model.characters.creatures.NonPlayerCharacter.art_intellect.AntQueenAI;
import ru.reeson2003.model.characters.creatures.NonPlayerCharacter.monster_factory.MonsterFactory;
import ru.reeson2003.model.characters.creatures.NonPlayerCharacter.monster_factory.MonsterFactoryTestImpl;
import ru.reeson2003.model.characters.creatures.Parameters;
import ru.reeson2003.model.characters.creatures.PlayerCharacter.PlayerCharacter;
import ru.reeson2003.model.characters.items.Equip;
import ru.reeson2003.model.service.TimeActivator;
import ru.reeson2003.model.service.exception.MyGameException;
import ru.reeson2003.view.SwingView;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by reeson on 12.01.17.
 */
public class AI_test {
    public static void main(String[] args) {
        PlayerCharacter playerCharacter = PlayerCharacter.NewbiePlayerInstance("Piston");
        Equip AK_47 = new Equip(EquipType.Weapon);
        Parameters ak = new Parameters.ParametersBuilder().physicalAttack(3)
                .attackSpeed(500).attackRange(2_0000).build();
        AK_47.setParameters(ak);
        Equip regenerator = new Equip(EquipType.LowerBody);
        Parameters reg = new Parameters.ParametersBuilder().healthRegen(20).manaRegen(20).build();
        regenerator.setParameters(reg);
        playerCharacter.putOn(AK_47);
        playerCharacter.putOn(regenerator);
        playerCharacter.setCoordinate(new Coordinate(100_000, 100_000, 100_000));
        World.getInstance().place(playerCharacter);
        MonsterFactory monsterFactory = new MonsterFactoryTestImpl();
        Random random = new Random();
        World world = World.getInstance();
        while (true) {
            List<Creature> list = world.getVisibleCreatures(playerCharacter);
            list.remove(playerCharacter);
            if (!list.isEmpty()) {
                try {
                    playerCharacter.getAbility("Hit").use(list.get(0));
                } catch (MyGameException e) {
                    e.printStackTrace();
                }
            } else {
                Monster m1 = monsterFactory.getMonster(random.nextInt(3)+1);
                m1.setAi(new AntQueenAI(m1));
                Monster m2 = monsterFactory.getMonster(random.nextInt(3)+1);
                m2.setAi(new AntQueenAI(m2));
                Monster m3 = monsterFactory.getMonster(random.nextInt(3)+1);
                m3.setAi(new AntQueenAI(m3));
            }
            SwingView sw = SwingView.getInstance();
            sw.clear().append(playerCharacter);
            for (Creature c: list)
                sw.append(c);
            sw.show();
            TimeActivator.getInstance().tick(new Date());
        }
    }
}
