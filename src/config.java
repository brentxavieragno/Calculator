import java.awt.*;

public class config {

    public static final String WINDOW_NAME = "Calculator";

    public static final int[] DISPLAY_SIZE = {400, 150};


    public static final int TEXT_COLUMN = 6;
    public static final int TEXT_FONTSIZE = 80;
    public static final Color TEXT_COLOR = Color.BLACK;
    public static final Font TEXT_FONT = new Font("Lucida Console", Font.PLAIN, TEXT_FONTSIZE);

    public static final int[] BUTTON_PANELSIZE = {400, 500};
    public static final int BUTTON_ROW = 5;
    public static final int BUTTON_COLUMN = 4;

    public static final int BUTTON_HGAP = 20;
    public static final int BUTTON_VGAP = 20;

    public static final int BTN_NUMBER = 19;
    public static final String[] BTN_TEXT = {
            "←", "C", "%", "÷",
            "7", "8", "9","×",
            "4", "5", "6","-",
            "1", "2", "3", "+",
            "0", ".", "="
    };

    public static final Color BUTTON_NUMBER_COLOR = new Color(51,51,51,255);


}
