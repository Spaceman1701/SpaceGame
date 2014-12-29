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
        sprites = new TreeSet<Sprite>(new Comparator<Sprite>() {
            @Override
            public int compare(Sprite spr1, Sprite spr2) {
                return (int)(spr1.getDepth() - spr2.getDepth());
            }
        });
    }


    public static Renderer getInstance() {
        return INSTANCE;
    }


    public void drawSprite(Sprite spr, Camera camera) {

    }

    protected Collection<Sprite> getSprites() {
        return sprites;
    }

    protected void clearSprites() {
        sprites = new TreeSet<Sprite>();
    }


}
