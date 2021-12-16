package com.mentor.java.converter;

import com.mentor.java.CalcException;

public class ConverterInArabic {

    private static final String[] numbersToX = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    private static final String[] numbersToC = {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private static final String[] numbersToM = {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private static final String[] numbersToMM = {"M", "MM", "MMM"};
    private static String[][] romans = {numbersToX, numbersToC, numbersToM, numbersToMM};

    private static String[][] getRomans() {
        return romans;
    }

    public static String convertFromArabicToRoman(int num) {
        if (num < 1) {
            throw new CalcException("В римской системе нет отрицательных чисел или чисел равных 0");
        }

        StringBuilder sb = new StringBuilder();
        int k = 0;
        while (num > 0) {
            int digit = num % 10;//0....9
            num /= 10;

            if (digit > 0) {
                sb.insert(0, romans[k][digit - 1]);
            }
            k++;
        }
        return sb.toString();
    }
}
