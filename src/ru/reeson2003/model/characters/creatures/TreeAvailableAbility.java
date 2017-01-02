package ru.reeson2003.model.characters.creatures;

import ru.reeson2003.model.characters.battle.Ability;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nimtego_loc on 26.12.2016.
 */
class TreeAvailableAbility {
    private List<Ability> ability;

    private TreeAvailableAbility () {
        ability = new ArrayList<>();
// TODO: 26.12.2016
    }
/*    public static ArrayList<Ability> getTreeAbilityByLevel(final int level) {
        return  ability;
    }*/
    public void setAbility(final ArrayList<Ability> ability) {
        this.ability = ability;
    }

/*    public void getAbilityByNumber(int numberSlot) {
        if (numberSlot < 0 || numberSlot > slot.length -1)
            throw new Exception;
        if (slot[numberSlot] != null)
            slot[numberSlot].use(ownerToolbar.getTarget());
    }*/
}
