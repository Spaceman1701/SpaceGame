package com.x2a;

import com.x2a.render.DrawPanel;
import com.x2a.scene.Camera;

import javax.swing.*;

/**
 * Created by Ethan on 12/28/2014.
 */
public class Window {



    private JFrame frame;
    private DrawPanel drawPanel;
    private double frameTime;

    public Window(int xRes, int yRes) {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        drawPanel = new DrawPanel(xRes, yRes);
        frame.getContentPane().add(drawPanel);

        frame.pack();

        frame.setVisible(true);
    }

    public void setCurrentCamera(Camera camera) {
        drawPanel.setCurrentCamera(camera);
    }

    public void run() {
        drawPanel.repaint();
    }
}
