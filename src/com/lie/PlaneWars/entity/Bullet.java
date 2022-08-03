package com.lie.PlaneWars.entity;

import javax.swing.*;

public class Bullet {
    private int x;//x坐标
    private int y;//y坐标
    private int shootspeed;//射击速度
    private int width;//宽度
    private int hight;//高度
    private int damage;//伤害
    private int penetrate;//穿透个数
    private int rebound;//反弹次数
    private boolean track;
    public ImageIcon BulletImage = new ImageIcon("image/bullet.png");
    public ImageIcon BulletImage2 = new ImageIcon("image/track_bullet.png");

    public Bullet(int x,int y,int damage,int shootspeed,int penetrate,int rebound,boolean track){
        this.width = BulletImage.getIconWidth();
        this.hight = BulletImage.getIconHeight();
        this.x = x + width / 2;
        this.y = y + hight / 2;
        this.damage = damage;
        this.shootspeed = shootspeed;
        this.penetrate = penetrate;
        this.rebound = rebound;
        this.track = track;
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

    public int getShootspeed() {
        return shootspeed;
    }

    public void setShootspeed(int shootspeed) {
        this.shootspeed = shootspeed;
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

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPenetrate() {
        return penetrate;
    }

    public void setPenetrate(int penetrate) {
        this.penetrate = penetrate;
    }

    public int getRebound() {
        return rebound;
    }

    public void setRebound(int rebound) {
        this.rebound = rebound;
    }

    public boolean isTrack() {
        return track;
    }

    public void setTrack(boolean track) {
        this.track = track;
    }

    public ImageIcon getBulletImage() {
        return BulletImage;
    }

    public void setBulletImage(ImageIcon bulletImage) {
        BulletImage = bulletImage;
    }

    public ImageIcon getBulletImage2() {
        return BulletImage2;
    }

    public void setBulletImage2(ImageIcon bulletImage2) {
        BulletImage2 = bulletImage2;
    }

    public void move(){
        this.y -= shootspeed;
    }
}
