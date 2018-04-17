package com.mikhaylovich.watercollector;

/**
 * Created by dmitry on 17.04.2018. ${PATH}
 */
public class LandscapePoint {
    private final int position;

    private final int height;

    public LandscapePoint(int position, int height) {
        this.position = position;
        this.height = height;
    }

    public int getPosition() {
        return position;
    }

    public int getHeight() {
        return height;
    }

    public int collectWith(LandscapePoint prev, int bottom) {
        return (this.position - prev.position - 1) * (Math.min(this.height, prev.height) - bottom);
    }
}
