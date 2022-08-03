package com.lie.PlaneWars.swing;

import com.lie.PlaneWars.StaticData;
import com.lie.PlaneWars.entity.Plane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginFrame extends JFrame {
    private JLabel label = new JLabel();

    public LoginFrame(int x,int y) {
        //窗体可视化
        this.Label();
        this.setFrameself(x,y);
    }

    private void setFrameself(int x,int y) {
        this.setBounds(x, y, StaticData.Width, StaticData.Hight);
        this.setTitle("开始界面");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    public void Label() {
        //设置图片
        label.setIcon(new ImageIcon("./image//start.png"));
        this.add(label);
        //鼠标点击事件
        label.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getX() >= 100 && e.getX() <= 700 && e.getY() >= 340 && e.getY() <= 460) {
                    GameFrame.init();
                    StaticData.Plane = new Plane(StaticData.Width/2,500);
                    LoginFrame.this.setVisible(false);
                    new Thread(new GameFrame(LoginFrame.this.getX(),LoginFrame.this.getY())).start();
                }
                if (e.getX() >= 100 && e.getX() <= 700 && e.getY() >= 540 && e.getY() <= 660) {
                    LoginFrame.this.setVisible(false);
                    StaticData.Plane = new Plane(StaticData.Width/2,500);
                    new Thread(new GameFrame(LoginFrame.this.getX(),LoginFrame.this.getY())).start();
                }
                if (e.getX() >= 100 && e.getX() <= 700 && e.getY() >= 740 && e.getY() <= 860) {
                    LoginFrame.this.setVisible(false);
                    new ShopFrame(LoginFrame.this.getX(),LoginFrame.this.getY());
                }
            }
        });
        //鼠标移动事件
        label.addMouseMotionListener(new MouseAdapter() {
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                if ((e.getX() >= 100 && e.getX() <= 700 && e.getY() >= 540 && e.getY() <= 660) || (e.getX() >= 100 && e.getX() <= 700 && e.getY() >= 740 && e.getY() <= 860) || (e.getX() >= 100 && e.getX() <= 700 && e.getY() >= 340 && e.getY() <= 460)) {
                    label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                } else {
                    label.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                }
            }
        });
    }
}
