import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Calculator().createAndShowGUI());
    }
}

class Calculator {
    private JFrame frame;
    private JTextField display;
    private String operator = "";
    private double num1 = 0;

    public void createAndShowGUI() {
        frame = new JFrame("Calculator");
        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("SansSerif", Font.BOLD, 20));

        JPanel buttonPanel = new JPanel(new GridLayout(4, 4, 5, 5));
        String[] buttons = {"7","8","9","/","4","5","6","*","1","2","3","-","0","C","=","+"};

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("SansSerif", Font.BOLD, 16));
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        frame.setLayout(new BorderLayout(5, 5));
        frame.add(display, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.setSize(300, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if ("0123456789".contains(command)) {
                display.setText(display.getText() + command);
            } else if ("+-*/".contains(command)) {
                if (!display.getText().isEmpty()) {
                    num1 = Double.parseDouble(display.getText());
                    operator = command;
                    display.setText("");
                }
            } else if ("=".equals(command)) {
                if (!display.getText().isEmpty() && !operator.isEmpty()) {
                    double num2 = Double.parseDouble(display.getText());
                    double result = 0;
                    switch (operator) {
                        case "+": result = num1 + num2; break;
                        case "-": result = num1 - num2; break;
                        case "*": result = num1 * num2; break;
                        case "/": result = (num2 != 0) ? num1 / num2 : Double.NaN; break;
                    }
                    display.setText(String.valueOf(result));
                    operator = "";
                }
            } else if ("C".equals(command)) {
                display.setText("");
                num1 = 0;
                operator = "";
            }
        }
    }
}
