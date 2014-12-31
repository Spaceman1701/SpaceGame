package com.x2a.render;

import com.x2a.scene.Sprite;

import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by Ethan on 12/28/2014.
 */
public class Renderer {

    private static final Renderer INSTANCE = new Renderer();



    private TreeSet<Primitive> primitives;

    private Renderer() {
        initSet();
    }

    public static Renderer getInstance() {
        return INSTANCE;
    }

    public void drawPrimitive(Primitive p) {
        primitives.add(p);
    }

    protected void initSet() {
        initShapeSet();
    }

    private void initShapeSet() {
        primitives = new TreeSet<Primitive>(new Comparator<Primitive>() {
            @Override
            public int compare(Primitive p1, Primitive p2) {
                float val = p2.getDepth() - p1.getDepth(); //Higher depth draws first

                if (val == 0) {
                    val = 1;
                }

                return (int)(val/Math.abs(val));
            }
        });
    }

    public Collection<Primitive> getPrimitives() {
        return primitives;
    }
}
