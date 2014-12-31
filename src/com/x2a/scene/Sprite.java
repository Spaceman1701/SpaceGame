package com.x2a.scene;

import com.x2a.math.Vector2;
import com.x2a.render.Primitive;
import com.x2a.render.Renderer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Ethan on 12/28/2014.
 */
public abstract class Sprite extends Node implements Primitive {

    private float depth; //Higher depth = further from camera.

    private Vector2 position;
    private float width;
    private float height;
    private float rotation;

    private BufferedImage image;
    private final String name;

    public Sprite(Vector2 position, float width, float height, float rotation, float depth, String imageLocation, String name) {
       this(position, width, height, rotation, depth, imageLocation, name, true);
    }

    public Sprite(Vector2 position, float width, float height, float rotation, float depth, BufferedImage image, String name) {
        this.image = image;

        this.position = new Vector2(position);
        this.width = width;
        this.height = height;
        this.rotation = rotation;
        this.depth = depth;

        this.name = name;
    }

    public Sprite(Vector2 position, float width, float height, float rotation, float depth, String imageLocation, String name, boolean lockAspect) {
        try {
            image = ImageIO.read(new File(imageLocation));
        } catch (IOException e) {
            System.err.println("Sprite image loading failed. Either image not found or data corrupted! Image location: " + imageLocation);
            e.printStackTrace();
        }

        this.position = new Vector2(position);
        this.width = width;
        this.height = height;
        this.rotation = rotation;
        this.depth = depth;

        this.name = name;

        if (lockAspect) {

            if (image.getWidth() > image.getHeight()) {
                float aspect = (float) image.getHeight() / (float) image.getWidth();
                System.out.println("Sprite aspect is: " + aspect);
                this.height *= aspect;
            } else {
                float aspect = (float) image.getWidth() / (float) image.getHeight();
                System.out.println("Sprite aspect is: " + aspect);
                this.width *= aspect;
            }

        }
    }

    public float getDepth() {
        return depth;
    }

    public Vector2 getPosition() {
        return new Vector2(position);
    }

    public void setPosition(Vector2 newPosition) {
        position = new Vector2(newPosition);
    }

    public void setPosition(float x, float y) {
        position = new Vector2(x, y);
    }

    public void setX(float x) {
        position.x = x;
    }

    public void setY(float y) {
        position.y = y;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getRotation() {
        return rotation;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    public void rotate(float amount) {
        rotation += amount;
    }

    public BufferedImage getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public void setDepth(float depth) {
        this.depth = depth;
    }

    public void draw() {
        Renderer.getInstance().drawPrimitive(this);
    }

    @Override
    public void doDraw(Graphics2D g2) {
        float xTransform = getPosition().x;// - (int)(spr.getWidth()/2.0f);
        float yTransform = getPosition().y;// - (int)(spr.getHeight()/2.0f);

        float xTransform2 = -(getWidth()/2.0f);
        float yTransform2 = -(getHeight()/2.0f);

        g2.translate(xTransform, yTransform);
        g2.rotate(getRotation());
        g2.translate(xTransform2, yTransform2);

        g2.drawImage(getImage(), 0, 0, (int)getWidth(), (int)getHeight(), null);

        g2.translate(-xTransform2, -yTransform2);
        g2.rotate(-getRotation());
        g2.translate(-xTransform, -yTransform);
    }
}
