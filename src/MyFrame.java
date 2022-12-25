import ru.cs.vsu.eliseev.cg.DrawPanel;

import javax.swing.*;

public class MyFrame extends JFrame{
    private JButton button1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JScrollPane myPanel;
    private JPanel testPanel = new DrawPanel();

    public MyFrame() {
        this.pack();
        this.setTitle("Спираль");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        testPanel.add(new DrawPanel());
    }

    public static void main(String[] args) {
        MyFrame mf = new MyFrame();
        mf.setVisible(true);
    }
}
