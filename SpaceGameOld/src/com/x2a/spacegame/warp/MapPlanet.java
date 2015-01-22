package com.x2a.spacegame.warp;

import com.x2a.input.KeyEventData;
import com.x2a.input.MouseEventData;
import com.x2a.input.MouseEventType;
import com.x2a.math.GameMath;
import com.x2a.math.Vector2;
import com.x2a.scene.Camera;
import com.x2a.scene.InputSprite;
import com.x2a.spacegame.scenes.planet.PlanetData;

import java.awt.*;

/**
 * Created by Ethan on 12/29/2014.
 */
public class MapPlanet extends InputSprite{

    private static final String IMAGE_LOCATION = "res/images/sprites/MapPlanet.png";

    private int id;

    private boolean infoWindowUp;
    private InfoWindow infoWindow;

    private Camera camera;

    private PlanetData data;

    public MapPlanet(Vector2 position, int id, Camera camera) {
        super(position, 10, 10, 0, 10, IMAGE_LOCATION, "planet_" + id);

        this.id = id;

        data = PlanetData.generatePlanetData();
        data.loadData(33);
        setImage(data.getColorImage());
        data.unloadData();

        infoWindow = new InfoWindow("Location:" +'\n' + "Planet " + id, getPosition().add(new Vector2(50, 50)), 100, 50, Color.WHITE, Color.RED);

        this.camera = camera;
    }

    @Override
    public void onKeyEvent(KeyEventData data) {

    }

    @Override
    public void onMouseEvent(MouseEventData data) {
        if (data.getEventType() == MouseEventType.MOUSE_PRESSED && data.getMouseButton() == MouseEventData.BUTTON_1) {
            if (GameMath.insideAABB(getPosition(), getWidth(), getHeight(), data.getWorldPosition(camera))) {
                if (!infoWindowUp) {
                    infoWindowUp = true;
                    getChildren().add(infoWindow);
                } else {
                    infoWindowUp = false;
                    getChildren().remove(infoWindow);
                }
            }
        }
    }

    @Override
    public void update(float timeElapsed) {
        super.update(timeElapsed);
    }

    public int getId() {
        return id;
    }

    public PlanetData getData() {
        return data;
    }
}
