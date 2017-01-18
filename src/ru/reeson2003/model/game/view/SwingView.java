package ru.reeson2003.model.game.view;

import ru.reeson2003.model.game.characters.creatures.Creature;
import ru.reeson2003.model.game.characters.creatures.PlayerCharacter.PlayerCharacter;

import java.util.Collection;

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
        if (instance == null)
            instance = new SwingView();
        return instance;
    }

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

    public SwingView append(Collection<Creature> creatures) {
        StringBuilder stringBuilder = new StringBuilder();
        int counter = 1;
        for (Creature c : creatures) {
            stringBuilder.append("<br>")
                    .append(counter)
                    .append(creatureForList(c));
            counter++;
        }
        sb.append(stringBuilder.toString());
        return this;
    }

    private String creatureForList(Creature creature) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<font color=\"red\">")
                .append(hpMpString(creature.getHealth(), creature.getMaximumHealth()))
                .append("</font>")
                .append(" [" + creature.getHealth() + "/" + creature.getMaximumHealth() + "] ")
                .append(creature.getName());
        return stringBuilder.toString();
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

    public Character getKeyTyped() {
        return mainWindow.getKeyTyped();
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
        sb.append("[" + creature.getMana() + "/" + creature.getMaximumMana() + "]");
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
