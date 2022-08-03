package com.lie.PlaneWars.swing;


import com.lie.PlaneWars.StaticData;

import javax.swing.*;

public class GameFrame extends JFrame implements Runnable{
    private GamePanel Panel = new GamePanel();

    //构造方法
    public GameFrame(int x,int y) {
        this.setFrameself(x,y);
        this.add(Panel);
        this.addListener();
    }

    //添加监视器
    private void addListener() {
        this.addMouseMotionListener(Panel);
        this.addMouseListener(Panel);
        this.addKeyListener(Panel);
    }

    private void setFrameself(int x,int y) {
        this.setBounds(x, y, StaticData.Width, StaticData.Hight);
        this.setTitle("飞机大战");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }


    public static void init(){
        StaticData.Time = 0;
        StaticData.Coin = 0;
        StaticData.Floor = 1;
        StaticData.PlaneHeath = 100;
        StaticData.PlaneHeathMax = 100;
        StaticData.PlaneArmor = 100;
        StaticData.PlaneArmorMax = 100;
        StaticData.BossHeath = 1500;
        StaticData.BossHeathMax = 1500;
        StaticData.BossTime =0;
    }

    @Override
    public void run() {
        this.Panel.init();
    }
}
