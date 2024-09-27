package tools;

import java.awt.*;

public final class MColor {

    public static final int LIGHT_STYLE = 0;
    public static final int DARK_STYLE = 1;
    public static final int USER_DEFINE_STYLE = -1;

    /**
     * 存储当前的颜色模式
     */
    public static int colorStyle;

    /**
     * 普通按钮选中颜色
     */
    public static Color BUTTON_ROLLOVER;

    public static Color BUTTON_ROLLOVER1;

    /**
     * 普通按钮点击时颜色
     */
    public static Color BUTTON_PRESSING;

    public static Color BUTTON_PRESSING1;

    public static Color LINE;

    public static Color FONT;

    public static Color MAIN_PANEL;

    public static Color TITLE_PANEL;

    public static Color SIDE_PANEL;



    /**
     * 设置颜色模式. 这将会影响所有静态颜色的值
     * @param style 颜色模式常数. 详见{@link MColor#colorStyle}
     */
    public static void setColorStyle(int style){

        colorStyle = style;

        switch (style) {
            case DARK_STYLE -> darkStyle();
            case LIGHT_STYLE -> lightStyle();
            case USER_DEFINE_STYLE -> userDefineStyle();
        }
    }

    private static void darkStyle() {
        LINE = new Color(82, 82, 82);
        FONT = new Color(214, 214, 214);

        MAIN_PANEL = new Color(41, 41, 41);
        TITLE_PANEL = new Color(10, 10, 10);
        SIDE_PANEL = new Color(41, 41, 41);

        BUTTON_PRESSING = new Color(8, 35, 56);
        BUTTON_PRESSING1 = new Color(82,82,82);

        BUTTON_ROLLOVER = new Color(46, 46, 46);
        BUTTON_ROLLOVER1 = new Color(51,51,51);

    }

    private static void lightStyle(){

    }

    private static void userDefineStyle(){

    }
}
