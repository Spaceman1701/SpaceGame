package com.x2a.render.image;

import com.x2a.render.DrawImage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Ethan on 12/31/2014.
 */
public class AnimatedImage implements DrawImage{
    private BufferedImage image;

    private int tileWidth;
    private int tileHeight;

    private int numberFrames;

    private int currentFrame;

    private int[] frameTimes;

    private int totalLoopTime;

    private int currentTime;

    /**
     *
     * @param image Entire sprite sheet
     * @param tileWidth width of one sprite on the sheet
     * @param tileHeight height of one sprite on the sheet
     * @param frameTimes time (in milliseconds) that each frame should display
     *
     *  Frames start at the top right and move to the bottom left
     */
    public AnimatedImage(BufferedImage image, int tileWidth, int tileHeight, int[] frameTimes) {
        this.image = image;

        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;

        this.numberFrames = frameTimes.length;
        this.frameTimes = frameTimes;

        totalLoopTime = 0;
        for (int i : frameTimes) {
            totalLoopTime += i;
        }

        currentTime = 0;
    }


    public static AnimatedImage loadAnimatedImage(File file, int tileWidth, int tileHeight, int[] frameTimes) throws IOException {
        BufferedImage image = ImageIO.read(file);
        return new AnimatedImage(image, tileWidth, tileHeight, frameTimes);
    }

    public static AnimatedImage loadAnimatedImage(File file, int tileWidth, int tileHeight, int numberFrames, int frameTime) throws IOException{
        int[] frameTimes = new int[numberFrames];
        Arrays.fill(frameTimes, frameTime);
        return loadAnimatedImage(file, tileWidth, tileHeight, frameTimes);
    }

    public StaticImage getSubImage(int subImage) {
        BufferedImage rawData = getRawSubImage(subImage);
        if (rawData != null) {
            return new StaticImage(rawData);
        }
        return null;
    }

    public BufferedImage getRawSubImage(int subImage) {
        if (subImage < numberFrames && subImage >= 0) {
            return image.getSubimage(subImage * tileWidth, subImage * tileHeight, tileWidth, tileHeight);
        }
        return null;
    }

    @Override
    public void draw(Graphics2D g2, float width, float height) {
        g2.drawImage(getRawSubImage(currentFrame), 0, 0, (int)width, (int)height, null);
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public void update(float timeElapsed) {
        if (currentTime > totalLoopTime) {
            currentTime = 0;
        }
        setCurrentFrame(getFrameFromTime(currentTime));
        currentTime += timeElapsed;
    }

    private int getFrameFromTime(float time) {
        for (int i = 0; i < frameTimes.length; i++) {
            time -= frameTimes[i];
            if (time <= 0) {
                return i;
            }
        }
        return 0;
    }

    public int getNumberFrames() {
        return numberFrames;
    }

    public int getCurrentFrame() {
        return currentFrame;
    }

    /**
     *
     * @param currentFrame
     *
     * Must override update for this to do anything
     */
    public void setCurrentFrame(int currentFrame) {
        this.currentFrame = currentFrame;
    }
}
