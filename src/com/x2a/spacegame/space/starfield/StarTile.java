package com.x2a.spacegame.space.starfield;

import com.x2a.math.AxisAlignedBox;
import com.x2a.math.Vector2;
import com.x2a.render.Renderer;
import com.x2a.scene.Camera;
import com.x2a.scene.Node;

/**
 * Created by Ethan on 12/31/2014.
 */
public class StarTile extends Node{

    private Star[] stars;

    private int size;

    private Vector2 position;

    public StarTile(Vector2 position, int numberOfStars, int size, Camera camera) {
        stars = new Star[numberOfStars];

        this.size = size;

        this.position = position;

        regenField(camera);
    }

    public void regenField(Camera camera) {
        for (int i = 0; i<stars.length; i++) {
            stars[i] = new Star(new Vector2((float)(Math.random()-0.5)*size,(float)(Math.random()-0.5)*size).add(position), camera);
        }
    }

    @Override
    public void update(float timeElapsed) {
        for (Star s : stars) {
            s.update(timeElapsed);
            Renderer.getInstance().drawPrimitive(s);
        }
    }
}
