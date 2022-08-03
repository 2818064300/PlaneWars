package com.lie.PlaneWars.entity;

import javax.swing.*;

public class Heath {
    private int x;
    private int y;
    private int heath;
    private int width;
    private int hight;
    public ImageIcon HeathImage = new ImageIcon("image/heath.png");

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

    public int getHeath() {
        return heath;
    }

    public void setHeath(int heath) {
        this.heath = heath;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHight() {
        return hight;
    }

    public void setHight(int hight) {
        this.hight = hight;
    }

    public ImageIcon getHeathImage() {
        return HeathImage;
    }

    public void setHeathImage(ImageIcon heathImage) {
        HeathImage = heathImage;
    }

    public Heath(int x, int y, int heath){
        this.width = HeathImage.getIconWidth();
        this.hight = HeathImage.getIconHeight();
        this.x = x + width / 2;
        this.y = y + hight / 2;
        this.heath = heath;
    }
    public void move(){
        this.y += 2;
    }
}
