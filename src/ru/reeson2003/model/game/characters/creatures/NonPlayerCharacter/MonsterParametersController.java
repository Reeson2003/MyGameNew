package ru.reeson2003.model.game.characters.creatures.NonPlayerCharacter;

import ru.reeson2003.model.game.characters.creatures.NonPlayerCharacter.monster_factory.MonsterParametersManager;
import ru.reeson2003.model.game.characters.creatures.ParametersController;

/**
 * Created by reeson on 11.12.16.
 */
public class MonsterParametersController extends ParametersController implements Cloneable {
    private MonsterParametersController() {}

    public MonsterParametersController(int monsterID) {
        this.parameters = MonsterParametersManager.getInstance().getParameters(monsterID);
        this.health = parameters.getMaximumHealth();
        this.mana = parameters.getMaximumMana();
    }

    @Override
    public MonsterParametersController clone() {
        MonsterParametersController result = new MonsterParametersController();
        result.parameters = this.parameters.clone();
        result.health = this.health;
        result.mana = this.mana;
        return result;
    }
}
