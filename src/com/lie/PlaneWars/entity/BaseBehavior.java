package com.lie.PlaneWars.entity;

public interface BaseBehavior {
    public void hit(BaseEntity entity, int damage);

    public void move();

    public void dead();
}
