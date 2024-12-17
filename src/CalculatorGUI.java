import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class CalculatorGUI extends JFrame {

    private SpringLayout layout = new SpringLayout();
    private JPanel displayPanel, buttonPanel;
    private JTextField displayText;
    private JButton[] button;

    public CalculatorGUI() {
        setTitle(config.WINDOW_NAME);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addUIComponents();


    }

    public void initialize() {
        setVisible(true);
        pack();
    }

    public void addUIComponents() {
        createDisplayFieldComponents();
        createButtonFieldComponents();
    }

    public void createDisplayFieldComponents(){
        displayPanel = new JPanel();
        displayPanel.setPreferredSize(new Dimension(config.DISPLAY_SIZE[0], config.DISPLAY_SIZE[1]));
        displayPanel.setLayout(layout);
        displayPanel.setBackground(Color.WHITE);

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
        buttonPanel.setBounds(0, 150, 500, 500);
        buttonPanel.setBackground(Color.WHITE);

        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        buttonPanel.setLayout(new GridLayout(config.BUTTON_ROW, config.BUTTON_COLUMN, config.BUTTON_HGAP, config.BUTTON_VGAP));
        button = new JButton[config.BTN_NUMBER];
        createButton(button, buttonPanel, config.BTN_NUMBER);

        add(buttonPanel, BorderLayout.SOUTH);
    }


    public JButton[] createButton(JButton[] btn, JPanel btnPannel, int btnCount) {
        btn = new JButton[btnCount];
        for (int i = 0; i < btnCount; i++) {
            button[i] = new JButton(config.BTN_TEXT[i]);
            btnPannel.add(button[i]);

            button[i].setBackground(config.BUTTON_NUMBER_COLOR);
            button[i].setFont(new Font("Lucida Console", Font.BOLD, 30));
            button[i].setForeground(Color.WHITE);
            button[i].setFocusable(false);
            button[i].setBorder(null);


            if (i <= 2) {
                button[i].setBackground(new Color(128,128,128,255));
            } else if (i == 3 || i == 7 || i == 11 || i == 15) {
                button[i].setBackground(new Color(234,150,57,255));
                button[i].setForeground(Color.BLACK);
            } else {
                button[i].setBackground(new Color(229,229,229,255));
                button[i].setForeground(Color.BLACK);
            }

        }

        button[18].setPreferredSize(new Dimension(100, 100));


        return btn;
    }






}
