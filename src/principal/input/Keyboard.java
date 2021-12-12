package principal.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {
    private final static int NUMBER_OF_KEYS = 256;
    private final boolean[] keys = new boolean[NUMBER_OF_KEYS];

    public boolean up, down, left, right, run, exit;

    public void update() {
        up = keys[KeyEvent.VK_W];
        down  = keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_D];
        run = keys[KeyEvent.VK_SHIFT];
        exit = keys[KeyEvent.VK_ESCAPE];
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }
}
