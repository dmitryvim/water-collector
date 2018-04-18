package com.mikhaylovich.watercollector;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author dmitry.mikhailovich@gmail.com
 */
public class LandscapeWalker {

    private Deque<LandscapePoint> stack = new ArrayDeque<>();

    private int waterCount = 0;

    private int bottom = 0;

    private int position = 0;


    public static int walkLandscape(int... heights) {
        LandscapeWalker walker = new LandscapeWalker();
        for (int heigth : heights) {
            walker.addHeight(heigth);
        }
        return walker.getWaterCount();
    }

    public int addHeight(int height) {
        return addPoint(new LandscapePoint(this.position++, height));
    }

    private int addPoint(LandscapePoint point) {
        while (stackNotEmpty() && top().getHeight() < point.getHeight()) {
            collect(point);
            this.bottom = this.stack.pop().getHeight();
        }
        if (stackNotEmpty()) {
            collect(point);
        }
        return push(point);
    }

    private boolean stackNotEmpty() {
        return !this.stack.isEmpty();
    }

    private void collect(LandscapePoint point) {
        this.waterCount += point.collectWith(top(), this.bottom);
    }

    private LandscapePoint top() {
        return this.stack.peek();
    }

    public int getWaterCount() {
        return this.waterCount;
    }

    private int push(LandscapePoint point) {
        this.stack.push(point);
        this.bottom = point.getHeight();
        return this.waterCount;
    }
}
