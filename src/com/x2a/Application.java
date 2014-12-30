package com.x2a;

import com.x2a.game.Game;
import com.x2a.input.SafeInputUtil;
import com.x2a.spacegame.SpaceGame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ethan on 12/28/2014.
 */
public class Application {

    private static final double ONE_MILLISECOND_NANOSECONDS = 1000000.0;
    private static final double ONE_SECOND = 1000;

    private static final int X_RES = 768;
    private static final int Y_RES = 768;

    private static final int REFRESH_RATE = 60;

    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    public void run() {
        Window window = new Window(X_RES, Y_RES);
        double frameTime = ONE_SECOND/(double)REFRESH_RATE;

        Game game = new SpaceGame();


        Timer updateTimer = new javax.swing.Timer((int)frameTime, new ActionListener() {

            private long lastTime;

            @Override
            public void actionPerformed(ActionEvent e) {
                float timeElapsed = (float)(Math.abs(System.nanoTime() - lastTime)/ONE_MILLISECOND_NANOSECONDS);

                //System.out.println(Math.abs(timeElapsed);
                game.update(timeElapsed);
                window.setCurrentCamera(game.getCurrentScene().getCamera());
                window.run();

                lastTime = System.nanoTime();
            }
        });
        updateTimer.start();
    }
}
