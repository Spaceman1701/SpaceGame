package com.x2a.render;

import com.x2a.scene.Camera;
import com.x2a.scene.Sprite;

import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by Ethan on 12/28/2014.
 */
public class Renderer {

    private static final Renderer INSTANCE = new Renderer();

    private TreeSet<Sprite> sprites;

    private Renderer() {
        initSet();
    }

    public static Renderer getInstance() {
        return INSTANCE;
    }

    public void drawSprite(Sprite spr) {
        sprites.add(spr);
    }

    protected Collection<Sprite> getSprites() {
        return sprites;
    }

    protected void initSet() {
        sprites = new TreeSet<Sprite>((Sprite spr1, Sprite spr2) ->
                (int)(spr1.getDepth() - spr2.getDepth()));
    }
}
