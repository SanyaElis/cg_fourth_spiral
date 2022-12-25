package ru.cs.vsu.eliseev.cg;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private final DrawPanel dp = new DrawPanel();
    private final JScrollPane buttons = new JScrollPane();
    public MainFrame()  {
//        this.pack();
        this.setTitle("Спираль");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.add(dp);
        Button actionButton = new Button();
        actionButton.setLabel("Hi");
        buttons.add(actionButton);
        JTextPane tp = new JTextPane();
        tp.setSize(30,30);
        buttons.add(tp);
        this.add(buttons, BorderLayout.AFTER_LAST_LINE);
    }

    public static void main(String[] args) {
        MainFrame myFrame = new MainFrame();
        myFrame.setVisible(true);
    }
}
