package ru.reeson2003.view;



import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

/**
 * Created by reeson on 03.01.17.
 */
public class MainWindow extends JFrame {
    private JLabel textLabel;
    private KeyListener keyListener;

    public MainWindow() {
        this.textLabel = new JLabel();
        this.add(textLabel, BorderLayout.NORTH);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationByPlatform(true);
        this.setSize(800, 500);
        this.addKeyListener(keyListener);
        this.setVisible(true);
    }

    public void showText(String text) {
        this.textLabel.setText(text);
    }
}
