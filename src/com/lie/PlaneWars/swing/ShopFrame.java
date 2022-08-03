package com.lie.PlaneWars.swing;

import com.lie.PlaneWars.StaticData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ShopFrame extends JFrame{
    private JLabel label = new JLabel();
    public ShopFrame(int x,int y) {
        //窗体可视化
        this.Label();
        this.setFrameself(x,y);
    }

    private void setFrameself(int x,int y) {
        this.setBounds(x, y, StaticData.Width, StaticData.Hight);
        this.setTitle("商店");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    public void Label() {
        //设置图片
        label.setIcon(new ImageIcon("./image/shop.png"));
        this.add(label);
        //鼠标点击事件
        label.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(e.getX()>=100 && e.getX()<=700 && e.getY() >= 340 && e.getY() <=460){
                    if(StaticData.Coin >= 5 ) {
                        StaticData.Coin -= 5;
                        StaticData.PlaneHeathMax += 1;
                    }
                    FileOutputStream fos = null;
                    try {
                        fos = new FileOutputStream("data\\save.properties");
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                    Properties pro = new Properties();
                    pro.setProperty("Time","" + StaticData.Time);
                    pro.setProperty("Coin","" + StaticData.Coin);
                    pro.setProperty("Floor","" + StaticData.Floor);
                    pro.setProperty("PlaneHeath","" + StaticData.PlaneHeath);
                    pro.setProperty("PlaneHeathMax","" + StaticData.PlaneHeathMax);
                    pro.setProperty("PlaneArmor","" + StaticData.PlaneArmor);
                    pro.setProperty("PlaneArmorMax","" + StaticData.PlaneArmorMax);
                    pro.setProperty("BossHeath","" + StaticData.BossHeath);
                    pro.setProperty("BossHeathMax","" + StaticData.BossHeathMax);
                    pro.setProperty("BossTime","" + StaticData.BossTime);
                    try {
                        pro.store(fos,"测试数据");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    repaint();
                }
                if(e.getX()>=100 && e.getX()<=700 && e.getY() >= 540 && e.getY() <=660){
                    repaint();
                }
                if(e.getX()>=100 && e.getX()<=700 && e.getY() >= 740 && e.getY() <=860){
                    repaint();
                }
                if(e.getX()>=0 && e.getX()<=280 && e.getY() >= 110 && e.getY() <=210){
                    new LoginFrame(ShopFrame.this.getX(),ShopFrame.this.getY());
                    ShopFrame.this.setVisible(false);
                }
            }
        });
        //鼠标移动事件
        label.addMouseMotionListener(new MouseAdapter() {
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                if((e.getX()>=100 && e.getX()<=700 && e.getY() >= 540 && e.getY() <=660)||(e.getX()>=100 && e.getX()<=700 && e.getY() >= 740 && e.getY() <=860)||(e.getX()>=100 && e.getX()<=700 && e.getY() >= 340 && e.getY() <=460)||(e.getX()>=0 && e.getX()<=280 && e.getY() >= 110 && e.getY() <=210)){
                    label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }
                else {
                    label.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                }
            }
        });
    }
    public void paint(Graphics g) {
        super.paint(g);
        g.setFont(new Font(Font.DIALOG,Font.BOLD,36));
        g.setColor(Color.white);
        g.drawString("金币:" + StaticData.Coin,600,180);
    }
}
