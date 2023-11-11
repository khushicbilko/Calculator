import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {

    // create a frame
    static JFrame frame;

    // create a textfield
    static JTextField textField;

    // store operator and operands
    String operator;
    String oldValue, newValue;

    // default constructor
    public Calculator()
    {
        operator = oldValue = newValue = "";
    }

    // main function
    public static void main(String args[])
    {
        // create a frame
        frame = new JFrame("calculator");

        try {
            // set look and feel
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }

        // create a object of class
        Calculator c = new Calculator();

        // create a textfield
        textField = new JTextField(16);

        // set the textfield to non editable
        textField.setEditable(false);

        // create number buttons and some operators
        JButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonAdd,
                buttonSub, buttonMul, buttonDiv, buttonClear, buttonEqual, buttonDot, buttonPercent;

        // create number buttons
        button0 = new JButton("0");
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");

        // equals button
        buttonEqual = new JButton("=");

        // create operator buttons
        buttonAdd = new JButton("+");
        buttonSub = new JButton("-");
        buttonMul = new JButton("*");
        buttonDiv = new JButton("/");
        buttonDot = new JButton(".");
        buttonPercent = new JButton("%");

        // create clear button
        buttonClear = new JButton("C");

        // create number buttons 0-9
        JButton[] numberButtons = { button0, button1, button2, button3, button4, button5, button6, button7, button8,
                button9 };

        // set action listeners
        for (int i = 0; i < 10; i++) {
            numberButtons[i].addActionListener(c);
        }

        // set action listeners for operator buttons
        buttonAdd.addActionListener(c);
        buttonSub.addActionListener(c);
        buttonMul.addActionListener(c);
        buttonDiv.addActionListener(c);
        buttonDot.addActionListener(c);
        buttonPercent.addActionListener(c);
        buttonClear.addActionListener(c);
        buttonEqual.addActionListener(c);

        // create . button
        buttonDot = new JButton(".");
        buttonDot.addActionListener(c);

        // create a panel
        JPanel panel = new JPanel();

        // add elements to panel
        panel.add(textField);
        panel.add(buttonAdd);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(buttonSub);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(buttonMul);
        panel.add(button7);
        panel.add(button8);
        panel.add(button9);
        panel.add(buttonDiv);
        panel.add(buttonDot);
        panel.add(button0);
        panel.add(buttonPercent);
        panel.add(buttonClear);
        panel.add(buttonEqual);

        // set Background of panel
        panel.setBackground(Color.blue);

        // add panel to frame
        frame.add(panel);

        frame.setSize(200, 220);
        frame.show();
    }

    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();

        if ((command.charAt(0) >= '0' && command.charAt(0) <= '9')) {
            textField.setText(textField.getText() + command);
            newValue = textField.getText();
        }
        else if (command.charAt(0) == 'C') {
            textField.setText("");
            oldValue = newValue = operator = "";
        }
        else if (command.charAt(0) == '=') {

            // store the result in text
            if (!newValue.equals("")) {
                switch (operator) {
                    case "+":
                        textField.setText(String.valueOf(Double.parseDouble(oldValue) + Double.parseDouble(newValue)));
                        break;
                    case "-":
                        textField.setText(String.valueOf(Double.parseDouble(oldValue) - Double.parseDouble(newValue)));
                        break;
                    case "*":
                        textField.setText(String.valueOf(Double.parseDouble(oldValue) * Double.parseDouble(newValue)));
                        break;
                    case "/":
                        textField.setText(String.valueOf(Double.parseDouble(oldValue) / Double.parseDouble(newValue)));
                        break;
                }

                // store the current value as oldValue
                // because oldValue will be used in the next iteration
                oldValue = textField.getText();
                newValue = operator = "";
            }
        }
        else {
            if (!operator.equals("")) {
                textField.setText(String.valueOf(Double.parseDouble(oldValue) + Double.parseDouble(newValue)));
                oldValue = textField.getText();
                newValue = operator = "";
            }

            operator = command;
            oldValue = textField.getText();
            textField.setText("");
        }
    }
}