package org.tabarelli;

import javax.swing.JButton;

public class BottonHandler {

    private static Double firstNumber;
    private static Double secondNumber;
    private static String operator;

    public static void setActionNumbers(JButton button) {
        button.addActionListener(e -> {
            if (operator != null && firstNumber != null) {
                GUI.setDisplay(button.getText());
                secondNumber = Double.parseDouble(GUI.getDisplay());
            } else {
                if (firstNumber == null) GUI.clearDisplay();
                GUI.setDisplay(button.getText());
                firstNumber = Double.parseDouble(GUI.getDisplay());
            }
        });
    }

    public static void setActionOperators(JButton button) {
        button.addActionListener(e -> {
            if (button.getText().equals("C")) restartCalc();
            else if (operator != null || button.getText().equals("=")) doAction();
            else {
                operator = button.getText();
                GUI.clearDisplay();
            }
        });
    }

    public static void doAction() {
        if (secondNumber == null) return;
        secondNumber = OperationMath.operationIsString(firstNumber, operator, secondNumber);
        firstNumber = null;
        operator = null;
        GUI.clearDisplay();
        GUI.setDisplay(secondNumber.toString());
    }

    public static void restartCalc() {
        firstNumber = null;
        secondNumber = null;
        operator = null;
        GUI.clearDisplay();
    }

}
