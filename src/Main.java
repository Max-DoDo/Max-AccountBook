import tools.*;
import ui.AccountBookFrame;

import java.awt.*;
import java.util.Objects;

public final class Main {

    private Main(){}

    public static void main(String[] args){

        initSetting();
        new AccountBookFrame();

        test();
    }

    private static void initSetting(){

        //获得屏幕的宽高比
        int[] screenSize = Tools.getScreenSize();

        //写入配置文件
        SettingFile.set("ScreenWidth",String.valueOf(screenSize[0]));
        SettingFile.set("ScreenHeight", String.valueOf(screenSize[1]));

        MColor.setColorStyle(Integer.parseInt(Objects.requireNonNull(SettingFile.get("ColorStyle"))));

//        Log.printLogInFile();

        //初始化全局字体
        Tools.InitGlobalFont(new Font(SettingFile.get("GlobalFont"),
                Font.PLAIN,
                Integer.parseInt(Objects.requireNonNull(SettingFile.get("FontSize")))));
        Out.println("初始化设置");
    }

    private static void test(){

    }
}
