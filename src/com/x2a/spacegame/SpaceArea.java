package com.x2a.spacegame;

import com.x2a.input.MouseEventData;
import com.x2a.input.MouseEventListener;
import com.x2a.input.MouseEventType;
import com.x2a.input.SafeInputUtil;
import com.x2a.math.Vector2;
import com.x2a.spacegame.space.Planet;
import com.x2a.spacegame.starfield.StarChunk;
import com.x2a.spacegame.starfield.StarChunkFactory;
import com.x2a.spacegame.warp.MapPlanet;
import com.x2a.spacegame.world.ChunkWorld;

/**
 * Created by Ethan on 12/29/2014.
 */
public class SpaceArea extends Area{

    private static final float ZOOM_SCALE_FACTOR = 0.1f;

    private Player player;

    private Planet planet;

    private ChunkWorld starfield;

    public SpaceArea(SpaceGame game) {
        super(game);

        player = game.getPlayer();
        getChildren().add(game.getPlayer());
        //getChildren().add(new TileSpaceBackground(getCamera()));
        starfield = new ChunkWorld<StarChunk>(new StarChunkFactory(600, 3, camera), camera);
        getChildren().add(starfield);

        planet = new Planet(0);

        initZoom();
    }

    private void initZoom() {
        SafeInputUtil.getInstance().registerMouseEventListener(new MouseEventListener() {
            @Override
            public void onMouseEvent(MouseEventData data) {
                if (data.getEventType() == MouseEventType.MOUSE_WHEEL_MOVED) {
                    getCamera().setScale(getCamera().getScale() + ZOOM_SCALE_FACTOR * data.getMouseWheelRotation());
                }
            }
        });
    }


    @Override
    public void onActivation() {
        super.onActivation();
        starfield.clearWorld();
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
