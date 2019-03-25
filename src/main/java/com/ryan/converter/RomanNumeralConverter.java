package com.ryan.converter;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import static com.ryan.converter.utils.ConverterConstants.*;

public class RomanNumeralConverter {

    public String toRoman(int number) {
        checkValidRange(number);
        return "String";
    }

    private void checkValidRange(int number) {
        if (number < MIN_NUM) throw new IllegalArgumentException(MIN_NUM_ERR);
        else if (number > MAX_NUM) throw new IllegalArgumentException(MAX_NUM_ERR);
    }

    public int fromRoman(String roman) {
        throw new NotImplementedException();
    }
}
