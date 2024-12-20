import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class config {

    public static final String WINDOW_NAME = "Calculator";

    public static final int[] DISPLAY_SIZE = {400, 150};


    public static final int TEXT_COLUMN = 6;
    public static final int TEXT_FONTSIZE = 60;
    public static final Color TEXT_COLOR = Color.WHITE;
    public static final Font TEXT_FONT = new Font("Consolas", Font.PLAIN, TEXT_FONTSIZE);

    // BUTTON CONFIGS
    public static final int[] BUTTON_PANELSIZE = {400, 500};
    public static final int BUTTON_ROW = 5;
    public static final int BUTTON_COLUMN = 4;
    public static final Font BUTTON_FONT = new Font("Lucida Console", Font.BOLD, 30);

    public static final int[] BUTTONFIELD_SIZE = {500, 500};
    public static final Border BUTTON_BORDER = BorderFactory.createEmptyBorder(20, 20, 20, 20);

    // BUTTON GAP
    public static final int BUTTON_HGAP = 20;
    public static final int BUTTON_VGAP = 20;

    // NUMBER OF BUTTONS
    public static final int BTN_NUMBER = 19;
    // BUTTON LABELS
    public static final String[] BTN_TEXT = {
            "←", "C", "%", "÷",
            "7", "8", "9","×",
            "4", "5", "6","-",
            "1", "2", "3", "+",
            "0", ".", "="
    };
    // BUTTON COLOR
    public static final Color BUTTON_NUMBER_COLOR = new Color(51,51,51,255);
    // SPECIAL BUTTON COLORS
    public static final Color SPECIALBUTTON_COLOR = new Color(128,128,128,255);
    // ARITHMETIC BUTTON COLOR
    public static final Color ARITHMETIC_COLOR = new Color(234,150,57,255);
    // NUMBER COLOR
    public static final Color NUMBER_COLOR = new Color(229, 229, 229, 255);
}
