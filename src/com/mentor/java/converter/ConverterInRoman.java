package com.mentor.java.converter;

import com.mentor.java.CalcException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ConverterInRoman {

    private static Map<String, Integer> m = new TreeMap<>();
    private static boolean isArabic;

    static {
        for (int i = 1; i <= 100; i++) {
            try {
                m.put(ConverterInArabic.convertFromArabicToRoman(i), i);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static boolean isIsArabic() {
        return isArabic;
    }

    public ConverterInRoman() {
        for (int i = 1; i <= 100; i++) {
            try {
                m.put(ConverterInArabic.convertFromArabicToRoman(i), i);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Integer> converterToRomanNumbers(String number1, String number2) {
        List<Integer> integers = new ArrayList<>();
        if (m.containsKey(number1) && m.containsKey(number2)) {
            integers.add(m.get(number1));
            integers.add(m.get(number2));
            isArabic = false;
        } else if ((m.containsKey(number1) && !m.containsKey(number2))) {
            Integer integer = parseStringToInteger(number2);
            throw new CalcException("Используются одновременно разные системы счисления");
        } else if ((!m.containsKey(number1) && m.containsKey(number2))) {
            Integer integer = parseStringToInteger(number1);
            throw new CalcException("Используются одновременно разные системы счисления");
        } else {
            Integer integer1 = parseStringToInteger(number1);
            Integer integer2 = parseStringToInteger(number2);
            integers.add(integer1);
            integers.add(integer2);
            isArabic = true;
        }
        if (checkParametr(integers.get(0), integers.get(1))) {
            return integers;
        } else {
            throw new CalcException("Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более.");
        }
    }

    public static boolean checkParametr(Integer i1, Integer i2) {
        boolean isCorrectNumbers = false;
        if (i1 >= 1 && i1 <= 10) {
            if (i2 >= 1 && i2 <= 10) {
                return true;
            }
        }
        return isCorrectNumbers;
    }

    public static Integer parseStringToInteger(String parseString) {
        Integer integer;
        try {
            integer = Integer.parseInt(parseString);
        } catch (NumberFormatException numberFormatException) {
            throw new CalcException("Значение " + parseString + " должно принадлежать либо римским," +
                    "либо арабским целым числам больше 0.", numberFormatException);
        }
        return integer;
    }
}
