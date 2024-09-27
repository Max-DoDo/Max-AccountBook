package ui.base;

import tools.Constant;
import tools.MColor;
import tools.Out;
import tools.SettingFile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TitlePanel extends JPanel implements ActionListener, MouseListener, MouseMotionListener {

    /**
     * 标题图标
     */
    private JButton titleIcon;

    /**
     * 标题文本
     */
    private JLabel titleText;
    /**
     * 最小化按钮
     */
    private TitleButton closeButton;

    /**
     * 切换大小按钮
     */
    private TitleButton resizeButton;

    private ImageIcon resizeIcon;

    private ImageIcon resizeIcon2;

    /**
     * 关闭按钮
     */
    private TitleButton exitButton;

    private ImageIcon exitIcon;

    private ImageIcon exitIcon2;

    /**
     * 设置按钮
     */
    private TitleButton settingButton;

    private int width;

    private int height;

    /**
     * 鼠标拖动定位用变量
     */
    private int newX,newY,oldX,oldY;

    /**
     * 鼠标拖动定位用变量
     */
    private int startX,startY;

    public TitlePanel(){
        init();
    }

    /**
     * 通过标题文本创建
     * @param title 显示的文本
     */
    public TitlePanel(String title) {
        this.initText(title);
        init();
    }

    /**
     * 通过标题图标创建
     * @param icon 标题图标
     */
    public TitlePanel(ImageIcon icon){
        this.initIcon(icon);
        this.initSettingButton();
        init();
    }

    private void init(){

        this.setLayout(null);
        this.setBackground(MColor.TITLE_PANEL);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);

        this.initButton();

    }

    private void initText(String title) {

        titleText = new JLabel(title);
        titleText.setFont(new Font(SettingFile.get("GlobalFont"),
                Font.PLAIN,
                Integer.parseInt(SettingFile.get("FontSize")) - 2));
        titleText.setLocation(10, 7);
        titleText.setSize(300, 30);

        this.add(titleText);
    }

    /**
     * 初始化最左边logo按钮的相关设置
     */
    private void initIcon(ImageIcon icon) {

        titleIcon = new JButton(icon);
        titleIcon.setLocation(10, 7);
        titleIcon.setSize(30, 30);

        //去掉按钮内部颜色填充
        titleIcon.setContentAreaFilled(false);

        //去掉按钮边框
        titleIcon.setBorderPainted(false);

        //设置监听
        titleIcon.addActionListener(this);
        this.add(titleIcon);

    }

    /**
     * 初始化设置按钮
     */
    private void initSettingButton() {

        //初始化和设置图标
        settingButton = new TitleButton(new ImageIcon(".\\resource\\settingIcon.png"));

        //设置背景颜色
        settingButton.setBackground(MColor.TITLE_PANEL);

        //去掉焦点和边框
        settingButton.setBorderPainted(false);
        settingButton.setFocusPainted(false);

        //设置监听
        settingButton.addActionListener(this);
        settingButton.addMouseListener(this);

        this.add(settingButton);
    }

    public void redraw(){
        width = this.getRootPane().getParent().getWidth();
        height = Constant.TITLE_PANEL_HEIGHT;
        this.setSize(width, height);

        /**
         * 重绘老三样的颜色,位置, 修改大小按钮的图标
         */
        //设置背景颜色
        closeButton.setBackground(MColor.TITLE_PANEL);
        resizeButton.setBackground(MColor.TITLE_PANEL);
        exitButton.setBackground(MColor.TITLE_PANEL);
        if (settingButton != null) {
            settingButton.setBackground(MColor.TITLE_PANEL);
        }

        //三个按钮 的高度和宽度是一样的
        int width = this.getHeight() + 10;
        int height = this.getHeight();
        int oriX = this.getWidth() - (3 * width);
        int y = 0;

        //设置位置
        closeButton.setLocation(oriX, y);
        resizeButton.setLocation(oriX + width, y);
        exitButton.setLocation(oriX + (width * 2), y);

        //设置大小
        closeButton.setSize(width, height);
        resizeButton.setSize(width, height);
        exitButton.setSize(width, height);

        //重绘修改大小按钮的图标
        MFrame mf = (MFrame) this.getRootPane().getParent();
        if (mf.isFullScreen()) {
            resizeButton.setIcon(resizeIcon);
        } else {
            resizeButton.setIcon(resizeIcon2);
        }

        //重绘退出按钮的图标
        exitButton.setIcon(exitIcon);

        redrawSettingButton();
    }

    private void redrawSettingButton(){
        int width = this.getHeight();
        int height = this.getHeight();

        settingButton.setBackground(MColor.TITLE_PANEL);
        //设置长和宽
        settingButton.setSize(width,height);
        //设置位置
        settingButton.setLocation(closeButton.getX() - width,0);
    }



    /**
     * 初始化右边老三样
     */
    private void initButton() {

        resizeIcon = new ImageIcon(".\\resource\\resizeIcon.png");
        resizeIcon2 = new ImageIcon(".\\resource\\resizeIcon2.png");
        exitIcon = new ImageIcon(".\\resource\\exitIcon.png");
        exitIcon2 = new ImageIcon(".\\resource\\exitIcon2.png");

        //设置图标
        Icon Icon = new ImageIcon(".\\resource\\closeIcon.png");
        closeButton = new TitleButton(Icon);
        resizeButton = new TitleButton(resizeIcon);
        exitButton = new TitleButton(exitIcon);

        //设置背景颜色
        closeButton.setBackground(MColor.TITLE_PANEL);
        resizeButton.setBackground(MColor.TITLE_PANEL);
        exitButton.setBackground(MColor.TITLE_PANEL);
        exitButton.setPressingColor(new Color(232,17,35));
        exitButton.setRolloverColor(new Color(232,17,35));

        //设置监听, 按键监听和鼠标移动的监听
        closeButton.addActionListener(this);
        closeButton.addMouseListener(this);

        resizeButton.addActionListener(this);
        resizeButton.addMouseListener(this);

        exitButton.addActionListener(this);
        exitButton.addMouseListener(this);

        //加到标题面板上
        this.add(closeButton);
        this.add(resizeButton);
        this.add(exitButton);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        String name = e.getActionCommand();

//        //标题logo
//        if (source.equals(titleIcon)) {
//            showTitleMenu();
//            return;
//        }

        //修改大小按钮
        if (source.equals(resizeButton)) {
            reSizeButtonClick();
            return;
        }

        //最小化按钮
        if (source.equals(closeButton)) {
            closeButtonClick();
            return;
        }

        //退出按钮
        if (source.equals(exitButton)) {
            exitButtonClick();
            return;
        }

        //设置按钮
        if(source.equals(settingButton)){
            settingButtonClick();
        }
    }

