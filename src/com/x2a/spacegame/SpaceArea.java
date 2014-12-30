package com.x2a.spacegame;

/**
 * Created by Ethan on 12/29/2014.
 */
public class SpaceArea extends Area{

    private Player player;

    public SpaceArea(SpaceGame game) {
        super(game);

        player = game.getPlayer();
        getChildren().add(game.getPlayer());
    }


    @Override
    public void onActivation() {
        super.onActivation();
        player.setState(Player.PlayerState.SPACE);
    }
}
