package ru.cs.vsu.eliseev.cg;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(new DrawPanel());
        frame.setVisible(true);
        frame.add(new Button());
//        MainFrame myFrame = new MainFrame();

    }
}
