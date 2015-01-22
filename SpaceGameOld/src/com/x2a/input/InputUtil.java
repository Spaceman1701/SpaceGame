package com.x2a.input;

import java.awt.event.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 12/28/2014.
 */
public class InputUtil implements MouseListener, MouseMotionListener, MouseWheelListener, KeyListener {

    private static final InputUtil instance = new InputUtil();

    public static InputUtil getInstance() {
        return instance;
    }

    private List<MouseEventListener> mouseEventListeners;
    //private List<MouseEventData> pendingMouseEvents;
    private List<KeyEventListener> keyEventListeners;
    //private List<KeyEventData> pendingKeyEvents;

    private InputUtil() {
        mouseEventListeners = new ArrayList<MouseEventListener>();
        //pendingMouseEvents = new ArrayList<MouseEventData>();
        keyEventListeners = new ArrayList<KeyEventListener>();
        //pendingKeyEvents = new ArrayList<KeyEventData>();
    }

    public void registerMouseEventListener(MouseEventListener listener) {
        mouseEventListeners.add(listener);
    }

    public void unregisterMouseEventListener(MouseEventListener listener) {
        mouseEventListeners.remove(listener);
    }

    public void registerKeyEventListener(KeyEventListener listener) {
        keyEventListeners.add(listener);
    }

    public void unregisterKeyEventListener(KeyEventListener listener) {
        keyEventListeners.remove(listener);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        KeyEventData eventData = new KeyEventData(KeyEventType.KEY_TYPED, e.getKeyChar(), e.getKeyCode(),
                e.isShiftDown(), e.isControlDown(), e.isAltDown());
        keyEventListeners.forEach((KeyEventListener l) -> l.onKeyEvent(eventData));
    }

    @Override
    public void keyPressed(KeyEvent e) {
        KeyEventData eventData = new KeyEventData(KeyEventType.KEY_PRESSED, e.getKeyChar(), e.getKeyCode(),
                e.isShiftDown(), e.isControlDown(), e.isAltDown());
        keyEventListeners.forEach((KeyEventListener l) -> l.onKeyEvent(eventData));

    }

    @Override
    public void keyReleased(KeyEvent e) {
        KeyEventData eventData = new KeyEventData(KeyEventType.KEY_RELEASED, e.getKeyChar(), e.getKeyCode(),
                e.isShiftDown(), e.isControlDown(), e.isAltDown());
        keyEventListeners.forEach((KeyEventListener l) -> l.onKeyEvent(eventData));

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        MouseEventData eventData = new MouseEventData(MouseEventType.MOUSE_CLICKED, e.getX(), e.getY(),
                e.getXOnScreen(), e.getYOnScreen(), e.getButton(), 0,
                e.isShiftDown(), e.isControlDown(), e.isAltDown());
        mouseEventListeners.forEach((MouseEventListener l) -> l.onMouseEvent(eventData));
    }

    @Override
    public void mousePressed(MouseEvent e) {
        MouseEventData eventData = new MouseEventData(MouseEventType.MOUSE_PRESSED, e.getX(), e.getY(),
                e.getXOnScreen(), e.getYOnScreen(), e.getButton(), 0,
                e.isShiftDown(), e.isControlDown(), e.isAltDown());
        mouseEventListeners.forEach((MouseEventListener l) -> l.onMouseEvent(eventData));

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        MouseEventData eventData = new MouseEventData(MouseEventType.MOUSE_RELEASED, e.getX(), e.getY(),
                e.getXOnScreen(), e.getYOnScreen(), e.getButton(), 0,
                e.isShiftDown(), e.isControlDown(), e.isAltDown());
        mouseEventListeners.forEach((MouseEventListener l) -> l.onMouseEvent(eventData));

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        MouseEventData eventData = new MouseEventData(MouseEventType.MOUSE_ENTERED, e.getX(), e.getY(),
                e.getXOnScreen(), e.getYOnScreen(), e.getButton(), 0,
                e.isShiftDown(), e.isControlDown(), e.isAltDown());
        mouseEventListeners.forEach((MouseEventListener l) -> l.onMouseEvent(eventData));

    }

    @Override
    public void mouseExited(MouseEvent e) {
        MouseEventData eventData = new MouseEventData(MouseEventType.MOUSE_EXITED, e.getX(), e.getY(),
                e.getXOnScreen(), e.getYOnScreen(), e.getButton(), 0,
                e.isShiftDown(), e.isControlDown(), e.isAltDown());
        mouseEventListeners.forEach((MouseEventListener l) -> l.onMouseEvent(eventData));

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        MouseEventData eventData = new MouseEventData(MouseEventType.MOUSE_DRAGGED, e.getX(), e.getY(),
                e.getXOnScreen(), e.getYOnScreen(), e.getButton(), 0,
                e.isShiftDown(), e.isControlDown(), e.isAltDown());
        mouseEventListeners.forEach((MouseEventListener l) -> l.onMouseEvent(eventData));

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        MouseEventData eventData = new MouseEventData(MouseEventType.MOUSE_MOVED, e.getX(), e.getY(),
                e.getXOnScreen(), e.getYOnScreen(), e.getButton(), 0,
                e.isShiftDown(), e.isControlDown(), e.isAltDown());
        mouseEventListeners.forEach((MouseEventListener l) -> l.onMouseEvent(eventData));

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        MouseEventData eventData = new MouseEventData(MouseEventType.MOUSE_WHEEL_MOVED, e.getX(), e.getY(),
                e.getXOnScreen(), e.getYOnScreen(), e.getButton(), (float) e.getPreciseWheelRotation(),
                e.isShiftDown(), e.isControlDown(), e.isAltDown());
        mouseEventListeners.forEach((MouseEventListener l) -> l.onMouseEvent(eventData));
    }
}
