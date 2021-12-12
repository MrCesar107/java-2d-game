package principal.statesmachine;

import java.awt.*;

public interface GameState {
    void update();
    void draw(Graphics2D g);
}
