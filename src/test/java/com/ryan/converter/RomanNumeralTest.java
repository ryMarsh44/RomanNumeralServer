package com.ryan.converter.utils;

import com.ryan.converter.utils.ConverterConstants;
import com.ryan.converter.utils.RomanNumeral;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


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
                () -> RomanNumeral.findClosest(0));

        assertThrows(NoSuchElementException.class,
                () -> RomanNumeral.findClosest(-1));
    }

    @Test
    void findLargestDivisibleIsSuccessful() {
        assertEquals(RomanNumeral.findClosest(3).number(), 1);

        // Get Exact Value
        assertEquals(RomanNumeral.findClosest(4).number(), 4);
        assertEquals(RomanNumeral.findClosest(90).number(), 90);

        // Get Largest Roman Numeral lower than number
        assertEquals(RomanNumeral.findClosest(401).number(), 400);
        assertEquals(RomanNumeral.findClosest(8).number(), 5);
    }

    @Test
    void testToString() {
        assertEquals(RomanNumeral.CM.toString(), "CM");
        assertEquals(RomanNumeral.IX.toString(), "IX");
        assertEquals(RomanNumeral.UNKNOWN_NUM.toString(), "Unknown Number");
    }

    @Test
    void validateRomanNumeralIsFalseWithInvalidStr() {
        assertEquals(RomanNumeral.validRomanNumeralCharacter("J"), false);
        assertEquals(RomanNumeral.validRomanNumeralCharacter("CMZ"), false);
        assertEquals(RomanNumeral.validRomanNumeralCharacter("IITI"), false);
    }

    @Test
    void validateRomanNumeralReturnsTrueWithValidStr() {
        assertEquals(RomanNumeral.validRomanNumeralCharacter("MCMDCDCXCLXL"), true);
        assertEquals(RomanNumeral.validRomanNumeralCharacter("XLLXCCCDDCMM"), true);
    }
}
