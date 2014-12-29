package com.x2a.scene;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 12/28/2014.
 */
public class Scene extends Node{


    public Camera camera;

    public Scene() {
        camera = new Camera();
    }

    public Camera getCamera() {
        return camera;
    }
}
