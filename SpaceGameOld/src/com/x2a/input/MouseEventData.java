package com.x2a.input;

import com.x2a.Application;
import com.x2a.math.Vector2;
import com.x2a.scene.Camera;

import java.awt.geom.AffineTransform;

/**
 * Created by David on 12/28/2014.
 */
public class MouseEventData {

    public static final int NO_BUTTON = 0;
    public static final int BUTTON_1 = 1;
    public static final int BUTTON_2 = 2;
    public static final int BUTTON_3 = 3;

    private MouseEventType eventType;
    private Vector2 position;
    private Vector2 screenPosition;
    private int mouseButton;
    private float mouseWheelRotation;
    private boolean isShiftDown;
    private boolean isCtrlDown;
    private boolean isAltDown;

    public MouseEventData(MouseEventType eventType, float posX, float posY, float screenX, float screenY, int mouseButton, float mouseWheelRotation, boolean isShiftDown, boolean isCtrlDown, boolean isAltDown) {
        this.eventType = eventType;
        this.position = new Vector2(posX- Application.X_RES/2, posY-Application.Y_RES/2);
        this.screenPosition = new Vector2(screenX, screenY);
        this.mouseButton = mouseButton;
        this.mouseWheelRotation = mouseWheelRotation;
        this.isShiftDown = isShiftDown;
        this.isCtrlDown = isCtrlDown;
        this.isAltDown = isAltDown;
    }

    public MouseEventType getEventType() {
        return eventType;
    }

    public Vector2 getPosition() {
        return new Vector2(position);
    }

    public Vector2 getScreenPosition() {
        return new Vector2(screenPosition);
    }

    public int getMouseButton() {
        return mouseButton;
    }

    public float getMouseWheelRotation() {
        return mouseWheelRotation;
    }

    public boolean isShiftDown() {
        return isShiftDown;
    }

    public boolean isCtrlDown() {
        return isCtrlDown;
    }

    public boolean isAltDown() {
        return isAltDown;
    }

    public Vector2 getWorldPosition(Camera camera) {
        System.out.println("Mouse Position is: " + getPosition());
        System.out.println("Camera position is: " + camera.getPosition());

        AffineTransform transform = new AffineTransform();
        transform.translate(camera.getPosition().x, camera.getPosition().y);
        transform.scale(camera.getScale(),camera.getScale());


        return new Vector2(getPosition()).transform(transform);
    }
}
