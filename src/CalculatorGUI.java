import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame {

    private SpringLayout layout = new SpringLayout();
    private JPanel displayPanel, buttonPanel;
    private JTextField displayText;
    private JButton[] button;

    private double num1, num2, result;
    private char operator;

    public CalculatorGUI() {
        setTitle(config.WINDOW_NAME);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addUIComponents();
    }

    public void initialize() {
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
    }

    public void addUIComponents() {
        createDisplayFieldComponents();
        createButtonFieldComponents();
    }

    public void createDisplayFieldComponents(){
        displayPanel = new JPanel();
        displayPanel.setPreferredSize(new Dimension(config.DISPLAY_SIZE[0], config.DISPLAY_SIZE[1]));
        displayPanel.setLayout(layout);
        displayPanel.setBackground(Color.BLACK);

        displayText = new JTextField(config.TEXT_COLUMN);
        createTextField(displayText);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER, displayPanel, 0, SpringLayout.VERTICAL_CENTER, displayText);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, displayPanel, 10, SpringLayout.HORIZONTAL_CENTER, displayText);

        displayPanel.add(displayText);
        add(displayPanel, BorderLayout.NORTH);
    }

    public JTextField createTextField(JTextField textField) {
        textField.setEditable(false);
        textField.setFocusable(false);
        textField.setText("0");
        textField.setFont(config.TEXT_FONT);
        textField.setOpaque(false);
        textField.setBorder(null);
        textField.setForeground(config.TEXT_COLOR);
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        return textField;
    }

    public void createButtonFieldComponents(){
        buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(config.BUTTON_PANELSIZE[0], config.BUTTON_PANELSIZE[1]));
        buttonPanel.setBounds(0, 150, config.BUTTONFIELD_SIZE[0], config.BUTTONFIELD_SIZE[0]);
        buttonPanel.setBackground(Color.WHITE);

        buttonPanel.setBorder(config.BUTTON_BORDER);

        buttonPanel.setLayout(new GridLayout(config.BUTTON_ROW, config.BUTTON_COLUMN, config.BUTTON_HGAP, config.BUTTON_VGAP));
        button = new JButton[config.BTN_NUMBER];
        button = createButton(button, buttonPanel, config.BTN_NUMBER);

        for (int i = 0; i < config.BTN_NUMBER; i++) {
            keyPressedActions(button[i]);
        }

        add(buttonPanel, BorderLayout.SOUTH);
    }


    public JButton[] createButton(JButton[] btn, JPanel btnPannel, int btnCount) {
        for (int i = 0; i < btnCount; i++) {
            btn[i] = new JButton(config.BTN_TEXT[i]);
            btnPannel.add(button[i]);

            btn[i].setBackground(config.BUTTON_NUMBER_COLOR);
            btn[i].setFont(config.BUTTON_FONT);
            btn[i].setForeground(Color.WHITE);
            btn[i].setFocusable(false);
            btn[i].setBorder(null);

            if (i <= 2) {
                btn[i].setBackground(config.SPECIALBUTTON_COLOR);
            } else if (i == 3 || i == 7 || i == 11 || i == 15) {
                btn[i].setBackground(config.ARITHMETIC_COLOR);
                btn[i].setForeground(Color.BLACK);
            } else {
                btn[i].setBackground(config.NUMBER_COLOR);
                btn[i].setForeground(Color.BLACK);
            }
        }
        button[18].setPreferredSize(new Dimension(100, 100));
        return btn;
    }

    public JButton keyPressedActions(JButton button) {

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String keyCommands = e.getActionCommand();
                // Numerical Values
                if ("0123456789".contains(keyCommands)) {
                    if (displayText.getText().equals("0")) {
                        displayText.setText(keyCommands);
                    } else if (displayText.getText().equals("Error")) {
                        displayText.setText(keyCommands);
                    } else {
                        displayText.setText(displayText.getText() + keyCommands);
                    }
                }

                // Clear key
                if ("C".contains(keyCommands)) {
                    displayText.setText("0");
                    num1 = 0;
                    num2 = 0;
                    operator = '\0';
                }

                // Backspace key
                if ("←".contains(keyCommands)) {
                    displayText.setText(displayText.getText().substring(0, displayText.getText().length() -1));
                    if (displayText.getText().isEmpty()) {
                        displayText.setText("0");
                    }
                }

                // Decimal Key
                if (".".contains(keyCommands)) {
                    if (!displayText.getText().contains(".")) {
                        displayText.setText(displayText.getText() + ".");
                    }
                }

                // Arithmetic Operators
                if ("+-%÷×".contains(keyCommands)) {
                    if (!displayText.getText().equals("0")) {
                        num1 = Double.parseDouble(displayText.getText());
                        operator = keyCommands.charAt(0);
                        displayText.setText("0");
                    }
                }

                // Equal key
                if ("=".contains(keyCommands)) {
                    if (!displayText.getText().isEmpty()) {
                        num2 = Double.parseDouble(displayText.getText());

                        if (operator != '\0') {
                            switch (operator) {
                                case '+': result = num1 + num2; break;
                                case '-': result = num1 - num2; break;
                                case '×': result = num1 * num2;break;
                                case '%':
                                    if (num2 != 0) result = num1 % num2;
                                    else {
                                        displayText.setText("Error");
                                        return;
                                    }
                                    break;
                                case '÷':
                                    if (num2 != 0) result = num1 / num2;
                                    else {
                                        displayText.setText("Error");
                                        return;
                                    }
                                    break;
                            }
                            displayText.setText(String.valueOf(result));

                            if (result == (int) result) {
                                displayText.setText(String.valueOf((int)result));
                            } else {
                                displayText.setText(String.valueOf(result));
                            }
                            operator = '\0';
                            num1 = result;
                        } else {
                            if (num2 == (int) num2) {
                                displayText.setText(String.valueOf((int)num2));
                            } else {
                                displayText.setText(String.valueOf(num2));
                            }
                        }
                    }
                }
            }
        });

        return button;
    }



}
