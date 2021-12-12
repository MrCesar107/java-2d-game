package principal.graphics;

import principal.input.Keyboard;
import principal.statesmachine.StatesController;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class CanvasGame extends Canvas {
    private static final long serialVersionUID = 6211709098422523920L;
    private int width, height;
    private Keyboard keyboard;

    public CanvasGame(final int width, final int height) {
        this.width = width;
        this.height = height;

        keyboard = new Keyboard();

        setIgnoreRepaint(true);
        setPreferredSize(new Dimension(width, height));
        addKeyListener(keyboard);
        setFocusable(true);
        requestFocus();
    }

    public void draw(StatesController controller) {
        BufferStrategy buffer = getBufferStrategy();

        if (buffer == null) {
            createBufferStrategy(3);
            return;
        }

        Graphics2D g = (Graphics2D) buffer.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);
        controller.draw(g);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
        buffer.show();
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
