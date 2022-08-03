package com.lie.PlaneWars.entity;

public class BaseEntity {
    private int x;
    private int y;
    private int heath;
    private int heathMax;
    private int armor;
    private int armorMax;
    private int width;
    private int hight;
    private int score;

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

    public int getHeathMax() {
        return heathMax;
    }

    public void setHeathMax(int heathMax) {
        this.heathMax = heathMax;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getArmorMax() {
        return armorMax;
    }

    public void setArmorMax(int armorMax) {
        this.armorMax = armorMax;
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
