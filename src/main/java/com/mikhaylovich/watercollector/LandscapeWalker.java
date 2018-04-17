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
        if (this.stack.empty()) {
            return push(point);
        }
        LandscapePoint top = this.stack.peek();
        if (top.getHeight() == point.getHeight()) {
            return push(point);
        }
        if (top.getHeight() > point.getHeight()) {
            return push(point);
        }
        do {
            top = this.stack.pop();
            this.waterCount += point.collectWith(top, this.bottom);
            this.bottom = top.getHeight();
        }
        while (!this.stack.empty() && this.stack.peek().getHeight() < point.getHeight());
        if (!this.stack.empty()) {
            this.waterCount += point.collectWith(this.stack.peek(), this.bottom);
        }
        return push(point);
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
