package ru.reeson2003.model.game.view;



import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by reeson on 03.01.17.
 */
public class MainWindow extends JFrame {
    private static final long serialVersionUID = -1671522402146775466L;
    private JLabel textLabel;
    private Character keyTyped;

    public MainWindow() {
        this.textLabel = new JLabel();
        this.add(textLabel, BorderLayout.NORTH);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationByPlatform(true);
        this.setSize(800, 500);
        this.addKeyListener(getKeyListener());
        this.setVisible(true);
    }

    public void showText(String text) {
        this.textLabel.setText(text);
    }

    private KeyListener getKeyListener() {
        KeyListener result = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                keyTyped = e.getKeyChar();
            }
        };
        return result;
    }

    public Character getKeyTyped() {
        Character result = keyTyped;
        keyTyped = null;
        return result;
    }
}
