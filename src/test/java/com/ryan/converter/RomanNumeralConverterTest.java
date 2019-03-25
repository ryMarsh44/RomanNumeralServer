package com.ryan.converter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.ryan.converter.RomanNumeralConverter;
import static com.ryan.converter.utils.ConverterConstants.*;


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


    }

    @Test
    void failsWithNumberLargerThanMax() {
    }

    @Test
    void fromRoman() {
    }
}
