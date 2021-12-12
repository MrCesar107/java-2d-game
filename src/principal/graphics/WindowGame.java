package principal.graphics;

import javax.swing.JFrame;
import java.awt.*;

public class WindowGame extends JFrame {
    private static final long serialVersionUID = 2673458971256075116L;
    private String title;

    public WindowGame(final String title, final CanvasGame canvas) {
        this.title = title;
        configWindow(canvas);
    }

    private void configWindow(final CanvasGame canvas) {
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());
        add(canvas, BorderLayout.CENTER);
        setUndecorated(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
