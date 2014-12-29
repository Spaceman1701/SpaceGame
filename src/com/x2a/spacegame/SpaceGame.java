package com.x2a.spacegame;

import com.x2a.game.Game;
import com.x2a.input.InputUtil;
import com.x2a.input.KeyEventData;
import com.x2a.input.KeyEventListener;
import com.x2a.input.KeyEventType;
import com.x2a.spacegame.scenes.PlanetArea;
import com.x2a.spacegame.scenes.SpaceArea;
import com.x2a.spacegame.scenes.WarpArea;
import jdk.internal.util.xml.impl.Input;

/**
 * Created by Ethan on 12/28/2014.
 */
public class SpaceGame extends Game {

    private PlanetArea planetScene;
    private SpaceArea spaceScene;
    private WarpArea warpScene;


    public SpaceGame() {
        initDebugCommands();
    }

    private void initDebugCommands() {
        InputUtil.getInstance().registerKeyEventListener(new KeyEventListener() {
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

    }
}
