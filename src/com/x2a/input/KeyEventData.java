package com.x2a.input;

/**
 * Created by David on 12/28/2014.
 */
public class KeyEventData {

    private KeyEventType eventType;
    private char keyChar;
    private int keyCode;
    private boolean isShiftDown;
    private boolean isCtrlDown;
    private boolean isAltDown;

    private long eventTime;

    public KeyEventData(KeyEventType eventType, char keyChar, int keyCode, boolean isShiftDown, boolean isCtrlDown, boolean isAltDown) {
        this.eventType = eventType;
        this.keyChar = keyChar;
        this.keyCode = keyCode;
        this.isShiftDown = isShiftDown;
        this.isCtrlDown = isCtrlDown;
        this.isAltDown = isAltDown;
        eventTime = System.nanoTime();
    }

    public KeyEventData(KeyEventType eventType, char keyChar, int keyCode, boolean isShiftDown, boolean isCtrlDown, boolean isAltDown, long nanoTime) { //Might be more accurate to pass time to event
        this(eventType, keyChar, keyCode, isShiftDown, isCtrlDown, isAltDown);
        this.eventTime = nanoTime;
    }

    public KeyEventType getEventType() {
        return eventType;
    }

    public char getKeyChar() {
        return keyChar;
    }

    public int getKeyCode() {
        return keyCode;
    }

    public boolean isCtrlDown() {
        return isCtrlDown;
    }

    public boolean isShiftDown() {
        return isShiftDown;
    }

    public boolean isAltDown() {
        return isAltDown;
    }

    public long getEventTime() {
        return eventTime;
    }
}
