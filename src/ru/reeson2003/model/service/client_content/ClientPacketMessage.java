package ru.reeson2003.model.service.client_content;

import ru.reeson2003.model.characters.creatures.NonPlayerCharacter.Monster;
import ru.reeson2003.model.characters.creatures.PlayerCharacter.PlayerCharacter;

import java.io.Serializable;

/**
 * Created by reeson on 02.01.17.
 */
public class ClientPacketMessage implements Serializable {
    private PlayerCharacterAgent playerCharacter;
    private MonsterAgent[] monsters;

    public ClientPacketMessage(PlayerCharacter playerCharacter, Monster[] monsters) {
        this.playerCharacter = PlayerCharacterAgent.getAgent(playerCharacter);
        this.monsters = new MonsterAgent[monsters.length];
        for (int i = 0; i < monsters.length; i++) {
            this.monsters[i] = MonsterAgent.getAgent(monsters[i]);
        }
    }

    public ClientPacketMessage() {
    }

    public PlayerCharacterAgent getPlayerCharacter() {
        return playerCharacter;
    }

    public MonsterAgent[] getMonsters() {
        return monsters;
    }

    public void setPlayerCharacter(PlayerCharacterAgent playerCharacter) {
        this.playerCharacter = playerCharacter;
    }

    public void setMonsters(MonsterAgent[] monsters) {
        this.monsters = monsters;
    }
}
