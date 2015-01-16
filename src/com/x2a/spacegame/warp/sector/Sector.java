package com.x2a.spacegame.warp.sector;

import com.x2a.math.Vector2;
import com.x2a.scene.Camera;
import com.x2a.scene.Node;
import com.x2a.spacegame.warp.MapPlanet;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by Ethan on 1/13/2015.
 */
public class Sector {

    private static final int NUMBER_PLANETS = 10;

    private Set<MapPlanet> planets;

    private final Vector2 position;
    private final int size;
    private final long seed;

    public Sector(Vector2 position, int size, long seed, Camera camera) {
        this.position = new Vector2(position);
        this.size = size;
        this.seed = seed;

        generatePlanets(camera);
    }

    private void generatePlanets(Camera camera) {
        planets = new HashSet<MapPlanet>();

        Random random = new Random(seed);

        for (int i = 0; i< NUMBER_PLANETS; i++) {
            Vector2 pos = new Vector2(random.nextInt(768)-(768/2), random.nextInt(768)-(768/2));
            MapPlanet p = new MapPlanet(pos, i, camera);
            planets.add(p);
        }
    }

    public void update(float timeElapsed) {
        for (MapPlanet p : planets) {
            p.update(timeElapsed);
            p.draw();
        }
    }

    public Set<MapPlanet> getPlanets() {
        return planets;
    }
}
