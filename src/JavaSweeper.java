import javax.swing.*;
import java.awt.*;
import java.util.Objects;

import sweeper.Box;

public class JavaSweeper extends JFrame {
    private static final int COLS = 15;
    private static final int ROWS = 1;
    private static final int IMAGE_SIZE = 50;

    private JPanel panel;

    public static void main(String[] args) {
        new JavaSweeper();
    }

    private JavaSweeper() throws HeadlessException {
        setImages();
        initPanel();
        initFrame();
    }

    private void initPanel() {
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Box box : Box.values()) {
                    g.drawImage((Image) box.image,
                            box.ordinal() * IMAGE_SIZE,0, this);
                }
            }
        };

        panel.setPreferredSize(new Dimension(COLS * IMAGE_SIZE,
                                            ROWS * IMAGE_SIZE));
        add(panel);
    }

    private void initFrame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Java Sweeper");
        setVisible(true);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
    }

    private void setImages() {
        for (Box box : Box.values()) {
            box.image = getImage(box.name().toLowerCase());
        }
    }

    private Image getImage(String name) {
        String fileName = "img/" + name + ".png";
        return new ImageIcon(Objects.requireNonNull(getClass().getResource(fileName))).getImage();
    }
}
