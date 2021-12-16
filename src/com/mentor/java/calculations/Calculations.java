package com.mentor.java.calculations;

import com.mentor.java.CalcException;

public class Calculations {
    private int n1;
    private int n2;

    public Calculations(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    public int sum() {
        return n1 + n2;
    }

    public int subtraction() {
        return n1 - n2;
    }

    public int multiplication() {
        return n1 * n2;
    }

    public int division() {
        return n1 / n2;
    }

    public int calculations(char operator) {
        int result;

        switch (operator) {
            case '+':
                result = sum();
                break;
            case '-':
                result = subtraction();
                break;
            case '*':
                result = multiplication();
                break;
            case '/':
                result = division();
                break;
            default:
                throw new CalcException("Не подходящий формат оператора " + operator +
                        ".\nОператор должен принимать только одно из 4 значений (+, -, /, *).");
        }
        return result;
    }
}
