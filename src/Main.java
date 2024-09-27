import tools.*;
import ui.AccountBookFrame;

import java.util.Objects;

public final class Main {

    private Main(){}

    public static void main(String[] args){
        Out.println("Hallo Word");

        initSetting();
        new AccountBookFrame();
    }

    private static void initSetting(){

        //获得屏幕的宽高比
        int[] screenSize = Tools.getScreenSize();
        MColor.setColorStyle(Integer.parseInt(Objects.requireNonNull(SettingFile.get("ColorStyle"))));

        Log.printLogInFile();
    }
}
