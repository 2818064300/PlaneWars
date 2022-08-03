package com.lie.PlaneWars.entity;

import com.lie.PlaneWars.StaticData;

import javax.swing.*;

public class Enemy extends BaseEntity implements BaseBehavior {

    private ImageIcon EnemyImage = new ImageIcon("image/enemy.png");

    public Enemy(int x, int y, int heathMax, int score) {
        this.setX(x);
        this.setY(y);
        this.setHeath(heathMax);
        this.setHeathMax(heathMax);
        this.setScore(score);
        this.setWidth(EnemyImage.getIconWidth());
        this.setHight(EnemyImage.getIconHeight());
    }

    public ImageIcon getEnemyImage() {
        return EnemyImage;
    }

    @Override
    public void move() {
        this.setY(getY() + 1);
    }

    @Override
    public void hit(BaseEntity entity, int damage) {
        StaticData.Score += 1;
        entity.setHeath(entity.getHeath() - damage);
        if (entity.getHeath() <= 0) {
            StaticData.Score += entity.getScore();
            StaticData.Coin += 1;
            StaticData.BossValue += 1;
            StaticData.EnemyList.remove(entity);
        }
    }

    @Override
    public void dead() {

    }
}
