package com.x2a.spacegame;

import com.x2a.input.MouseEventData;
import com.x2a.input.MouseEventListener;
import com.x2a.input.MouseEventType;
import com.x2a.input.SafeInputUtil;
import com.x2a.math.Vector2;
import com.x2a.spacegame.space.Planet;
import com.x2a.spacegame.space.SpaceBackground;
import com.x2a.spacegame.space.TileSpaceBackground;
import com.x2a.spacegame.warp.MapPlanet;

/**
 * Created by Ethan on 12/29/2014.
 */
public class SpaceArea extends Area{

    private static final float scaleFactor = 0.1f;

    private Player player;

    private Planet planet;

    public SpaceArea(SpaceGame game) {
        super(game);

        player = game.getPlayer();
        getChildren().add(game.getPlayer());
        getChildren().add(new TileSpaceBackground(getCamera()));

        planet = new Planet(0);

        initZoom();
    }

    private void initZoom() {
        SafeInputUtil.getInstance().registerMouseEventListener(new MouseEventListener() {
            @Override
            public void onMouseEvent(MouseEventData data) {
                if (data.getEventType() == MouseEventType.MOUSE_WHEEL_MOVED) {
                    getCamera().setScale(getCamera().getScale() + scaleFactor * data.getMouseWheelRotation());
                }
            }
        });
    }


    @Override
    public void onActivation() {
        super.onActivation();
        player.setState(Player.PlayerState.SPACE);
    }

    @Override
    public void onDeactivation() {
        getChildren().remove(planet);
        getGame().getCurrentScene().getCamera().setCameraPosition(new Vector2());
        getGame().getCurrentScene().getCamera().setScale(1.0f);
    }

    public void transitionTo(MapPlanet location) {
        activate();

        if (location != null) {
            planet.setId(location.getId());
            getChildren().add(planet);
        }
    }
}
