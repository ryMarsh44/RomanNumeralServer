package com.ryan.converter;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.ryan.converter.RomanNumeralConverter;
import static com.ryan.converter.utils.ConverterConstants.*;
import com.ryan.converter.utils.RomanNumeral;



class RomanNumeralConverterTest {

    static class toRoman {

        @Test
        void failsWithNegativeNumber() {
            IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                    () -> new RomanNumeralConverter().toRoman(MIN_NUM - 1));

            assertTrue(thrown.getMessage().contains(MIN_NUM_ERR));
        }

        @Test
        void failsWithNumberBiggerThanMax() {
            IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                    () -> new RomanNumeralConverter().toRoman(MAX_NUM + 1));

            assertTrue(thrown.getMessage().contains(MAX_NUM_ERR));
        }

        @Test
        void returnsValidRomanNumeral() {
            RomanNumeralConverter converter = new RomanNumeralConverter();

            assertEquals(converter.toRoman(1), RomanNumeral.I.toString());

            assertEquals(converter.toRoman(36), "XXXVI");

            assertEquals(converter.toRoman(1000), RomanNumeral.M.toString());

            assertEquals(converter.toRoman(2012), "MMXII");

            assertEquals(converter.toRoman(1996), "MCMXCVI");

            assertEquals(converter.toRoman(3999), "MMMCMXCIX");
        }

    }

    static class fromRoman {
//        @Test
//        void failsWithInvalidRomanNumeral() {
//            IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
//                    () -> new RomanNumeralConverter().fromRoman("XXJ"));
//
//            assertTrue(thrown.getMessage().contains(MAX_NUM_ERR));
//        }
    }
}
