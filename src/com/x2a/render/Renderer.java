package com.x2a.render;

import com.x2a.scene.Camera;
import com.x2a.scene.Sprite;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
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
        //System.out.println("There are " + sprites.size() + " sprites");
    }

    protected Collection<Sprite> getSprites() {
        return sprites;
    }

    protected void initSet() {
        sprites = new TreeSet<Sprite>(new Comparator<Sprite>() {
            @Override
            public int compare(Sprite spr1, Sprite spr2) {
                float val = spr2.getDepth() - spr1.getDepth(); //Higher depth draws first

                if (val == 0) {
                    val = 1;
                }

                return (int)(val/Math.abs(val));
            }
        });
    }
}
