package org.harbu.search.util;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TwoDIndexConverterTest {

    private TwoDIndexConverter indexConverter;

    @Before
    public void setUp() {
        indexConverter = new TwoDIndexConverter(16);
    }

    @Test
    public void testTwoDTo1D() {
        assertEquals(5 * 16 + 11, indexConverter.twoDTo1D(5, 11));
    }

    @Test
    public void testOneDTo2D() {
        Coordinate expected = new Coordinate(13, 10);
        assertEquals(expected, indexConverter.oneDTo2D(173));
    }
}