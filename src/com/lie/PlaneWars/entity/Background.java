package com.lie.PlaneWars.entity;

import javax.swing.*;

public class Background{
    private int x;
    private int y;
    public ImageIcon BackgroundImage = new ImageIcon("image/bj.png");
    public ImageIcon Background2Image = new ImageIcon("image/bj.png");

    public Background(int x,int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ImageIcon getBackgroundImage() {
        return BackgroundImage;
    }

    public void setBackgroundImage(ImageIcon backgroundImage) {
        BackgroundImage = backgroundImage;
    }

    public ImageIcon getBackground2Image() {
        return Background2Image;
    }

    public void setBackground2Image(ImageIcon background2Image) {
        Background2Image = background2Image;
    }
}