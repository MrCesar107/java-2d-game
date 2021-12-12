package principal;

import jdk.jfr.internal.tool.Main;
import principal.graphics.CanvasGame;
import principal.graphics.WindowGame;
import principal.statesmachine.StatesController;

public class MainGestor {
    private boolean isRunning = false;
    private String title;
    private int width;
    private int height;

    private CanvasGame canvas;
    private WindowGame window;
    private StatesController statesController;

    private MainGestor(final int width, final int height, final String title) {
        this.width = width;
        this.height = height;
        this.title = title;
    }

    public static void main(String[] args) {
        MainGestor principal = new MainGestor(640, 360, "Java game");
        principal.initGame();
    }

    private void initGame() {
        isRunning = true;
        init();
    }

    private void init() {
        canvas = new CanvasGame();
        window = new WindowGame(title, canvas);
        statesController = new StatesController();
        initGameProcess();
    }

    private void initGameProcess() {
        int aps = 0;
        int fps = 0;

        final int nanoSeconds = 1000000000;
        final int targetAPS = 60;
        final double nanoSecondsPerUpdate = nanoSeconds / targetAPS;

        long updateReference = System.nanoTime();
        long referenceCounter = System.nanoTime();

        double timeElapsed;
        double delta = 0;

        while (isRunning) {
            final long startLoop = System.nanoTime();

            timeElapsed = startLoop - updateReference;
            updateReference = startLoop;

            delta += timeElapsed / nanoSecondsPerUpdate;

            while (delta >= 1) {
                update();
                aps++;
                delta--;
            }

            draw();
            fps++;

            if (System.nanoTime() - referenceCounter > nanoSeconds) {
                System.out.println("APS: " + aps);
                System.out.println("FPS: " + fps);

                aps = 0;
                fps = 0;
                referenceCounter = System.nanoTime();
            }
        }
    }

    private void update() {
        statesController.update();
    }

    private void draw() {
//        statesController.draw();
    }
}
