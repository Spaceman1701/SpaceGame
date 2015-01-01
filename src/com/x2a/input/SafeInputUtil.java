package com.x2a.input;

import java.awt.event.*;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * Created by Ethan on 12/29/2014.
 *
 * This class is designed to be a thread safe version of InputUtil. It uses Queues to get events from the Swing even thread to the game thread.
 */
public class SafeInputUtil implements MouseListener, MouseMotionListener, MouseWheelListener, KeyListener {

    private static SafeInputUtil INSTANCE = new SafeInputUtil();

    private List<MouseEventListener> mouseEventListeners;

    private List<KeyEventListener> keyEventListeners;

    private HashSet<Character> downKeys;


    private SafeInputUtil() {
        mouseEventListeners = new ArrayList<MouseEventListener>();
        keyEventListeners = new ArrayList<KeyEventListener>();

        downKeys = new HashSet<Character>();
    }

    public static SafeInputUtil getInstance() {
        return INSTANCE;
    }

    private void handleKeyEvent(KeyEventType type, KeyEvent e) {
        KeyEventData data = new KeyEventData(type, e.getKeyChar(), e.getKeyCode(),
                        e.isShiftDown(), e.isControlDown(), e.isAltDown(), System.nanoTime());

        if (type == KeyEventType.KEY_PRESSED) {
            downKeys.add(new Character(Character.toLowerCase(data.getKeyChar())));
        } else if (type == KeyEventType.KEY_RELEASED) {
            downKeys.remove(new Character(Character.toLowerCase(data.getKeyChar())));
        }

        for (int i = 0; i<keyEventListeners.size(); i++) {
            keyEventListeners.get(i).onKeyEvent(data);
        }
    }

    private void handleMouseEvent(MouseEventType type, MouseEvent e) {
       MouseEventData data = new MouseEventData(type, e.getX(), e.getY(),
                e.getXOnScreen(), e.getYOnScreen(), e.getButton(), 0,
                e.isShiftDown(), e.isControlDown(), e.isAltDown());

        for (int i = 0; i<mouseEventListeners.size(); i++) {
            mouseEventListeners.get(i).onMouseEvent(data);
        }
    }

    public boolean isKeyDown(char key) {
        return downKeys.contains(new Character(Character.toLowerCase(key)));
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
        handleKeyEvent(KeyEventType.KEY_TYPED, e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        handleKeyEvent(KeyEventType.KEY_PRESSED, e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        handleKeyEvent(KeyEventType.KEY_RELEASED, e);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        handleMouseEvent(MouseEventType.MOUSE_CLICKED, e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        handleMouseEvent(MouseEventType.MOUSE_PRESSED, e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        handleMouseEvent(MouseEventType.MOUSE_RELEASED, e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        handleMouseEvent(MouseEventType.MOUSE_ENTERED, e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        handleMouseEvent(MouseEventType.MOUSE_EXITED, e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        handleMouseEvent(MouseEventType.MOUSE_DRAGGED, e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        handleMouseEvent(MouseEventType.MOUSE_MOVED, e);
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        MouseEventData data = new MouseEventData(MouseEventType.MOUSE_WHEEL_MOVED, e.getX(), e.getY(),
                e.getXOnScreen(), e.getYOnScreen(), e.getButton(), e.getWheelRotation(),
                e.isShiftDown(), e.isControlDown(), e.isAltDown());

        for (int i = 0; i<mouseEventListeners.size(); i++) {
            mouseEventListeners.get(i).onMouseEvent(data);
        }
    }
}
