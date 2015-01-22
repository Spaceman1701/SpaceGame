package com.x2a.scene;

/**
 * Created by David on 12/28/2014.
 */
public class Scene extends Node{


    public Camera camera;

    public Scene() {
        camera = new Camera();
        getChildren().add(camera);
    }

    public Camera getCamera() {
        return camera;
    }

    @Override
    public void activate() {
        super.activate();
    }

    @Override
    public void deactivate() {
        super.deactivate();
    }
}
