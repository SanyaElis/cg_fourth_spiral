package ru.cs.vsu.eliseev.cg;

import javax.swing.*;

public class MyFrame extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;

    public MyFrame() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
    }

    public static void main(String[] args) {
        MyFrame dialog = new MyFrame();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