//    private void showTitleMenu() {
//    }

    private void reSizeButtonClick() {
        //获得主框架的引用
        MFrame mf = (MFrame) this.getRootPane().getParent();

        if(mf.isFullScreen()){
            mf.reState(JFrame.NORMAL);
        }else{
            mf.reState(JFrame.MAXIMIZED_BOTH);
        }
    }

    private void closeButtonClick() {
        MFrame mf = (MFrame) this.getRootPane().getParent();
        /*
         * 根据查阅到的资料, 在swing的窗体的用于ExtendedState常量中, 用二进制位来表示不同的情况.
         * 其中个位为0表示窗体打开, 1为关闭
         * 因此直接操作这个值 + 1就可以达到最小化的情况.
         * 另外因为最小化后用户一般情况下(至少我没发现)是不能再次单击这个按钮的. 而当用户通过点击应用的图标或者切屏啥的给切回来的时候
         * 这个加上的1因为状态的改变已经被swing自己减去了. 因此目前这样就很完美.
         * (之后遇到bug了再说)
         */
        mf.reState(mf.getExtendedState() + 1);

        //玄学操作
//        mf.setVisible(false);
//        mf.setVisible(true);


    }

    private void exitButtonClick() {
        MFrame mf = (MFrame) this.getRootPane().getParent();
        mf.exit();
    }

    private void settingButtonClick() {

    }

    public void setIcon(ImageIcon icon){
        titleIcon.setIcon(icon);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        Object source = e.getSource();

        if(source.equals(exitButton)){
            exitButton.setIcon(exitIcon2);
            return;
        }

        if(source.equals(this)){
            Component cp = (Component)source;
            MFrame mf = (MFrame) this.getRootPane().getParent();
            //当鼠标点下的时候记录组件当前的坐标与鼠标当前在屏幕的位置
            startX = mf.getX();
            startY = mf.getY();
            oldX = e.getXOnScreen();
            oldY = e.getYOnScreen();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Object source = e.getSource();
        if(source.equals(exitButton)){
            exitButton.setIcon(exitIcon);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    /**
     * 通过拖动鼠标来更改窗体的位置
     * @param e the event to be processed
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        Component cp = (Component)e.getSource();

        if(cp.equals(this)){

            MFrame mf = (MFrame) this.getRootPane().getParent();

            //拖动的时候记录新坐标
            newX = e.getXOnScreen();
            newY = e.getYOnScreen();
            //设置bounds,将点下时记录的组件开始坐标与鼠标拖动的距离相加
            mf.setLocation(startX+(newX - oldX),startY+(newY - oldY));
            mf.setFullScreen(false);

        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
