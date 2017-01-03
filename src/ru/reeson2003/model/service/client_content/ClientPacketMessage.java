package ru.reeson2003.model.service.client_content;

import ru.reeson2003.model.characters.creatures.Creature;
import ru.reeson2003.model.characters.creatures.PlayerCharacter.PlayerCharacter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by reeson on 02.01.17.
 */
public class ClientPacketMessage implements Serializable {
    private static final long serialVersionUID = 12L;
    private PlayerCharacterSurrogate playerSurrogate;
    private List<CreatureSurrogate> creaturesSurrogate;

    public ClientPacketMessage(PlayerCharacter playerSurrogate, List<Creature> creatures) {
        this.playerSurrogate = PlayerCharacterSurrogate.getAgent(playerSurrogate);
        this.creaturesSurrogate = new ArrayList<>(creatures.size());
        for (Creature c: creatures) {
            creaturesSurrogate.add(CreatureSurrogate.createSurrogate(c));
        }
    }

    public ClientPacketMessage() {
    }

    public PlayerCharacterSurrogate getPlayerSurrogate() {
        return playerSurrogate;
    }

    public List<CreatureSurrogate> getCreatures() {
        return creaturesSurrogate;
    }

    public void setPlayerSurrogate(PlayerCharacterSurrogate playerSurrogate) {
        this.playerSurrogate = playerSurrogate;
    }

    public void setMonsters(List<CreatureSurrogate> creaturesSurrogate) {
        this.creaturesSurrogate = creaturesSurrogate;
    }
}
