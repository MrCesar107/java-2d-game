package principal.statesmachine.states.game;

import principal.sprites.SpriteSheet;
import principal.statesmachine.GameState;
import principal.tools.AssetsLoader;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GameController implements GameState {
    private MapController mapController;
    String text = AssetsLoader.readTextFile("/text/prueba");

    public GameController() throws IOException {
    }

    @Override
    public void update() {
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.drawString(text, 10, 10);
    }
}
