package com.x2a.math.sat;

import com.x2a.math.Vector2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 12/28/2014.
 */
public class ConvexHull {

    public class ConvexHullException extends Exception {

    }

    private ConvexHull(List<Vector2> outerPoints) {

    }

    public static ConvexHull createConvexHull(List<Vector2> points) {

        System.out.println("Orginal Points");
        points.forEach((Vector2 v) -> System.out.println(v));

        //Dispose of any equivalent points
        for (int i = 0; i < points.size(); i++) {
            for (int j = 0; j < points.size(); j++) {
                if (i != j && points.get(i).equals(points.get(j))) {
                    points.remove(j);
                    if (i > j) {
                        i--;
                    }
                    j--;
                }
            }
        }

        System.out.println("Final Points");
        points.forEach((Vector2 v) -> System.out.println(v));

        return null;
    }

    public static void main(String[] args) {
        List<Vector2> points = new ArrayList<Vector2>();
        points.add(new Vector2(1f, 2f));
        points.add(new Vector2(1.000001f, 2f));
        points.add(new Vector2(3f, 2f));
        points.add(new Vector2(6f, 20f));
        points.add(new Vector2(6.0000001f, 20f));
        points.add(new Vector2(6.0000001f, 20f));

        createConvexHull(points);

    }
}
