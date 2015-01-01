package com.x2a.spacegame.space.starfield;

import com.x2a.math.Vector2;
import com.x2a.render.Renderer;
import com.x2a.scene.Camera;
import com.x2a.scene.Node;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ethan on 12/31/2014.
 */
public class Starfield extends Node{

    private Set<Star> stars;


    public Starfield(Camera camera) {
        stars = new HashSet<Star>();

        regenField(camera);
    }


    public void regenField(Camera camera) {
        stars.clear();
        for (int i = 0; i<35000; i++) {
            stars.add(new Star(new Vector2((float)(Math.random()-0.5)*70000.0f,(float)(Math.random()-0.5)*70000.0f), camera));
        }
    }

    @Override
    public void update(float timeElapsed) {
        super.update(timeElapsed);
        for (Star s: stars) {
            Renderer.getInstance().drawPrimitive(s);
            s.update(timeElapsed);
        }
    }


}
