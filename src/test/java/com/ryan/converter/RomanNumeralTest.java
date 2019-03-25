package com.ryan.converter.utils;

import com.ryan.converter.utils.ConverterConstants;
import com.ryan.converter.utils.RomanNumeral;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import com.ryan.converter.utils.RomanNumeral.*;

import java.util.NoSuchElementException;

class RomanNumeralTest {

    @Test
    void valueOfSuccessfullyFindsRomanNumeral() {
        assertSame(RomanNumeral.valueOf(1), RomanNumeral.I);
        assertSame(RomanNumeral.valueOf(4), RomanNumeral.IV);
        assertSame(RomanNumeral.valueOf(5), RomanNumeral.V);
        assertSame(RomanNumeral.valueOf(9), RomanNumeral.IX);
        assertSame(RomanNumeral.valueOf(10), RomanNumeral.X);
        assertSame(RomanNumeral.valueOf(40), RomanNumeral.XL);
        assertSame(RomanNumeral.valueOf(50), RomanNumeral.L);
        assertSame(RomanNumeral.valueOf(90), RomanNumeral.XC);
        assertSame(RomanNumeral.valueOf(100), RomanNumeral.C);
        assertSame(RomanNumeral.valueOf(400), RomanNumeral.CD);
        assertSame(RomanNumeral.valueOf(500), RomanNumeral.D);
        assertSame(RomanNumeral.valueOf(900), RomanNumeral.CM);
        assertSame(RomanNumeral.valueOf(1000), RomanNumeral.M);
    }

    @Test
    void valueOfReturnsUnknownForUnknownInt() {
        assertSame(RomanNumeral.valueOf(2), RomanNumeral.UNKNOWN_NUM);
    }

    @Test
    void findLargestDivisibleFailsWithNoValue() {
        assertThrows(NoSuchElementException.class,
                () -> RomanNumeral.getLargest(0));

        assertThrows(NoSuchElementException.class,
                () -> RomanNumeral.getLargest(-1));
    }

    @Test
    void findLargestDivisibleIsSuccessful() {
        assertEquals(RomanNumeral.getLargest(3).value(), 1);

        // Get Exact Value
        assertEquals(RomanNumeral.getLargest(4).value(), 4);
        assertEquals(RomanNumeral.getLargest(90).value(), 90);

        // Get Largest Roman Numeral lower than value
        assertEquals(RomanNumeral.getLargest(401).value(), 400);
        assertEquals(RomanNumeral.getLargest(8).value(), 5);
    }

    @Test
    void testToString() {
        Assertions.assertEquals(RomanNumeral.CM.toString(), ConverterConstants.CM);
        assertEquals(RomanNumeral.IX.toString(), ConverterConstants.IX);
        assertThrows(NoSuchElementException.class,
                () -> RomanNumeral.UNKNOWN_NUM.toString());
    }
}
