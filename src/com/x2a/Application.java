package com.x2a;

/**
 * Created by Ethan on 12/28/2014.
 */
public class Application {

    private static final int X_RES = 768;
    private static final int Y_RES = 768;

    private static final int REFRESH_RATE = 60;

    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    public void run() {
        Window window = new Window(X_RES, Y_RES, REFRESH_RATE);

        window.run();
    }
}
