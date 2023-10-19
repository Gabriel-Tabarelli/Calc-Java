package org.tabarelli;

public class OperationMath {

    private OperationMath() {}

    public static Double operationIsString(Double num1, String operation, Double num2) {
        switch (operation) {
            case "+" -> num1 = num1 + num2;
            case "-" -> num1 = num1 - num2;
            case "*" -> num1 = num1 * num2;
            case "/" -> num1 = num1 / num2;
        }
        return num1;
    }

}
