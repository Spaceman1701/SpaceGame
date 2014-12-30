package com.x2a.spacegame;

import com.x2a.spacegame.warp.WarpBackground;

/**
 * Created by Ethan on 12/29/2014.
 */
public class WarpArea extends Area{

    Player player;

    public WarpArea(SpaceGame game) {
        super(game);

        player = game.getPlayer();

        getChildren().add(new WarpBackground());
        getChildren().add(player);
    }


    @Override
    protected void onActivation() {
        super.onActivation();
        player.setState(Player.PlayerState.WARP);
    }
}
