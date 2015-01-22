package com.x2a.spacegame.scenes.planet.terrain;

import com.x2a.spacegame.scenes.planet.TerrainTextureAtlas;

import java.awt.*;
import java.awt.image.BufferedImage;

public class TerrainData {


    private Color color;
    private String imageLocation;


    public TerrainData(Color color, String imageLocation) {
        this.color = color;
        this.imageLocation = imageLocation;
    }

    public TerrainData(TerrainData other) {
        this.color = other.color;
        this.imageLocation = other.imageLocation;
    }


    public TerrainData duplicate() {
        return new TerrainData(this);
    }

    public Color getColor() {
        return color;
    }

    public BufferedImage getImage() {
        return TerrainTextureAtlas.getImage(imageLocation);
    }
}
