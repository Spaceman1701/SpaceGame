package com.x2a.spacegame.warp;

import com.x2a.math.Vector2;
import com.x2a.render.Renderer;
import com.x2a.render.Text;
import com.x2a.render.shapes.RoundedRect;
import com.x2a.scene.Node;

import java.awt.*;

/**
 * Created by Ethan on 12/30/2014.
 */
public class InfoWindow extends Node{

    RoundedRect windowBackdrop;
    Text text;

    public InfoWindow(String text, Vector2 position, float width, float height, Color bgcolor, Color textColor) {
        windowBackdrop = new RoundedRect(position, width, height, 12, 12, 0, 0, bgcolor, true);

        this.text = new Text(text, position.add(new Vector2(0, height/2)), width, height, 0, textColor, -1);
    }

    @Override
    public void update(float timeElapsed) {
        super.update(timeElapsed);

        Renderer.getInstance().drawPrimitive(windowBackdrop);
        Renderer.getInstance().drawPrimitive(text);
    }


}
