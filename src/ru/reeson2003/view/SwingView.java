package ru.reeson2003.view;

import ru.reeson2003.model.characters.creatures.Creature;
import ru.reeson2003.model.characters.creatures.PlayerCharacter.PlayerCharacter;

/**
 * Created by reeson on 03.01.17.
 */
public class SwingView {
    String text;
    private static SwingView instance = null;
    private MainWindow mainWindow;

    private SwingView() {
        this.mainWindow = new MainWindow();
        this.text = "<html>";
    }

    public static SwingView getInstance() {
        if (instance ==  null)
            instance = new SwingView();
        return instance;
    }

//    public void showPacketMessage(ClientPacketMessage message) {
//        PlayerCharacterSurrogate player = message.getPlayerSurrogate();
//        List<CreatureSurrogate> creatureSurrogates = message.getCreatures();
//        StringBuilder sb = new StringBuilder();
//        sb.append("<html>");
//        sb.append("Player: ");
//        sb.append(player.getName());
//        sb.append("     Target: ");
//        sb.append(target);
//        sb.append("<br>");
//        sb.append(" HP: ");
//        sb.append(hpMpString(player.getHealth(), player.getMaximumHealth()));
//        sb.append("<br>");
//        sb.append(" MP: ");
//        sb.append(hpMpString(player.getMana(), player.getMaximumMana()));
//        sb.append("<br>");
//        sb.append("----------------------------------------------------------------------------------");
//        for (int i = 0; i < creatureSurrogates.size(); i++) {
//            sb.append("<br>");
//            sb.append(i+1);
//            sb.append(". ");
//            sb.append(creatureSurrogates.get(i).getName());
//            sb.append(" HP: ");
//            sb.append(hpMpString(creatureSurrogates.get(i).getHealth(), creatureSurrogates.get(i).getMaximumHealth()));
//        }
//        sb.append("</html>");
//        mainWindow.showText(sb.toString());
//    }

    public void showCreature(Creature creature) {
        mainWindow.showText(creatureToString(creature));
    }

    public SwingView append(Creature creature) {
        this.text += creatureToString(creature);
        return this;
    }

    public SwingView append(PlayerCharacter playerCharacter) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(creatureToString(playerCharacter));
        stringBuilder.append("<br>");
        stringBuilder.append("Experience: [");
        stringBuilder.append(playerCharacter.getExperience());
        stringBuilder.append("/");
        stringBuilder.append(playerCharacter.getExpToNextLevel());
        stringBuilder.append("]");
        this.text += stringBuilder.toString();
        return this;
    }

    public SwingView append(String text) {
        this.text = this.text + "<br>" + text.replace("\n", "<br>");
        return this;
    }

    public SwingView clear() {
        this.text = "<html>";
        return this;
    }

    public void show() {
        this.text += "</html>";
        this.mainWindow.showText(text);
    }

    private String creatureToString(Creature creature) {
        StringBuilder sb = new StringBuilder();
        sb.append("<br>");
        sb.append("----------------------------------------------------------------------------------");
        sb.append("<br>");
        sb.append(creature.getName());
        sb.append("<br>");
        sb.append(" HP: ");
        sb.append(hpMpString(creature.getHealth(), creature.getMaximumHealth()));
        sb.append("[" + creature.getHealth() + "/" + creature.getMaximumHealth() + "]");
        sb.append("<br>");
        sb.append(" MP: ");
        sb.append(hpMpString(creature.getMana(), creature.getMaximumMana()));
        sb.append("[" +creature.getMana() + "/" + creature.getMaximumMana() + "]");
        sb.append("<br>");
        sb.append("[P.atk:");
        sb.append(creature.getPhysicalAttack());
        sb.append("][P.def:");
        sb.append(creature.getPhysicalDefence());
        sb.append("][M.atk:");
        sb.append(creature.getMagicAttack());
        sb.append("][M.def:");
        sb.append(creature.getMagicDefence());
        sb.append("][Crit:");
        sb.append(creature.getCriticalChance());
        sb.append("][A.spd:");
        sb.append(creature.getAttackSpeed());
        sb.append("][Evas:");
        sb.append(creature.getEvasion());
        sb.append("][Accur:");
        sb.append(creature.getAccuracy());
        sb.append("][A.rng:");
        sb.append(creature.getAttackRange());
        sb.append("][M.spd:");
        sb.append(creature.getMovingSpeed());
        sb.append("]");
        sb.append("<br>");
        sb.append("Coordinate:");
        sb.append(creature.getCoordinate().toString());
        return sb.toString();
    }

    private String hpMpString(int current, int maximum) {
        StringBuilder stringBuilder = new StringBuilder();
        int size = maximum / (maximum / 10);
        for (int i = 0; i < size; i++) {
            if(i < current*size/maximum) {
                stringBuilder.append("\u2665");
                stringBuilder.append(" ");
            }
            else {
                stringBuilder.append("\u2661");
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

}
