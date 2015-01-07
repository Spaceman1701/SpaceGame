package com.x2a.spacegame;

import com.x2a.game.Game;
import com.x2a.input.*;

/**
 * Created by Ethan on 12/28/2014.
 */
public class SpaceGame extends Game {

    private PlanetArea planetScene;
    private SpaceArea spaceScene;
    private WarpArea warpScene;

    private Player player;


    public SpaceGame() {
        player = new Player(this);

        planetScene = new PlanetArea(this);
        spaceScene = new SpaceArea(this);
        warpScene = new WarpArea(this);

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

    public void transitionTo(GameArea scene) {
        switch (scene) {
            case WARP:
                setCurrentScene(warpScene);
                break;
            case SPACE:
                setCurrentScene(spaceScene);
                break;
            case GROUND:
                setCurrentScene(planetScene);
                break;
        }
    }
}
