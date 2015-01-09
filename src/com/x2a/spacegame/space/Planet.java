package com.x2a.spacegame.space;

import com.x2a.math.Vector2;
import com.x2a.render.Renderer;
import com.x2a.render.Text;
import com.x2a.scene.Sprite;
import com.x2a.spacegame.scenes.planet.PlanetData;

import java.awt.*;

/**
 * Created by Ethan on 12/30/2014.
 */
public class Planet extends Sprite {

    private static final String IMAGE_LOCATION = "res/images/sprites/MapPlanet.png";

    private PlanetData data;
    private int id;

    public Planet(int id, PlanetData data) {
        super(new Vector2(), 900, 900, 0, 20, IMAGE_LOCATION, "SPR_PLANET_SPACE");

        this.data = data;
        this.id = id;

        data.loadData(2049);
        setImage(data.getColorImage());
    }

    @Override
    public void update(float timeElapsed) {
        Renderer.getInstance().drawPrimitive(new Text("Planet: " + id, getPosition(), 50, 50, 0, Color.RED, 19));
    }

    public void unload() {
        data.unloadData();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
