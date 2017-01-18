package ru.reeson2003.model.game.characters.ActionsState;

import ru.reeson2003.model.game.characters.WorldObject;
import ru.reeson2003.model.game.characters.items.Item;

/**
 * Created by nimtego_loc on 20.12.2016.
 */
public class ActionsAndState {
    private State mapItemState;
    private State inventoryItemState;
    private State equipItemState;
    private State state;
    private Interaction interaction;

    public ActionsAndState(WorldObject worldObject) {
        this.state = new StateForItem((Item)worldObject); //временно
        this.interaction = new InteractionForItem();
    }
}
