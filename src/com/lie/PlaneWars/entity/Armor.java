package com.lie.PlaneWars.entity;

import javax.swing.*;

public class Armor {
    private int x;
    private int y;
    private int time;
    private int width;
    private int hight;
    public ImageIcon ArmorImage = new ImageIcon("../../../../image/armor.png");

    public Armor(int x,int y,int time){
        this.width = ArmorImage.getIconWidth();
        this.hight = ArmorImage.getIconHeight();
        this.x = x + width / 2;
        this.y = y + hight / 2;
        this.time = time;
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

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
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

    public ImageIcon getArmorImage() {
        return ArmorImage;
    }

    public void setArmorImage(ImageIcon armorImage) {
        ArmorImage = armorImage;
    }

    public void move() {
        this.y += 2;
    }
}
