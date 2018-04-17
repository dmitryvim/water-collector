package com.mikhaylovich.watercollector;

import java.util.Stack;

/**
 * Created by dmitry on 17.04.2018. ${PATH}
 */
public class LandscapeWalker {

    private Stack<LandscapePoint> stack = new Stack<LandscapePoint>();

    private int waterCount = 0;

    private int bottom = 0;


    public static int readLandscape(int... heights) {
        LandscapeWalker walker = new LandscapeWalker();
        for (int index = 0; index < heights.length; index++) {
            walker.addPoint(index, heights[index]);
        }
        return walker.getWaterCount();
    }

    public int addPoint(int position, int height) {
        return addPoint(new LandscapePoint(position, height));
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
        return !this.stack.empty();
    }

    private void collect(LandscapePoint point) {
        this.waterCount += point.collectWith(top(), this.bottom);
    }

    private LandscapePoint top() {
        return this.stack.peek();
    }

    private int getWaterCount() {
        return this.waterCount;
    }

    private int push(LandscapePoint point) {
        this.stack.push(point);
        this.bottom = point.getHeight();
        return this.waterCount;
    }
}
