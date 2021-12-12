package principal;

import jdk.jfr.internal.tool.Main;

public class MainGestor {
    private boolean isRunning = false;
    private String title;
    private int width;
    private int height;

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

    }
}
