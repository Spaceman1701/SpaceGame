package com.x2a.spacegame;

import com.x2a.game.Game;
import com.x2a.input.*;
import com.x2a.math.Vector2;

/**
 * Created by Ethan on 12/28/2014.
 */
public class SpaceGame extends Game {

    private PlanetArea planetScene;
    private SpaceArea spaceScene;
    private WarpArea warpScene;


    public SpaceGame() {
        planetScene = new PlanetArea(this);
        spaceScene = new SpaceArea(this);
        warpScene = new WarpArea(this);

        spaceScene.getChildren().add(new TestSprite(new Vector2(0, 0), "test", 1.0f));
        spaceScene.getChildren().add(new TestSprite(new Vector2(-300, 0), "test1", 2.1f));
        spaceScene.getChildren().add(new TestSprite(new Vector2(300, 0), "test2", 2.0f));
        initDebugCommands();
    }

    private void initDebugCommands() {
        SafeInputUtil.getInstance().registerKeyEventListener(new KeyEventListener() {
            @Override
            public void onKeyEvent(KeyEventData data) {
                if (data.getEventType() == KeyEventType.KEY_RELEASED) {
                    if (Character.toLowerCase(data.getKeyChar()) == 'p') {
                        setCurrentScene(planetScene);
                    } else if (Character.toLowerCase(data.getKeyChar()) == 's') {
                        setCurrentScene(spaceScene);
                    } else if (Character.toLowerCase(data.getKeyChar()) == 'w') {
                        setCurrentScene(warpScene);
                    }
                }
            }
        });
    }

    @Override
    public void update(float timeElapsed) {
        getCurrentScene().update(timeElapsed);
        getCurrentScene().draw();
    }
}
