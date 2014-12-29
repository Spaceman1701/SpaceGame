package com.x2a.spacegame;

import com.x2a.game.Game;
import com.x2a.math.Vector2;
import com.x2a.scene.Sprite;

/**
 * Created by Ethan on 12/28/2014.
 */
public class SpaceGame extends Game {

    Sprite test;

    public SpaceGame() {
        test = new TestSprite(new Vector2(), "test1", 1.1f);

        getCurrentScene().getChildren().add(test);

        getCurrentScene().getChildren().add(new TestSprite(new Vector2(50, 0), "test2", 1.0f));
    }

    @Override
    public void update(float timeElapsed) {
        //getCurrentScene().getCamera().moveCameraPosition(new Vector2(-1, 0));

        getCurrentScene().update(timeElapsed);
        getCurrentScene().draw();

       // test.draw();
    }
}
