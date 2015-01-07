package com.x2a.math;

/**
 * Created by David on 12/28/2014.
 */
public class GameMath {

    public static float signedAngle(Vector2 a, Vector2 b) {
        return (float) Math.atan2(b.y, b.x) - (float) Math.atan2(a.y, a.x);
    }

    public static Vector2 polarToVector(float mag, float angle) {
        return new Vector2(mag * (float) Math.cos(angle), mag * (float) Math.sin(angle));
    }

    public static float getDistance(Vector2 a, Vector2 b) {
        return (float)Math.sqrt((a.x - b.x)*(a.x - b.x) + (a.y - b.y)*(a.y - b.y));
    }

    public static boolean insideAABB(Vector2 center, float width, float height, Vector2 point) {
        AxisAlignedBox aabb = new AxisAlignedBox(center, width, height);
        return aabb.pointInside(point);
    }

    public static int clamp(int a, int max, int min) {
        if (a > max) {
            return max;
        }
        if (a < min) {
            return min;
        }
        return a;
    }

    public static boolean betweenTwoValues(float value, float lower, float upper) {
        return (value < upper) && (value >= lower);
    }

    public static float convertToUnitRange(float value, float min, float max) {
        float newValue = (value - min) / (max - min);
        return newValue;
    }

}
