package principal.statesmachine;

import principal.statesmachine.states.game.GameController;

import java.awt.*;
import java.io.IOException;

public class StatesController {
    private GameState[] states;
    private GameState currentState;

    public StatesController() throws IOException {
        initStates();
        initCurrentState();
    }

    private void initStates() throws IOException {
        states = new GameState[1];
        states[0] = new GameController();
        // Add and initialize new states when create them
    }

    private void initCurrentState() {
        currentState = states[0];
    }

    public void update() {
        currentState.update();
    }

    public void draw(Graphics2D g) {
        currentState.draw(g);
    }

    public void setCurrentState(final int state) {
        currentState = states[state];
    }

    public GameState getCurrentState() {
        return currentState;
    }
}
