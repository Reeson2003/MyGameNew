package ru.reeson2003.view;

import ru.reeson2003.model.characters.creatures.Creature;
import ru.reeson2003.model.characters.creatures.PlayerCharacter.PlayerCharacter;

/**
 * Created by reeson on 03.01.17.
 */
public class SwingView {
    private StringBuilder sb;
    private static SwingView instance = null;
    private MainWindow mainWindow;

    private SwingView() {
        this.mainWindow = new MainWindow();
        sb = new StringBuilder("<html>");
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
        sb.append(creatureToString(creature));
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
        stringBuilder.append(" Level: ");
        stringBuilder.append(playerCharacter.getLevel());
        sb.append(stringBuilder.toString());
        return this;
    }

    public SwingView append(String text) {
        sb.append("<br>" + text.replace("\n", "<br>"));
        return this;
    }

    public SwingView clear() {
        sb = new StringBuilder("<html>");
        return this;
    }

    public void show() {
        sb.append("</html>");
        this.mainWindow.showText(sb.toString());
    }

    private String creatureToString(Creature creature) {
        StringBuilder sb = new StringBuilder();
        sb.append("<p>");
        sb.append("----------------------------------------------------------------------------------");
        sb.append("<br>");
        sb.append(creature.getName());
        sb.append("<br>");
        sb.append(" HP: ");
        sb.append("<font color=\"red\">");
        sb.append(hpMpString(creature.getHealth(), creature.getMaximumHealth()));
        sb.append("</font>");
        sb.append("[" + creature.getHealth() + "/" + creature.getMaximumHealth() + "]");
        sb.append("<br>");
        sb.append(" MP: ");
        sb.append("<font color=\"blue\">");
        sb.append(hpMpString(creature.getMana(), creature.getMaximumMana()));
        sb.append("</font>");
        sb.append("[" +creature.getMana() + "/" + creature.getMaximumMana() + "]");
        sb.append("<br>");
        sb.append("<table border=\"2\", bgcolor =\"#00FF00\"><tr>");
        sb.append("<td>P.atk</td>");
        sb.append("<td>P.def</td>");
        sb.append("<td>M.atk</td>");
        sb.append("<td>M.def</td>");
        sb.append("<td>Crit</td>");
        sb.append("<td>A.spd</td>");
        sb.append("<td>Evas</td>");
        sb.append("<td>Accur</td>");
        sb.append("<td>A.rng</td>");
        sb.append("<td>M.spd</td>");
        sb.append("</tr>");
        sb.append("<tr>");
        sb.append("<td>");
        sb.append(creature.getPhysicalAttack());
        sb.append("</td>");
        sb.append("<td>");
        sb.append(creature.getPhysicalDefence());
        sb.append("</td>");
        sb.append("<td>");
        sb.append(creature.getMagicAttack());
        sb.append("</td>");
        sb.append("<td>");
        sb.append(creature.getMagicDefence());
        sb.append("</td>");
        sb.append("<td>");
        sb.append(creature.getCriticalChance());
        sb.append("</td>");
        sb.append("<td>");
        sb.append(creature.getAttackSpeed());
        sb.append("</td>");
        sb.append("<td>");
        sb.append(creature.getEvasion());
        sb.append("</td>");
        sb.append("<td>");
        sb.append(creature.getAccuracy());
        sb.append("</td>");
        sb.append("<td>");
        sb.append(creature.getAttackRange());
        sb.append("</td>");
        sb.append("<td>");
        sb.append(creature.getMovingSpeed());
        sb.append("</td>");
        sb.append("</tr></table>");
        sb.append("<br>");
        sb.append("Coordinate:");
        sb.append(creature.getCoordinate().toString());
        return sb.toString();
    }

    private String hpMpString(int current, int maximum) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            int size = maximum / (maximum / 10);
            for (int i = 0; i < size; i++) {
                if (i < current * size / maximum) {
                    stringBuilder.append("\u2665");
                    stringBuilder.append(" ");
                } else {
                    stringBuilder.append("\u2661");
                    stringBuilder.append(" ");
                }
            }
            return stringBuilder.toString();
        } catch (ArithmeticException e) {
            return "";
        }
    }

}
