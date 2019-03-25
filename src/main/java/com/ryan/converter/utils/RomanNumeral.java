package com.ryan.converter.utils;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public enum RomanNumeral {
    /**
     * Enumeration of Roman Numeral Mappings.
     */
    I(1),
    IV(4),
    V(5),
    IX(9),
    X(10),
    XL(40),
    L(50),
    XC(90),
    C(100),
    CD(400),
    D(500),
    CM(900),
    M(1000),
    UNKNOWN_NUM(-1);


    private int value;
    private static Map<Integer, RomanNumeral> romanNumerals = new HashMap<>();

    RomanNumeral(int value) { this.value = value; }

    static {
        for (RomanNumeral romanNumeral : RomanNumeral.values()) {
            romanNumerals.put(romanNumeral.value, romanNumeral);
        }
    }

    /**
     * Gets the RomanNumeral that corresponds to the specified int value.
     *
     * @param value The integer of the roman numeral.
     * @return The RomanNumeral that corresponds to the specified integer.
     */
    public static RomanNumeral valueOf(int value) { return romanNumerals.getOrDefault(value, UNKNOWN_NUM); }

    /**
     * Finds the closest RomanNumeral that is less than or equal to value.
     *
     * @param value The value to find closest roman numeral for.
     * @return The RomanNumeral that is closest to parameter (return <= value).
     */
    public static RomanNumeral findClosest(int value) throws NoSuchElementException {
        if (valueOf(value) != UNKNOWN_NUM) return  valueOf(value);

        return valueOf(romanNumerals
                .keySet()
                .stream()
                .filter(x -> (x < value) && (x != UNKNOWN_NUM.value))
                .max(Comparator.comparing(Integer::valueOf))
                .orElseThrow(NoSuchElementException::new));
    }

    /**
     * Gets the integer value for a specific RomanNumeral.
     *
     * @return The integer value of the roman numeral.
     */
    public int value() { return this.value; }

    /**
     * Converts RomanNumeral to a string
     *
     * @return The string representing the roman numeral
     */
    public String toString() {
        switch (this) {
            case I:
                return ConverterConstants.I;
            case IV:
                return ConverterConstants.IV;
            case V:
                return ConverterConstants.V;
            case IX:
                return ConverterConstants.IX;
            case X:
                return ConverterConstants.X;
            case XL:
                return ConverterConstants.XL;
            case L:
                return ConverterConstants.L;
            case XC:
                return ConverterConstants.XC;
            case C:
                return ConverterConstants.C;
            case CD:
                return ConverterConstants.CD;
            case D:
                return ConverterConstants.D;
            case CM:
                return ConverterConstants.CM;
            case M:
                return ConverterConstants.M;
            default:
                throw new NoSuchElementException();
        }
    }
}
