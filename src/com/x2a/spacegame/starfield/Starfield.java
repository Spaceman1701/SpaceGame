package com.x2a.spacegame.starfield;

import com.x2a.math.AxisAlignedBox;
import com.x2a.math.Vector2;
import com.x2a.scene.Camera;
import com.x2a.scene.Node;

import java.util.HashMap;

/**
 * Created by Ethan on 12/31/2014.
 */
public class Starfield extends Node{

    private static final int TILE_SIZE = 300;
    private static final int TILE_STAR_NUMBER = 10;

    private Camera camera;

    private HashMap<String, StarTile> tiles;

    public Starfield(Camera camera) {
        tiles = new HashMap<String, StarTile>();

        this.camera = camera;

        regenField(camera);
    }


    public void regenField(Camera camera) {
        tiles.clear();
    }

    @Override
    public void update(float timeElapsed) {
        AxisAlignedBox cameraView = camera.getView();

        Vector2 tileAtBottomRight = new Vector2((float)Math.ceil(cameraView.getBottomRight().x/TILE_SIZE)*TILE_SIZE,
                (float)Math.ceil(cameraView.getBottomRight().y/(float)TILE_SIZE)*TILE_SIZE);

        for (Vector2 tileLoc = tileAtBottomRight; tileLoc.x > cameraView.getTopLeft().x-TILE_SIZE; tileLoc.sub(new Vector2(TILE_SIZE, 0))) {
            for (Vector2 tileLoc2 = new Vector2(tileLoc); tileLoc2.y > cameraView.getTopLeft().y-TILE_SIZE; tileLoc2.sub(new Vector2(0, TILE_SIZE))) {
                float xTransform = tileLoc2.x - (int)(TILE_SIZE/2.0f);
                float yTransform = tileLoc2.y - (int)(TILE_SIZE/2.0f);

                StarTile tile = tiles.get(tileLoc2.toString());

                if (tile == null) {
                    tile = new StarTile(tileLoc2, TILE_STAR_NUMBER, TILE_SIZE, camera);
                    tiles.put(tileLoc2.toString(), tile);
                    //System.out.println("New tile created at: " + tileLoc2 + " HASHCODE = " + tileLoc2.hashCode());
                }
                tile.update(timeElapsed);
            }
        }
    }


}
