package com.x2a.input;

import com.x2a.math.Vector2;

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
        this.position = new Vector2(posX, posY);
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
}
