package com.x2a.spacegame.scenes.planet;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.Buffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ethan on 1/6/2015.
 */
public class TerrainTextureAtlas {

    private Map<String, WeakReference<BufferedImage>> images;


    public TerrainTextureAtlas() {
        images = Collections.synchronizedMap(new HashMap<String, WeakReference<BufferedImage>>());
    }

    public BufferedImage getImage(String location) {
        BufferedImage image = null;
        WeakReference<BufferedImage> ref = images.get(location);
        if (ref != null) {
            image = ref.get();
        }
        if (image == null) {
            try {
                image = ImageIO.read(new File(location));
                images.put(location, new WeakReference<BufferedImage>(image));
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }

        return image;
    }



}
