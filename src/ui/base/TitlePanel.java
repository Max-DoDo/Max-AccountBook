package ui.base;

import javax.swing.*;
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
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
