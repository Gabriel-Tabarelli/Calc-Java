package org.tabarelli;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    private static JTextField display;

    public GUI() {
        super("Calc");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel painel = new JPanel(new BorderLayout());

        display = new JTextField();
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);

        JPanel botoes = new JPanel(new GridLayout(4, 4));

        String[] labels = {
                "7", "8", "9", "+",
                "4", "5", "6", "-",
                "1", "2", "3", "*",
                "C", "0", "=", "/"
        };

        for (String label : labels) {
            JButton botao = new JButton(label);
            botao.setFont(new Font("Arial", Font.BOLD, 18));
            if (label.equals("C") || label.equals("=") || label.equals("+") || label.equals("-") || label.equals("*") || label.equals("/")) {
                botao.setBackground(new Color(230, 230, 230));
                BottonHandler.setActionOperators(botao);
            } else {
                botao.setBackground(new Color(250, 250, 250));
                BottonHandler.setActionNumbers(botao);
            }
            botoes.add(botao);
        }
        painel.add(display, BorderLayout.NORTH);
        painel.add(botoes, BorderLayout.CENTER);
        add(painel);

        setVisible(true);
    }

    public static void setDisplay(String display) {
        GUI.display.setText(GUI.display.getText() + display);
    }
    
    public static void clearDisplay() {
        display.setText("");
    }

    public static String getDisplay() {
        return display.getText();
    }
}
