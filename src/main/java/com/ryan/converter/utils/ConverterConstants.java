package com.ryan.converter.utils;

import java.util.HashMap;
import java.util.Map;

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
     * Roman Numeral String literals
     */
    public static String I = "I";
    public static String IV = "IV";
    public static String V = "V";
    public static String IX = "IX";
    public static String X = "X";
    public static String XL = "XL";
    public static String L = "L";
    public static String XC = "XC";
    public static String C = "C";
    public static String CD = "CD";
    public static String D = "D";
    public static String CM = "CM";
    public static String M = "M";


    /**
     * Accumulator to build Roman Numeral
     */
    public static String ROMAN_NMERAL_ACC = "";

}
