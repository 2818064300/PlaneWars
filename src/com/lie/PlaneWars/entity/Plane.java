package com.lie.PlaneWars.entity;

import com.lie.PlaneWars.StaticData;

import javax.swing.*;

public class Plane extends BaseEntity implements BaseBehavior {
    private int armorDelay;
    private int armorModeTime;

    private boolean ArmorMode = false;//护盾模式
    private boolean WildMode = false;

    public Plane(int x, int y) {
        this.setX(x);
        this.setY(y);
        this.setWidth(PlaneImage.getIconWidth());
        this.setHight(PlaneImage.getIconHeight());
        this.setHeath(StaticData.PlaneHeath);
        this.setHeathMax(StaticData.PlaneHeathMax);
        this.setArmor(StaticData.PlaneArmor);
        this.setArmorMax(StaticData.PlaneArmorMax);
    }

    private ImageIcon PlaneImage = new ImageIcon("image/plane.png");

    public ImageIcon getPlaneImage() {
        return PlaneImage;
    }

    public boolean isArmorMode() {
        return ArmorMode;
    }

    public void setArmorMode(boolean armorMode) {
        ArmorMode = armorMode;
    }

    public boolean isWildMode() {
        return WildMode;
    }

    public void setWildMode(boolean wildMode) {
        WildMode = wildMode;
    }

    public int getArmorDelay() {
        return armorDelay;
    }

    public void setArmorDelay(int armorDelay) {
        this.armorDelay = armorDelay;
    }

    public int getArmorModeTime() {
        return armorModeTime;
    }

    public void setArmorModeTime(int armorModeTime) {
        this.armorModeTime = armorModeTime;
    }

    @Override
    public void hit(BaseEntity entity,int damage) {
        StaticData.Plane.setArmorDelay(0);
        if (StaticData.Plane.isArmorMode()) {
            if (entity.getArmor() >= damage * 5) {
                entity.setArmor(entity.getArmor() - damage * 5);
            } else {
                entity.setHeath(entity.getHeath() - damage);
                entity.setArmor(0);
            }
        } else {
            if (entity.getArmor() >= damage * 10) {
                entity.setArmor(entity.getArmor() - damage * 10);
            } else {
                entity.setHeath(entity.getHeath() - damage);
                entity.setArmor(0);
            }
        }
        if (entity.getHeath() <= 0) {
            StaticData.Plane.dead();
        }
    }
    @Override
    public void move() {

    }
    @Override
    public void dead() {
        StaticData.Count = 0;
        StaticData.Score = 0;
        StaticData.Time = 0;
        this.setHeath(this.getHeathMax());
    }
}
