package ui.base;

import tools.MColor;
import tools.Out;
import tools.SettingFile;

import javax.swing.*;

/**
 * <h2>
 *  个性化一点的JFrame. 这是所有本程序使用的Frame的共同超类
 * </h2>
 * <p>
 *  这个Frame取消了自带的标题栏, 并且自定义了一个标题栏. 让他的配色更加"现代"
 *
 * </p>
 *
 * @author Max
 * @version 1.0.0
 **/
public class MFrame extends JFrame {
    /**
     * 标题栏面板
     */
    public TitlePanel titlePanel;

    /**
     * 用于修改窗体大小的工具类
     */
    private ResizeAdapter resizeAdapter;

    /**
     * 检查窗体是否最大化
     */
    private boolean isFullScreen;

    /**
     * 默认的构造函数, 使用这个构造函数创建本类对象会创建一个没有标题文本或者图片的窗体
     */
    public MFrame(){

        titlePanel = new TitlePanel();
        init();
    }

    public MFrame(String titleText){

        titlePanel = new TitlePanel(titleText);
        init();
    }

    public MFrame(ImageIcon icon){
        titlePanel = new TitlePanel(icon);
        init();
    }

    public void setIcon(ImageIcon icon){
        titlePanel.setIcon(icon);
    }
    /**
     * 构造函数调用的初始化函数, 用于设置所有本类对象都相同的参数
     */
    private void init() {
        //设置退出按钮
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //去边框
        this.setUndecorated(true);

//        用于设置在窗体的边框取消后仍然可以拉伸
        resizeAdapter = new ResizeAdapter(this);

//        添加监听
        this.addMouseListener(resizeAdapter);
        this.addMouseMotionListener(resizeAdapter);

        //设置背景颜色
        this.getContentPane().setBackground(MColor.MAIN_PANEL);

        //使用绝对布局管理器
        this.setLayout(null);

        this.add(titlePanel);
    }

    /**
     * 让子窗体回调用的函数, 用来调整窗口的大小.
     * @param state 设置窗体状态的常量
     * @see JFrame#NORMAL
     */
    public void reState(int state) {
        this.setExtendedState(state);

        if (state == JFrame.NORMAL) {
            this.isFullScreen = false;

        }

        if (state == JFrame.MAXIMIZED_BOTH) {
            this.setLocation(0,0);
            this.isFullScreen = true;
        }
        this.repaint();
    }

    /**
     * 更新该窗体是否是全屏状态
     */
    public void updateIsFullScreen(){

        int oriWidth = Integer.parseInt(SettingFile.get("ScreenWidth"));
        int oriHeight = Integer.parseInt(SettingFile.get("ScreenHeight"));


        //这个表达式大概意思就是如果这个窗体的坐标不在0,0. 或者他的大小和初始化窗体时检测的屏幕大小不一致就将值置为false
        if(this.getX() == 0 && this.getY() == 0 &&
                this.getWidth() == oriWidth &&
                this.getHeight() == oriHeight){
            this.setFullScreen(true);
            return;
        }
        this.setFullScreen(false);

    }

    public boolean isFullScreen() {
        return isFullScreen;
    }

    public void setFullScreen(boolean isFullScreen){
        this.isFullScreen = isFullScreen;
    }

    public void redrawAll(){
    }

    public void exit(){
        Out.println("退出");
        System.exit(0);
    }

    @Override
    public void repaint(){
        super.repaint();
//        Out.println("rep");
        redrawAll();
    }

}
