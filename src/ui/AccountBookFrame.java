package ui;

import tools.Out;
import tools.SettingFile;
import tools.Tools;
import ui.base.MFrame;
import ui.base.TitlePanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * GUI类的主类, 本类对象构造了程序的主窗口.
 * <p>
 * 实例化这个类的对象会创建一个本项目的窗体.
 *
 * @author Max
 * @version 1.0.0
 */
public class AccountBookFrame extends MFrame {

    int ScreenWidth = Integer.parseInt(SettingFile.get("ScreenWidth"));
    int ScreenHeight = Integer.parseInt(SettingFile.get("ScreenHeight"));



    public AccountBookFrame(){
        super(new ImageIcon("./resource/titleIcon.png"));
        this.setTitle(SettingFile.get("Title"));
        //设置非全屏时的窗体大小
        int frameWidth = ScreenWidth /4 * 3;
        int frameHeight = ScreenHeight / 4 * 3;
        this.setSize(frameWidth,frameHeight);
        int frameX = (ScreenWidth - this.getWidth()) / 2;
        int frameY = (ScreenHeight - this.getHeight()) / 2;
        this.setLocation(frameX, frameY);

        //最大化
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
        this.redrawAll();
        this.updateIsFullScreen();

    }

    @Override
    public void redrawAll(){
        titlePanel.redraw();
    }



}
