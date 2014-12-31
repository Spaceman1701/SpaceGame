package com.x2a.spacegame;

import com.x2a.spacegame.space.Planet;
import com.x2a.spacegame.space.SpaceBackground;
import com.x2a.spacegame.warp.MapPlanet;

/**
 * Created by Ethan on 12/29/2014.
 */
public class SpaceArea extends Area{

    private Player player;

    private Planet planet;

    public SpaceArea(SpaceGame game) {
        super(game);

        player = game.getPlayer();
        getChildren().add(game.getPlayer());
        getChildren().add(new SpaceBackground());

        planet = new Planet(0);
    }


    @Override
    public void onActivation() {
        super.onActivation();
        player.setState(Player.PlayerState.SPACE);
    }

    @Override
    public void onDeactivation() {
        getChildren().remove(planet);
    }

    public void transitionTo(MapPlanet location) {
        activate();

        if (location != null) {
            planet.setId(location.getId());
            getChildren().add(planet);
        }
    }
}
