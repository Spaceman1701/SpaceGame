package com.x2a.spacegame.starfield;

import com.x2a.math.Vector2;
import com.x2a.render.Renderer;
import com.x2a.scene.Camera;
import com.x2a.spacegame.world.Chunk;

/**
 * Created by Ethan on 1/1/2015.
 */
public class StarChunk implements Chunk {

    private Camera camera;
    private com.x2a.render.Shape rectangle;

    private Star[] stars;

    private int size;

    private Vector2 position;

    public StarChunk(Vector2 position, int size, int numberOfStars, Camera camera) {
        this.position = new Vector2(position);

        stars = new Star[numberOfStars];

        this.size = size;

        this.position = position;

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

    @Override
    public int getWidth() {
        return size;
    }

    @Override
    public int getHeight() {
        return size;
    }
}
