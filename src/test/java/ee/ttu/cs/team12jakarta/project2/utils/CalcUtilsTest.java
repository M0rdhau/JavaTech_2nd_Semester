package ee.ttu.cs.team12jakarta.project2.utils;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


public class CalcUtilsTest {

    @Test
    void maxOddTest() {
        assertNull(CalcUtils.maxOdd(List.of()));
        assertNull(CalcUtils.maxOdd(null));
        assertNull(CalcUtils.maxOdd(List.of(0)));
        assertNull(CalcUtils.maxOdd(List.of(2, 4, 6, 8)));

        assertEquals(7, CalcUtils.maxOdd(List.of(7)));
        assertEquals(7, CalcUtils.maxOdd(List.of(3, 5, 7)));
        assertEquals(-3, CalcUtils.maxOdd(List.of(-3, -5, -7)));
    }

    @Test
    void sumTest() {
        assertNull(CalcUtils.sum(List.of()));
        assertNull(CalcUtils.sum(null));

        assertEquals(0, CalcUtils.sum(List.of(0)));
        assertEquals(0, CalcUtils.sum(List.of(-5, -6, 5, 6, -10, 10)));

        assertEquals(100, CalcUtils.sum(List.of(5, 25, 40, 18, 12)));
    }

    @Test
    void absolutesTest() {
        assertNull(CalcUtils.absolutes(List.of()));
        assertNull(CalcUtils.absolutes(null));

        assertEquals(List.of(0), CalcUtils.absolutes(List.of(0)));
        assertEquals(List.of(1, 2, 3, 4, 5), CalcUtils.absolutes(List.of(-1, 2, -3, 4, -5)));
        assertEquals(List.of(1, 2, 3, 4, 5), CalcUtils.absolutes(List.of(1, 2, 3, 4, 5)));
        assertEquals(List.of(0, 5, 10, 20), CalcUtils.absolutes(List.of(0, -5, 10, -20)));
    }
}
