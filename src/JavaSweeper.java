import javax.swing.*;
import java.awt.*;

public class JavaSweeper extends JFrame {
    JPanel panel;
    public static void main(String[] args) {
        new JavaSweeper();
    }

    public JavaSweeper() throws HeadlessException {
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(500, 300));
        add(panel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Java Sweeper");
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }
}
