package com.ryan.converter.utils;

/**
 * Constants used by Roman Numeral Converter
 */
public class ConverterConstants {

    /**
     * range of convertible  (1 -> 3999)
     */
    public static int MIN_NUM = 1;
    public static int MAX_NUM = 3999;
    public static String MIN_NUM_ERR = "number is required to be greater than 0";
    public static String MAX_NUM_ERR = "number is required to be smaller than 3999";

    /**
     * Accumulator to build Roman Numeral
     */
    public static String ROMAN_NMERAL_ACC = "";

}
