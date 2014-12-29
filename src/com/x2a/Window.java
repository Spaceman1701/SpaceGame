package com.x2a;

import com.x2a.render.DrawPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ethan on 12/28/2014.
 */
public class Window {

    private static final double ONE_SECOND = 1000;

    private JFrame frame;
    private DrawPanel drawPanel;
    private double frameTime;

    public Window(int xRes, int yRes, int refreshRate) {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        drawPanel = new DrawPanel(xRes, yRes);
        frame.getContentPane().add(drawPanel);

        frame.pack();

        frameTime = ONE_SECOND/(double)refreshRate;


        frame.setVisible(true);
    }


    public void run() {
        System.out.println("Window run called");
        Timer updateTimer = new javax.swing.Timer((int)frameTime, new ActionListener() {

            private long lastTime;

            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println(Math.abs(System.nanoTime() - lastTime)/1000000.0); //Prints frame time in milliseconds

                drawPanel.repaint();

                lastTime = System.nanoTime();
            }
        });
        updateTimer.start();
    }
}
