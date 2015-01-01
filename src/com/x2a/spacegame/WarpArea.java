package com.x2a.spacegame;

import com.x2a.Application;
import com.x2a.input.*;
import com.x2a.math.GameMath;
import com.x2a.math.Vector2;
import com.x2a.spacegame.starfield.Starfield;
import com.x2a.spacegame.warp.InfoWindow;
import com.x2a.spacegame.warp.MapEarth;
import com.x2a.spacegame.warp.MapPlanet;
import com.x2a.spacegame.warp.WarpBackground;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by Ethan on 12/29/2014.
 */
public class WarpArea extends Area{

    private static final int NUMBER_PLANETS = 20;
    private static final float ARRIVAL_DISTANCE = 50;

    private static final float ZOOM_SCALE_FACTOR = 0.1f;

    Player player;

    Set<MapPlanet> planetSet;

    public WarpArea(SpaceGame game) {
        super(game);

        player = game.getPlayer();

        getChildren().add(new Starfield(getCamera()));
        getChildren().add(player);

        player.setPosition(new Vector2(Application.X_RES/2, Application.Y_RES/2));

        createMap();

        SafeInputUtil.getInstance().registerKeyEventListener(new KeyEventListener() {
            @Override
            public void onKeyEvent(KeyEventData data) {
                if (isActivated()) {
                    if (data.getEventType() == KeyEventType.KEY_PRESSED && data.getKeyChar() == Character.toLowerCase('t')) {
                        game.transitionTo(GameArea.SPACE);
                        SpaceArea spaceArea = (SpaceArea) game.getCurrentScene();
                        spaceArea.transitionTo(getCurrentPlanet());
                    }
                }
            }
        });

        initZoom();
    }

    private void initZoom() {
        SafeInputUtil.getInstance().registerMouseEventListener(new MouseEventListener() {
            @Override
            public void onMouseEvent(MouseEventData data) {
                if (data.getEventType() == MouseEventType.MOUSE_WHEEL_MOVED) {
                    getCamera().setScale(getCamera().getScale() + ZOOM_SCALE_FACTOR * data.getMouseWheelRotation());
                } else if (data.getEventType() == MouseEventType.MOUSE_PRESSED) {
                    if (data.getMouseButton() == MouseEvent.BUTTON2) {
                        getCamera().setCameraPosition(data.getWorldPosition(getCamera()));
                    }
                }
            }
        });
    }

    public MapPlanet getCurrentPlanet() {
        float minDist = Float.MAX_VALUE;
        MapPlanet closestPlanet = null;
        for (MapPlanet p : planetSet) {
            float dist = GameMath.getDistance(p.getPosition(), player.getPosition(Player.PlayerState.WARP));
            if (dist < minDist) {
                minDist = dist;
                closestPlanet = p;
            }
        }
        if (minDist < ARRIVAL_DISTANCE) {
            return closestPlanet;
        }
        return null;
    }

    private void createMap() {
        planetSet = new HashSet<MapPlanet>();
        Random random = new Random();

        for (int i = 0; i< NUMBER_PLANETS; i++) {
            Vector2 pos = new Vector2(random.nextInt(768)-(768/2), random.nextInt(768)-(768/2));
            MapPlanet p = new MapPlanet(pos, i, getCamera());
            getChildren().add(p);
            planetSet.add(p);
        }

        getChildren().add(new MapEarth());
    }


    @Override
    protected void onActivation() {
        super.onActivation();
        player.setState(Player.PlayerState.WARP);
    }
}
