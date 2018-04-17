package com.mikhaylovich.watercollector;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by dmitry on 17.04.2018. ${PATH}
 */
public class LandscapeWalkerTest {

    @Test
    public void addPoint() {
        // given
        LandscapeWalker walker = new LandscapeWalker();

        // expect
        assertEquals(0, walker.addPoint(0, 3));
        assertEquals(0, walker.addPoint(1, 1));
        assertEquals(2, walker.addPoint(2, 5));
        assertEquals(2, walker.addPoint(3, 7));
        assertEquals(2, walker.addPoint(4, 2));
        assertEquals(5, walker.addPoint(5, 5));
    }

    @Test
    public void commonLandscape() {
        // .2.
        // .1.
        // ...
        // 313
        assertEquals(2, LandscapeWalker.readLandscape(3, 1, 3));
    }

    @Test
    public void upstairsLandscape() {
        // .
        // .7890123.
        // .456.....
        // .23......
        // .1.......
        // 501233334
        assertEquals(13, LandscapeWalker.readLandscape(5, 0, 1, 2, 3, 3, 3, 3, 4));
    }

    @Test
    public void downstairsLandscape() {
        //         .
        //         .
        //         .
        //       ...
        // .12345...
        // ...678...
        // .....9...
        // .....0...
        // .........
        // 544331669
        assertEquals(10, LandscapeWalker.readLandscape(5, 4, 4, 3, 3, 1, 6, 6, 9));
    }

    @Test
    public void longLandscape() {
        //            .45678901.
        // .1.456.123...234567..
        // .2...7.0.....89012...
        // .3...8.9.......34....
        // .....................
        // 414331413345422112345
        assertEquals(34, LandscapeWalker.readLandscape(4, 1, 4, 3, 3, 1, 4, 1, 3, 3, 4, 5, 4, 2, 2, 1, 1, 2, 3, 4, 5));
    }
}