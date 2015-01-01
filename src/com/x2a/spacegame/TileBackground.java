package com.x2a.spacegame;

import com.x2a.math.AxisAlignedBox;
import com.x2a.math.Vector2;
import com.x2a.render.Primitive;
import com.x2a.render.Renderer;
import com.x2a.scene.Camera;
import com.x2a.scene.Node;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Ethan on 12/31/2014.
 */
public class TileBackground extends Node implements Primitive{
    private BufferedImage tile;

    private Camera camera;

    public TileBackground(String imageLocation, Camera camera) {
        try {
            tile = ImageIO.read(new File(imageLocation));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.camera = camera;

    }

    @Override
    public void doDraw(Graphics2D g2) {
        AxisAlignedBox cameraView = camera.getView();

        Vector2 tileAtBottomRight = new Vector2((float)Math.ceil(cameraView.getBottomRight().x/(float)tile.getWidth())*tile.getWidth(),
                (float)Math.ceil(cameraView.getBottomRight().y/(float)tile.getHeight())*tile.getHeight());

        for (Vector2 tileLoc = tileAtBottomRight; tileLoc.x > cameraView.getTopLeft().x-tile.getWidth(); tileLoc.sub(new Vector2(tile.getWidth(), 0))) {
            for (Vector2 tileLoc2 = new Vector2(tileLoc); tileLoc2.y > cameraView.getTopLeft().y-tile.getHeight(); tileLoc2.sub(new Vector2(0, tile.getHeight()))) {
                float xTransform = tileLoc2.x - (int)(tile.getWidth()/2.0f);
                float yTransform = tileLoc2.y - (int)(tile.getHeight()/2.0f);
                g2.drawImage(tile, (int)xTransform, (int)yTransform, (int)tile.getWidth(), (int)tile.getHeight(), null);
           }
        }
    }

    @Override
    public float getDepth() {
        return 1000.0f;
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public BufferedImage getTile() {
        return tile;
    }

    @Override
    public void update(float timeElapsed) {
        super.update(timeElapsed);
        Renderer.getInstance().drawPrimitive(this);
    }
}
