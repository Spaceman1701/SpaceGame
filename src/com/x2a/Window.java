package com.x2a;

import com.x2a.input.KeyEventData;
import com.x2a.input.KeyEventListener;
import com.x2a.input.KeyEventType;
import com.x2a.input.SafeInputUtil;
import com.x2a.render.DrawPanel;
import com.x2a.scene.Camera;

import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * Created by Ethan on 12/28/2014.
 */
public class Window {



    private JFrame frame;
    private DrawPanel drawPanel;
    private double frameTime;

    public Window(int xRes, int yRes, boolean fullScreen) {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        drawPanel = new DrawPanel(xRes, yRes);
        frame.getContentPane().add(drawPanel);

        if (fullScreen) {
            frame.setUndecorated(true);
        }


        frame.pack();

        frame.setVisible(true);


        SafeInputUtil.getInstance().registerKeyEventListener(new KeyEventListener() {
            @Override
            public void onKeyEvent(KeyEventData data) {
                if (data.getEventType() == KeyEventType.KEY_PRESSED && data.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    System.exit(0);
                }
            }
        });


    }

    public void setCurrentCamera(Camera camera) {
        drawPanel.setCurrentCamera(camera);
    }

    public void run() {
        drawPanel.repaint();
    }
}
