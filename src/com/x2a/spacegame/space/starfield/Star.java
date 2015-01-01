package com.x2a.spacegame.space.starfield;

import com.x2a.math.GameMath;
import com.x2a.math.Vector2;
import com.x2a.render.Primitive;
import com.x2a.render.Renderer;
import com.x2a.render.shapes.Rectangle;
import com.x2a.scene.Camera;
import com.x2a.scene.Node;

import java.awt.*;

/**
 * Created by Ethan on 12/31/2014.
 */
public class Star extends Node implements Primitive{


    private Camera camera;
    private Rectangle rectangle;

    private Vector2 position;

    private float size;

    private final int maxBrightness;

    public Star(Vector2 position, Camera camera) {
        this.position = new Vector2(position);

        size = (float)Math.random()*30;

        rectangle = new Rectangle(position, size, size, 0, 999.0f, Color.WHITE, true);

        this.camera = camera;

        maxBrightness = (int)size*30;
    }

    @Override
    public void doDraw(Graphics2D g2) {
        rectangle.doDraw(g2);
    }

    @Override
    public void update(float timeElasped) {
        int brightness = maxBrightness - (int)(camera.getScale()*50.0);

        brightness = GameMath.clamp(brightness, 255, 0);

        rectangle.setColor(new Color(brightness, brightness, brightness));
    }

    @Override
    public float getDepth() {
        return rectangle.getDepth();
    }
}
