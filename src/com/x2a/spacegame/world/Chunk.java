package com.x2a.spacegame.world;

import java.awt.*;

/**
 * Created by Ethan on 1/1/2015.
 */
public interface Chunk {

    public void update(float timeElapsed);

    public int getWidth();
    public int getHeight();
}
