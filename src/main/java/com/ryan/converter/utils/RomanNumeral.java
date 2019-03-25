package com.ryan.converter.utils;

import java.util.*;

public enum RomanNumeral {
    /**
     * Enumeration of Roman Numeral Mappings.
     */
    I("I", 1),
    IV("IV", 4),
    V("V", 5),
    IX("IX", 9),
    X("X", 10),
    XL("XL", 40),
    L("L", 50),
    XC("XC", 90),
    C("C", 100),
    CD("CD", 400),
    D("D", 500),
    CM("CM", 900),
    M("M", 1000),
    UNKNOWN_NUM("Unknown Number", -1);


    private int number;
    private String romanNumeral;
    private static Map<Integer, RomanNumeral> romanNumerals = new HashMap<>();
    private static HashSet<String> validRomanNumerals = new HashSet<>();

    RomanNumeral(String romanNumeral, int value) {
        this.romanNumeral = romanNumeral;
        this.number = value;
    }

    static {
        for (RomanNumeral romanNumeral : RomanNumeral.values()) {
            romanNumerals.put(romanNumeral.number, romanNumeral);
            validRomanNumerals.add(romanNumeral.toString());
        }
    }

    /**
     * Gets the RomanNumeral that corresponds to the specified int number.
     *
     * @param value The integer of the roman numeral.
     * @return The RomanNumeral that corresponds to the specified integer.
     */
    public static RomanNumeral valueOf(int value) { return romanNumerals.getOrDefault(value, UNKNOWN_NUM); }

    // Todo: This will be used when converting Roman Numeral to Number (Future)
    /**
     * Reports if string is valid roman numeral
     *
     * @return boolean indicating if string is a valid roman numeral
     */
    public static Boolean validRomanNumeralCharacter(String rn) {
        return !Arrays.stream(rn.split(""))
                .anyMatch(x -> !validRomanNumerals.contains(x));
    }

    /**
     * Finds the closest RomanNumeral that is less than or equal to number.
     *
     * @param value The number to find closest roman numeral for.
     * @return The RomanNumeral that is closest to parameter (return <= number).
     */
    public static RomanNumeral findClosest(int value) throws NoSuchElementException {
        if (valueOf(value) != UNKNOWN_NUM) return  valueOf(value);

        return valueOf(romanNumerals
                .keySet()
                .stream()
                .filter(x -> (x < value) && (x != UNKNOWN_NUM.number))
                .max(Comparator.comparing(Integer::valueOf))
                .orElseThrow(NoSuchElementException::new));
    }

    /**
     * Gets the integer number for a specific RomanNumeral.
     *
     * @return The integer number of the roman numeral.
     */
    public int number() { return this.number; }

    /**
     * Converts RomanNumeral to a string
     *
     * @return The string representing the roman numeral
     */
    public String toString() { return this.romanNumeral; }
}
