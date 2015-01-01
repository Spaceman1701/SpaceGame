package com.x2a.spacegame.space;

import com.x2a.scene.Camera;
import com.x2a.spacegame.TileBackground;

/**
 * Created by Ethan on 12/31/2014.
 */
public class TileSpaceBackground extends TileBackground{

    private static final String IMAGE_LOCATION = "res/images/backgrounds/SpaceBackground2.png";


    public TileSpaceBackground(Camera camera) {
        super(IMAGE_LOCATION, camera);
    }
}
