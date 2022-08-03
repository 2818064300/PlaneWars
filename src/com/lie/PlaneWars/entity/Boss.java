package com.lie.PlaneWars.entity;

import com.lie.PlaneWars.StaticData;

import javax.swing.*;

public class Boss extends BaseEntity implements BaseBehavior {
    private int existtime;
    private boolean mode1 = false;
    private boolean mode2 = false;
    private boolean mode3 = false;
    private boolean mode4 = false;
    private boolean mode5 = false;
    private boolean rushmode;
    private int num = 900;

    private int shootStyle = 1;

    private int shoot2Style = 0;

    public ImageIcon BossImage = new ImageIcon("image/boss.png");

    public Boss(int x, int y, int bossheathMax) {
        this.setX(x);
        this.setY(y);
        this.setHeath(StaticData.BossHeath);
        if (StaticData.BossHeathMax != 0) {
            this.setHeathMax(StaticData.BossHeathMax);
        } else {
            this.setHeathMax(bossheathMax);
        }
        this.existtime = StaticData.BossTime;
        this.setScore(getScore());
        this.setWidth(BossImage.getIconWidth());
        this.setHight(BossImage.getIconHeight());
    }

    public int getExisttime() {
        return existtime;
    }

    public void setExisttime(int existtime) {
        this.existtime = existtime;
    }

    public boolean isRushmode() {
        return rushmode;
    }

    public void setRushmode(boolean rushmode) {
        this.rushmode = rushmode;
    }

    public int getShootStyle() {
        return shootStyle;
    }

    public void setShootStyle(int shootStyle) {
        this.shootStyle = shootStyle;
    }

    public int getShoot2Style() {
        return shoot2Style;
    }

    public void setShoot2Style(int shoot2Style) {
        this.shoot2Style = shoot2Style;
    }

    public void amode() {
        this.setX(StaticData.Plane.getX());
        this.setY(StaticData.Plane.getY() - 600);
        if (getY() < 0) {
            setY(0);
        }
    }

    public void bmode() {
        num = 540;
        this.setX(StaticData.Width / 2 - getWidth() / 2);
        this.setY(60);
    }

    @Override
    public void hit(BaseEntity entity, int damage) {

    }

    @Override
    public void move() {
        if (!rushmode) {
            if (!mode1) {
                if (getY() >= 40 && getY() <= 240) {
                    this.setY(getY() + 2);
                } else {
                    this.setY(getY() + 1);
                }
                if (getY() > num) {
                    mode1 = true;
                }
            } else {
                this.setY(getY() - 3);
                if (getY() < 40) {
                    mode1 = false;
                }
            }
            int num1 = 80;
            int num2 = 720;
            if (getX() <= num1) {
                mode2 = true;
                mode3 = false;
            }
            if (getX() >= num2) {
                mode2 = false;
                mode3 = true;
            }
            if (mode2) {
                if(getX() < StaticData.Plane.getX()){
                    this.setX(getX() + 2);
                } else {
                    this.setX(getX() + 3);
                }
            }
            if (mode3) {
                if(getX() > StaticData.Plane.getX()){
                    this.setX(getX() - 2);
                } else {
                    this.setX(getX() - 3);
                }
            }
            if (!mode1 && !mode2) {
                if (getX() >= num1 && getX() <= num2) {
                    this.setX(getX() + 1);
                }
            }
        }
    }

    @Override
    public void dead() {

    }

    public void rush() {
        if (rushmode) {
            if (getY() <= 30) {
                mode5 = true;
            }
            if (mode5) {
                if (getY() > 900) {
                    mode4 = true;
                }
                if (getY() < -30) {
                    mode4 = false;
                    mode5 = false;
                    rushmode = false;
                }
                if (!mode4) {
                    if (getHeath() > getHeathMax() * 0.6 && getHeath() < getHeathMax() * 0.85) {
                        this.setY(getY() + 15);
                    }
                    if (getHeath() > getHeathMax() * 0.4 && getHeath() < getHeathMax() * 0.6) {
                        this.setY(getY() + 20);
                    }
                    if (getX() <= StaticData.Plane.getX()) {
                        this.setX(getX() + 2);
                    } else {
                        this.setX(getX() - 2);
                    }
                } else {
                    this.setY(getY() - 4);
                }
            } else {
                this.setY(getY() - 10);
            }
        }
    }
}
