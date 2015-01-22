package com.x2a.render;

import java.awt.*;

/**
 * Created by Ethan on 12/31/2014.
 */
public interface DrawImage {

    /**
     *
     * @param g2
     * @param width
     * @param height
     *
     * Width and Height are used for scaling the image.
     * Draws the image at (0, 0). Transforming must happen before calling this method.
     */
    public void draw(Graphics2D g2, float width, float height);

    public int getWidth();

    public int getHeight();

    public void update(float timeElapsed);
}
