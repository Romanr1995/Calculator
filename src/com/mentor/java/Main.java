package com.mentor.java;

import com.mentor.java.calculations.Calculations;
import com.mentor.java.converter.ConverterInArabic;
import com.mentor.java.converter.ConverterInRoman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] s = bufferedReader.readLine().split(" ");
        if (s.length != 3) {
            throw new CalcException("Данная строка не является математической операцией.\n" +
                    "Должно быть два операнда и один оператор (+, -, /, *),вставленных через пробел");
        }
        String operand1 = s[0];
        String operator = s[1];
        String operand2 = s[2];

        char operatorChar;
        if (operator.length() != 1) {
            throw new CalcException("Оператор должен содержать только 1 символ (+, -, /, *)");
        } else {
            operatorChar = operator.toCharArray()[0];
        }

        List<Integer> list = ConverterInRoman.converterToRomanNumbers(operand1, operand2);
        Calculations calc = new Calculations(list.get(0), list.get(1));
        int result = calc.calculations(operatorChar);

        if (ConverterInRoman.isIsArabic()) {
            System.out.println(result);
        } else {
            System.out.println(ConverterInArabic.convertFromArabicToRoman(result));
        }
    }
}
