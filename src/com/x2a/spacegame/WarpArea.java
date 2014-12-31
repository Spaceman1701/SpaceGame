package com.x2a.spacegame;

import com.x2a.Application;
import com.x2a.math.Vector2;
import com.x2a.spacegame.warp.InfoWindow;
import com.x2a.spacegame.warp.MapEarth;
import com.x2a.spacegame.warp.MapPlanet;
import com.x2a.spacegame.warp.WarpBackground;

import java.awt.*;
import java.util.Random;

/**
 * Created by Ethan on 12/29/2014.
 */
public class WarpArea extends Area{

    private static final int NUMBER_PLANETS = 50;

    Player player;

    public WarpArea(SpaceGame game) {
        super(game);

        player = game.getPlayer();

        getChildren().add(new WarpBackground());
        getChildren().add(player);

        player.setPosition(new Vector2(Application.X_RES/2, Application.Y_RES/2));

        createMap();
    }

    private void createMap() {
        Random random = new Random();

        for (int i = 0; i< NUMBER_PLANETS; i++) {
            Vector2 pos = new Vector2(random.nextInt(768)-(768/2), random.nextInt(768)-(768/2));
            getChildren().add(new MapPlanet(pos, i));
        }

        getChildren().add(new MapEarth());
    }


    @Override
    protected void onActivation() {
        super.onActivation();
        player.setState(Player.PlayerState.WARP);
    }
}
