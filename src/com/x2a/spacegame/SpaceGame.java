package com.x2a.spacegame;

import com.x2a.game.Game;
import com.x2a.input.*;
import com.x2a.math.Vector2;
import com.x2a.scene.Node;
import com.x2a.spacegame.scenes.planet.PlanetGeneration;

/**
 * Created by Ethan on 12/28/2014.
 */
public class SpaceGame extends Game {

    private PlanetArea planetScene;
    private SpaceArea spaceScene;
    private WarpArea warpScene;

    private Player player;


    public SpaceGame() {
        player = new Player();

        planetScene = new PlanetArea(this);
        spaceScene = new SpaceArea(this);
        warpScene = new WarpArea(this);

        spaceScene.getChildren().add(new TestSprite(new Vector2(0, 0), "test", 1.0f));
        planetScene.getChildren().add(new TestSprite(new Vector2(0, 0), "stuff", 1.0f, new PlanetGeneration().generatePlanetImage(100, 100)));

        initDebugCommands();
    }

    private void initDebugCommands() {
        SafeInputUtil.getInstance().registerKeyEventListener(new KeyEventListener() {
            @Override
            public void onKeyEvent(KeyEventData data) {
                if (data.getEventType() == KeyEventType.KEY_RELEASED) {
                    if (Character.toLowerCase(data.getKeyChar()) == '1') {
                        setCurrentScene(planetScene);
                    } else if (Character.toLowerCase(data.getKeyChar()) == '2') {
                        setCurrentScene(spaceScene);
                    } else if (Character.toLowerCase(data.getKeyChar()) == '3') {
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

    public Player getPlayer() {
        return player;
    }
}
