package com.x2a.scene;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 12/28/2014.
 */
public class Scene {

    public List<Node> children;
    public Camera camera;

    public Scene() {
        children = new ArrayList<Node>();
        camera = new Camera();
    }

    public List<Node> getChildren() {
        return children;
    }

    public Camera getCamera() {
        return camera;
    }
}
