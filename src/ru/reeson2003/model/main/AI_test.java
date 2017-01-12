package ru.reeson2003.model.main;

import ru.reeson2003.model.characters.coordinates.Coordinate;
import ru.reeson2003.model.characters.creatures.EquipType;
import ru.reeson2003.model.characters.creatures.NonPlayerCharacter.Monster;
import ru.reeson2003.model.characters.creatures.NonPlayerCharacter.monster_factory.MonsterFactory;
import ru.reeson2003.model.characters.creatures.NonPlayerCharacter.monster_factory.MonsterFactoryTestImpl;
import ru.reeson2003.model.characters.creatures.Parameters;
import ru.reeson2003.model.characters.creatures.PlayerCharacter.PlayerCharacter;
import ru.reeson2003.model.characters.items.Equip;
import ru.reeson2003.model.service.TimeActivator;
import ru.reeson2003.model.service.exception.MyGameException;
import ru.reeson2003.view.SwingView;

import java.util.Date;

/**
 * Created by reeson on 12.01.17.
 */
public class AI_test {
    public static void main(String[] args) {
        PlayerCharacter playerCharacter = PlayerCharacter.NewbiePlayerInstance("Piston");
        Equip AK_47 = new Equip(EquipType.Weapon);
        Parameters ak = new Parameters.ParametersBuilder().physicalAttack(3)
                .attackSpeed(333).attackRange(2_0000).build();
        AK_47.setParameters(ak);
        Equip regenerator = new Equip(EquipType.LowerBody);
        Parameters reg = new Parameters.ParametersBuilder().healthRegen(20).manaRegen(20).build();
        regenerator.setParameters(reg);
        playerCharacter.putOn(AK_47);
        playerCharacter.putOn(regenerator);
        playerCharacter.setCoordinate(new Coordinate(100_000, 100_000, 100_000));

        MonsterFactory monsterFactory = new MonsterFactoryTestImpl();
        Monster m1 = monsterFactory.getMonster(1);
        Monster m2 = monsterFactory.getMonster(1);
        Monster m3 = monsterFactory.getMonster(1);
        while (true) {
            try {
                playerCharacter.getAbility("Hit").use(m1);
            } catch (MyGameException e) {
                e.printStackTrace();
            }
            SwingView.getInstance().clear().append(playerCharacter).append(m1)
                    .append(m2).append(m3).show();
            TimeActivator.getInstance().tick(new Date());
        }
    }
}
