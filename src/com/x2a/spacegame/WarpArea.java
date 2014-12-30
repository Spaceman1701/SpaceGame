package com.x2a.spacegame;

import com.x2a.spacegame.warp.WarpBackground;

/**
 * Created by Ethan on 12/29/2014.
 */
public class WarpArea extends Area{
    public WarpArea(SpaceGame game) {
        super(game);

        getChildren().add(new WarpBackground());
        getChildren().add(game.getPlayer());
    }
}
