package com.x2a.render;

import com.x2a.input.InputUtil;
import com.x2a.input.SafeInputUtil;
import com.x2a.scene.Camera;
import com.x2a.scene.Sprite;

import javax.swing.*;
import java.awt.*;
import java.util.TreeSet;

/**
 * Created by Ethan on 12/28/2014.
 */
public class DrawPanel extends JPanel{

    private int xRes;
    private int yRes;

    private Camera currentCamera;

    public DrawPanel(int xRes, int yRes) {
        this.xRes = xRes;
        this.yRes = yRes;

        addMouseListener(SafeInputUtil.getInstance());
        addMouseMotionListener(SafeInputUtil.getInstance());
        addMouseWheelListener(SafeInputUtil.getInstance());
        addKeyListener(SafeInputUtil.getInstance());

        setFocusable(true);
        requestFocusInWindow();
        setPreferredSize(new Dimension(xRes, yRes));
    }

    public void setCurrentCamera(Camera camera) {
        this.currentCamera = camera;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.clearRect(0, 0, getWidth(), getHeight());

        g2.translate(getWidth()/2, getHeight()/2);



        if (currentCamera != null) {
            g2.translate(-currentCamera.getPosition().x, -currentCamera.getPosition().y);
            g2.scale(1.0 / (double) currentCamera.getScale(), 1.0 / (double) currentCamera.getScale());
        } else {
            System.err.println("Camera is null. Probably hasn't been initialized yet. This is expected to occur twice. If it occurs every frame there is a problem. This message is from DrawPanel.paintComponent.");
        }

        for(Sprite spr : Renderer.getInstance().getSprites()) {
            drawSprite(spr, g2);
        }
        Renderer.getInstance().initSet();
    }

    private void drawSprite(Sprite spr, Graphics2D g2) {
        int xTransform = (int)spr.getPosition().x;// - (int)(spr.getWidth()/2.0f);
        int yTransform = (int)spr.getPosition().y;// - (int)(spr.getHeight()/2.0f);

        int xTransform2 = -(int)(spr.getWidth()/2.0f);
        int yTransform2 = -(int)(spr.getHeight()/2.0f);

        g2.translate(xTransform, yTransform);
        g2.rotate(spr.getRotation());
        g2.translate(xTransform2, yTransform2);

        g2.drawImage(spr.getImage(), 0, 0, (int)spr.getWidth(), (int)spr.getHeight(), null);

        g2.translate(-xTransform2, -yTransform2);
        g2.rotate(-spr.getRotation());
        g2.translate(-xTransform, -yTransform);
    }
}
