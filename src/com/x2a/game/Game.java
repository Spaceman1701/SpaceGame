package com.x2a.game;

import com.x2a.scene.Scene;

/**
 * Created by Ethan on 12/28/2014.
 */
public class Game {

    Scene currentScene;


    public Game() {
        currentScene = new Scene();
    }

    public void update(float timeElapsed) {

    }

    public Scene getCurrentScene() {
        return currentScene;
    }
}
