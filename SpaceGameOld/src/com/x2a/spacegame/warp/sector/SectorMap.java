package com.x2a.spacegame.warp.sector;

import com.x2a.math.Vector2;
import com.x2a.render.Renderer;
import com.x2a.render.Text;
import com.x2a.render.shapes.Rectangle;
import com.x2a.scene.Node;
import com.x2a.spacegame.SpaceGame;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Ethan on 1/13/2015.
 */
public class SectorMap extends Node{
    private final long seed;

    private Map<String, Sector> sectors;

    private Vector2 currentSectorLocation;

    private Random random;

    private SpaceGame game;

    public SectorMap(long seed, SpaceGame game) {
        sectors = new HashMap<String, Sector>();
        currentSectorLocation = new Vector2();
        this.seed = seed;
        random = new Random(seed);
        this.game = game;
    }

    public Sector getSector(Vector2 location) {
        Sector sector = sectors.get(location.toString());
        if (sector == null) {
            sector = new Sector(location, 720, random.nextLong(), game.getCurrentScene().getCamera());
            sectors.put(location.toString(), sector);
        }
        return sector;
    }

    public Vector2 getCurrentSectorLocation() {
        return new Vector2(currentSectorLocation);
    }

    public void setCurrentSectorLocation(Vector2 currentSectorLocation) {
        this.currentSectorLocation = new Vector2(currentSectorLocation);
    }

    @Override
    public void update(float timeElapsed) {
        Sector s = getSector(currentSectorLocation);
        s.update(timeElapsed);
        Text t = new Text("Sector 0", new Font("Arial", Font.PLAIN, 95), true, new Vector2(0, -420), 0, 0, 0, Color.WHITE, 1000);
        Renderer.getInstance().drawPrimitive(t);

        Rectangle rect = new Rectangle(new Vector2(), 800, 800, 0, 1000, Color.WHITE, false);
        Renderer.getInstance().drawPrimitive(rect);
    }
}
