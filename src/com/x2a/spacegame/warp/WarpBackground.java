package com.x2a.spacegame.warp;

import com.x2a.scene.Camera;
import com.x2a.spacegame.Background;
import com.x2a.spacegame.TileBackground;

/**
 * Created by Ethan on 12/29/2014.
 */
public class WarpBackground extends Background {

    private static final String IMAGE_LOCATION = "res/images/backgrounds/SpaceBackground2.png";

    public WarpBackground() {
        super(IMAGE_LOCATION, "WARP_BG");
    }
}
