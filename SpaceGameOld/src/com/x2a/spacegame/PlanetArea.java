package com.x2a.spacegame;

import com.x2a.input.KeyEventData;
import com.x2a.input.KeyEventListener;
import com.x2a.input.KeyEventType;
import com.x2a.input.SafeInputUtil;
import com.x2a.math.Vector2;
import com.x2a.spacegame.scenes.planet.PlanetData;

import java.awt.event.KeyEvent;

/**
 * Created by Ethan on 12/29/2014.
 */
public class PlanetArea extends Area {

    private TestSprite spr;

    public PlanetArea(SpaceGame game) {
        super(game);
        //PlanetGen planetGen = new PlanetGen(System.currentTimeMillis());

        PlanetData planetData = PlanetData.generatePlanetData();
        planetData.loadData();

        spr = new TestSprite(new Vector2(0, 0), "stuff", 1.0f, planetData.getColorImage());

        getChildren().add(spr);

        SafeInputUtil.getInstance().registerKeyEventListener(new KeyEventListener() {
            @Override
            public void onKeyEvent(KeyEventData data) {
                if (data.getEventType() == KeyEventType.KEY_PRESSED) {
                    if (data.getKeyCode() == KeyEvent.VK_L) {
                        planetData.loadData(257);
                    } else if (data.getKeyCode() == KeyEvent.VK_K) {
                        planetData.loadData(129);
                    } else if (data.getKeyCode() == KeyEvent.VK_J) {
                        planetData.loadData(33);
                    }

                    spr.setImage(planetData.getColorImage());
                }
            }
        });
    }
}
