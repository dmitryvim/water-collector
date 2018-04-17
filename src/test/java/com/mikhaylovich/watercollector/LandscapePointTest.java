package com.mikhaylovich.watercollector;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author dmitry.mikhailovich@gmail.com
 */
public class LandscapePointTest {

    @Test
    public void collectWith() throws Exception {
        // given
        int bottom = 5;

        // when
        LandscapePoint first = new LandscapePoint(1, 12);
        LandscapePoint second = new LandscapePoint(2, 8);
        LandscapePoint third = new LandscapePoint(5, 14);
        LandscapePoint forth = new LandscapePoint(10, 10);

        // then
        assertEquals(0, second.collectWith(first, bottom));
        assertEquals((5 - 2 - 1) * (8 - bottom), third.collectWith(second, bottom));
        assertEquals((10 - 5 - 1) * (10 - bottom), forth.collectWith(third, bottom));
    }

}