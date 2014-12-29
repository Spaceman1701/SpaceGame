package com.x2a;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Ethan on 12/28/2014.
 */
public class DrawPanel extends JPanel{

    private int xRes;
    private int yRes;

    public DrawPanel(int xRes, int yRes) {
        this.xRes = xRes;
        this.yRes = yRes;

        setFocusable(true);
        requestFocusInWindow();
        setPreferredSize(new Dimension(xRes, yRes));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.clearRect(0, 0, getWidth(), getHeight());

        g2.translate(getWidth()/2, getHeight()/2);

        g2.setColor(Color.BLUE);
        g2.fillRect(-getWidth()/4,-getHeight()/4, getWidth()/2, getHeight()/2);
    }
}
