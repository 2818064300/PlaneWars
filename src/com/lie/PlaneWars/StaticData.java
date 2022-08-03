package com.lie.PlaneWars;

import com.lie.PlaneWars.entity.*;

import java.util.ArrayList;

public class StaticData {

    public static int Width = 800;
    public static int Hight = 1000;
    public static int Coin = 0;
    public static int Time = 0;
    public static int Floor;
    public static int PlaneHeath;
    public static int PlaneHeathMax;
    public static int PlaneArmor;
    public static int PlaneArmorMax;
    public static int BossHeath;
    public static int BossHeathMax;
    public static int BossTime;
    public static int Count = 0;
    public static int ShootSpeed = 15;//射击速度
    public static int GameSpeed = 10;//游戏节奏时间
    public static int Score = 0;//得分
    public static Plane Plane;
    public static int BossValue;

    public static ArrayList<Bullet> BulletList = new ArrayList();
    public static ArrayList<EnemyBullet> EnemyBulletList = new ArrayList();
    public static ArrayList<Enemy> EnemyList = new ArrayList();
    public static ArrayList<Armor> ArmorList = new ArrayList();
    public static ArrayList<Boss> BossList = new ArrayList();
    public static ArrayList<Heath> HeathList = new ArrayList();
}
