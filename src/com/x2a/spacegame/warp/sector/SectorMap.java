package com.x2a.spacegame.warp.sector;

import com.x2a.math.Vector2;
import com.x2a.scene.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ethan on 1/13/2015.
 */
public class SectorMap extends Node{
    private Map<String, Sector> sectors;

    private Vector2 currentSectorLocation;

    public SectorMap() {
        sectors = new HashMap<String, Sector>();
        currentSectorLocation = new Vector2();
    }

    public Sector getSector(Vector2 location) {
        return sectors.get(location.toString());
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
    }
}
