package com.ryan.converter;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import static com.ryan.converter.utils.ConverterConstants.*;
import com.ryan.converter.utils.RomanNumeral;

public class RomanNumeralConverter {

    /**
     * Converts number to Roman Numeral
     *
     * @param number The integer of the roman numeral.
     * @return The String Roman Numeral that corresponds to the specified number.
     */
    public String toRoman(int number) {
        checkValidRange(number);
        return _toRomanHelper(number, ROMAN_NMERAL_ACC);
    }

    private String _toRomanHelper(int number, String romanNumeral) {
        if (number < MIN_NUM) { return romanNumeral; }
        RomanNumeral closestRomanNumeral = RomanNumeral.findClosest(number);
        return _toRomanHelper(
                number - closestRomanNumeral.number,
                romanNumeral + closestRomanNumeral.toString()
        );
    }

    /**
     * Ensures number passed to toRoman is between 1  && 3999 (1 <= number <= 3999)
     *
     * @param number The integer to ensure is in correct range
     * @throws IllegalArgumentException If number is not in range, IllegalArgumentException is thrown
     */
    private void checkValidRange(int number) {
        if (number < MIN_NUM) throw new IllegalArgumentException(MIN_NUM_ERR);
        else if (number > MAX_NUM) throw new IllegalArgumentException(MAX_NUM_ERR);
    }

    /**
     * Converts Roman Numeral to integer
     *
     * @param romanNumeral The roman numeral to be converted to integer.
     * @return The number that corresponds to the specified Roman Numeral.
     */
    public int fromRoman(String romanNumeral) {
        throw new NotImplementedException();
    }
}
