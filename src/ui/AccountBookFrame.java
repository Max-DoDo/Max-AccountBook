package ui;

import tools.Tools;

import javax.swing.*;
import java.awt.*;

/**
 * <p>
 * GUI类的主类, 本类对象构造了程序的主窗口.
 * <p>
 * 实例化这个类的对象会创建一个本项目的窗体.
 *
 * @author Max
 * @version 1.0.0
 */
public class AccountBookFrame extends JFrame {

    public AccountBookFrame(){

        this.setVisible(true);
        //设置退出按钮
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //设置非全屏时的窗体大小
        this.setBounds(0, 0, 500, 1100);

        //最大化
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }


}
