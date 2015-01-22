package com.x2a.spacegame.starfield;

import com.x2a.math.Vector2;
import com.x2a.scene.Camera;
import com.x2a.spacegame.world.ChunkFactory;

/**
 * Created by Ethan on 1/1/2015.
 */
public class StarChunkFactory implements ChunkFactory {

    private int size;
    private int starsPerTile;
    private Camera camera;

    public StarChunkFactory(int size, int starsPerTile, Camera camera) {
        this.size = size;
        this.camera = camera;
        this.starsPerTile = starsPerTile;
    }


    @Override
    public StarChunk newChunk(Vector2 location) {
        return new StarChunk(location, size, 2, camera);
    }

    @Override
    public void resetFactory() {

    }

    @Override
    public int getChunkWidth() {
        return size;
    }

    @Override
    public int getChunkHeight() {
        return size;
    }
}
