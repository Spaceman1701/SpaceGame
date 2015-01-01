package com.x2a.render;

import com.x2a.input.SafeInputUtil;
import com.x2a.scene.Camera;
import com.x2a.scene.Sprite;

import javax.swing.*;
import java.awt.*;

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

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.clearRect(0, 0, getWidth(), getHeight());
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, getWidth(), getHeight());

        g2.translate(getWidth()/2, getHeight()/2);



        if (currentCamera != null) {
            g2.scale(1.0 / (double) currentCamera.getScale(), 1.0 / (double) currentCamera.getScale());
            g2.translate(-currentCamera.getPosition().x, -currentCamera.getPosition().y);
        } else {
            System.err.println("Camera is null. Probably hasn't been initialized yet. This is expected to occur twice. If it occurs every frame there is a problem. This message is from DrawPanel.paintComponent.");
        }

        for (Primitive p : Renderer.getInstance().getPrimitives()) {
            p.doDraw(g2);
        }

        Renderer.getInstance().initSet();
    }
}
