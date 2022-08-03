package com.lie.PlaneWars.entity;

import javax.swing.*;

public class EnemyBullet {
    private int x;//x坐标
    private int y;//y坐标
    private int shootspeed;//射击速度
    private int width;//宽度
    private int hight;//高度
    private int damage;//伤害
    private int penetrate;//穿透个数
    private int rebound;//反弹
    private int style;//反弹次数
    public ImageIcon EnemyBulletImage = new ImageIcon("image/enemy_bullet.png");
    public ImageIcon EnemyBullet2Image = new ImageIcon("image/enemy_bullet2.png");
    public ImageIcon EnemyBullet3Image = new ImageIcon("image/enemy_bullet3.png");

    public EnemyBullet(int x,int y,int damage,int shootspeed,int penetrate,int rebound,int style){
        this.damage = damage;
        this.shootspeed = shootspeed;
        this.penetrate = penetrate;
        this.rebound = rebound;
        this.style = style;
        if(style == 1) {
            this.width = EnemyBulletImage.getIconWidth();
            this.hight = EnemyBulletImage.getIconHeight();
        }
        if(style == 2) {
            this.width = EnemyBullet2Image.getIconWidth();
            this.hight = EnemyBullet2Image.getIconHeight();
        }
        if(style == 3) {
            this.width = EnemyBullet3Image.getIconWidth();
            this.hight = EnemyBullet3Image.getIconHeight();
        }
        this.x = x + width / 2;
        this.y = y + hight / 2;
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

    public int getStyle() {
        return style;
    }

    public void setStyle(int style) {
        this.style = style;
    }

    public ImageIcon getEnemyBulletImage() {
        return EnemyBulletImage;
    }

    public void setEnemyBulletImage(ImageIcon enemyBulletImage) {
        EnemyBulletImage = enemyBulletImage;
    }

    public ImageIcon getEnemyBullet2Image() {
        return EnemyBullet2Image;
    }

    public void setEnemyBullet2Image(ImageIcon enemyBullet2Image) {
        EnemyBullet2Image = enemyBullet2Image;
    }

    public ImageIcon getEnemyBullet3Image() {
        return EnemyBullet3Image;
    }

    public void setEnemyBullet3Image(ImageIcon enemyBullet3Image) {
        EnemyBullet3Image = enemyBullet3Image;
    }

    public void move(){
        this.y += shootspeed;
    }
    public void move2(){
        this.x += shootspeed;
    }
    public void move3(){
        this.x -= shootspeed;
    }
}
