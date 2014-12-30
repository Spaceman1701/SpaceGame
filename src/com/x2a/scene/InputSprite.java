package com.x2a.scene;

import com.x2a.input.*;
import com.x2a.math.Vector2;

import java.awt.image.BufferedImage;

/**
 * Created by Ethan on 12/29/2014.
 */
public abstract class InputSprite extends Sprite {

    private KeyEventListener keyEventListener;
    private MouseEventListener mouseEventListener;

    public InputSprite(Vector2 position, float width, float height, float rotation, float depth, String imageLocation, String name) {
        super(position, width, height, rotation, depth, imageLocation, name);

        keyEventListener = new KeyEventListener() {
            @Override
            public void onKeyEvent(KeyEventData data) {
                InputSprite.this.onKeyEvent(data);
            }
        };

        mouseEventListener = new MouseEventListener() {
            @Override
            public void onMouseEvent(MouseEventData data) {
                InputSprite.this.onMouseEvent(data);
            }
        };
    }

    public InputSprite(Vector2 position, float width, float height, float rotation, float depth, BufferedImage image, String name) {
        super(position, width, height, rotation, depth, image, name);

        keyEventListener = new KeyEventListener() {
            @Override
            public void onKeyEvent(KeyEventData data) {
                InputSprite.this.onKeyEvent(data);
            }
        };

        mouseEventListener = new MouseEventListener() {
            @Override
            public void onMouseEvent(MouseEventData data) {
                InputSprite.this.onMouseEvent(data);
            }
        };
    }

    @Override
    protected void onActivation() {
        SafeInputUtil.getInstance().registerKeyEventListener(keyEventListener);
        SafeInputUtil.getInstance().registerMouseEventListener(mouseEventListener);
    }

    @Override
    protected void onDeactivation() {
        SafeInputUtil.getInstance().unregisterKeyEventListener(keyEventListener);
        SafeInputUtil.getInstance().unregisterMouseEventListener(mouseEventListener);
    }

    public abstract void onKeyEvent(KeyEventData data);

    public abstract void onMouseEvent(MouseEventData data);
}
