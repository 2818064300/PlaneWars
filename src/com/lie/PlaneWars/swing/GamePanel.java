package com.lie.PlaneWars.swing;

import com.lie.PlaneWars.StaticData;
import com.lie.PlaneWars.common.Global;
import com.lie.PlaneWars.entity.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GamePanel extends JPanel implements MouseMotionListener, KeyListener, MouseListener {
    private Background bj = new Background(0, 0);

    public void init() {
        while (true) {
            Global.update();
            StaticData.Count++;
            StaticData.Time = StaticData.Count / 100;
            for (int i = 0; i < StaticData.BulletList.size(); i++) {
                Bullet bullet = StaticData.BulletList.get(i);
                if (bullet != null) {
                    bullet.move();
                    if (bullet.getY() < -18) {
                        StaticData.BulletList.remove(bullet);
                    }
                }
            }
            for (int i = 0; i < StaticData.BossList.size(); i++) {
                Boss boss = StaticData.BossList.get(i);
                if (boss != null) {
                    if (StaticData.Count % 100 == 0) {
                        boss.setExisttime(boss.getExisttime() + 1);
                    }
                    boss.move();
                    if (boss.getHeath() >= boss.getHeathMax() * 0.4 && boss.getHeath() <= boss.getHeathMax() * 0.85) {
                        boss.rush();
                        if (boss.getX() < StaticData.Plane.getX() + 150 && boss.getX() > StaticData.Plane.getX() - 150) {
                            if (StaticData.Count % 500 == 0 && (int) (100 * Math.random()) > 0) {
                                boss.setRushmode(true);
                            }
                        }
                    }
                    if (boss.getHeath() >= boss.getHeathMax() * 0.2 && boss.getHeath() <= boss.getHeathMax() * 0.4) {
                        boss.amode();
                        boss.setRushmode(false);
                    }
                    if (boss.getHeath() <= boss.getHeathMax() * 0.2) {
                        boss.bmode();
                        boss.setRushmode(false);
                        if (boss.getHeath() <= boss.getHeathMax() * 0.18) {
                            if (StaticData.Count % 100 == 0) {
                                boss.setHeath(boss.getHeath() + 1);
                            }
                        }
                    }
                    if (!boss.isRushmode()) {
                        if (boss.getHeath() >= boss.getHeathMax() * 0.2 && boss.getHeath() <= boss.getHeathMax() * 0.4) {
                            if (boss.getHeath() >= boss.getHeathMax() * 0.3 && boss.getHeath() <= boss.getHeathMax() * 0.4) {
                                if (StaticData.Count % 60 == 0) {
                                    StaticData.EnemyBulletList.add(new EnemyBullet(boss.getX() + 0, boss.getY() + 30, 5, 5, 0, 0, 1));
                                    StaticData.EnemyBulletList.add(new EnemyBullet(boss.getX() + 24, boss.getY() + 40, 5, 5, 0, 0, 1));
                                    StaticData.EnemyBulletList.add(new EnemyBullet(boss.getX() + 48, boss.getY() + 30, 5, 5, 0, 0, 1));
                                }
                            }
                            if (boss.getHeath() >= boss.getHeathMax() * 0.2 && boss.getHeath() <= boss.getHeathMax() * 0.3) {
                                if (StaticData.Count % 40 == 0) {
                                    StaticData.EnemyBulletList.add(new EnemyBullet(boss.getX() + 0, boss.getY() + 30, 4, 6, 0, 0, 1));
                                    StaticData.EnemyBulletList.add(new EnemyBullet(boss.getX() + 24, boss.getY() + 40, 4, 6, 0, 0, 1));
                                    StaticData.EnemyBulletList.add(new EnemyBullet(boss.getX() + 48, boss.getY() + 30, 4, 6, 0, 0, 1));
                                }
                            }
                        } else {
                            if (boss.getY() <= 550) {
                                if (boss.getExisttime() <= 5) {
                                    Random random = new Random();
                                    if (StaticData.Count % 150 == 0 && random.nextInt(100) > 20) {
                                        StaticData.EnemyBulletList.add(new EnemyBullet(boss.getX() + 24, boss.getY() + 40, 15, 7, 0, 0, 1));
                                    }
                                } else {
                                    if (boss.getHeath() > boss.getHeathMax() * 0.2) {
                                        if (StaticData.Count % 35 == 0 && (int) (100 * Math.random()) > 10) {
                                            StaticData.EnemyBulletList.add(new EnemyBullet(boss.getX() + 24, boss.getY() + 40, 18, 7, 0, 0, 1));
                                        }
                                    }
                                    if (StaticData.Count % 150 == 0 && (int) (100 * Math.random()) > 10) {
                                        StaticData.EnemyBulletList.add(new EnemyBullet(boss.getX() + 24, boss.getY() + 10, 7, 5, 0, 0, 2));
                                        StaticData.EnemyBulletList.add(new EnemyBullet(boss.getX() + 24, boss.getY() + 10, 7, 5, 0, 0, 3));
                                    }
                                }
                                if (boss.getHeath() >= boss.getHeathMax() * 0.2) {
                                    if (StaticData.Count % 100 == 0 && (int) (100 * Math.random()) > 40) {
                                        StaticData.EnemyBulletList.add(new EnemyBullet(boss.getX() + 0, boss.getY() + 30, 5, 7, 0, 0, 1));
                                        StaticData.EnemyBulletList.add(new EnemyBullet(boss.getX() + 24, boss.getY() + 40, 5, 7, 0, 0, 1));
                                        StaticData.EnemyBulletList.add(new EnemyBullet(boss.getX() + 48, boss.getY() + 30, 5, 7, 0, 0, 1));
                                    }
                                }
                                if (StaticData.Count % 150 == 0 && (int) (100 * Math.random()) > 15) {
                                    if (boss.getHeath() >= boss.getHeathMax() * 0.2) {
                                        StaticData.EnemyBulletList.add(new EnemyBullet(boss.getX() + 64, boss.getY() + 20, 5, 4, 0, 0, 1));
                                        StaticData.EnemyBulletList.add(new EnemyBullet(boss.getX() + 44, boss.getY() + 30, 5, 4, 0, 0, 1));
                                        StaticData.EnemyBulletList.add(new EnemyBullet(boss.getX() + 24, boss.getY() + 40, 5, 4, 0, 0, 1));
                                        StaticData.EnemyBulletList.add(new EnemyBullet(boss.getX() + 4, boss.getY() + 30, 5, 4, 0, 0, 1));
                                        StaticData.EnemyBulletList.add(new EnemyBullet(boss.getX() - 16, boss.getY() + 20, 5, 4, 0, 0, 1));
                                    } else {
                                        if (boss.getShoot2Style() == 0) {
                                            StaticData.EnemyBulletList.add(new EnemyBullet(boss.getX() + 64, boss.getY() + 20, 4, 4, 0, 0, 1));
                                            StaticData.EnemyBulletList.add(new EnemyBullet(boss.getX() + 44, boss.getY() + 30, 4, 4, 0, 0, 1));
                                            StaticData.EnemyBulletList.add(new EnemyBullet(boss.getX() + 24, boss.getY() + 40, 4, 4, 0, 0, 1));
                                            StaticData.EnemyBulletList.add(new EnemyBullet(boss.getX() + 4, boss.getY() + 30, 4, 4, 0, 0, 1));
                                            StaticData.EnemyBulletList.add(new EnemyBullet(boss.getX() - 16, boss.getY() + 20, 4, 4, 0, 0, 1));
                                        }
                                        if (boss.getShoot2Style() == 1) {
                                            StaticData.EnemyBulletList.add(new EnemyBullet(boss.getX() + 64 - 100, boss.getY() + 20, 4, 4, 0, 0, 1));
                                            StaticData.EnemyBulletList.add(new EnemyBullet(boss.getX() + 44 - 100, boss.getY() + 30, 4, 4, 0, 0, 1));
                                            StaticData.EnemyBulletList.add(new EnemyBullet(boss.getX() + 24 - 100, boss.getY() + 40, 4, 4, 0, 0, 1));
                                            StaticData.EnemyBulletList.add(new EnemyBullet(boss.getX() + 4 - 100, boss.getY() + 30, 4, 4, 0, 0, 1));
                                            StaticData.EnemyBulletList.add(new EnemyBullet(boss.getX() - 16 - 100, boss.getY() + 20, 4, 4, 0, 0, 1));
                                        }
                                        if (boss.getShoot2Style() == 2) {
                                            StaticData.EnemyBulletList.add(new EnemyBullet(boss.getX() + 64 + 100, boss.getY() + 20, 4, 4, 0, 0, 1));
                                            StaticData.EnemyBulletList.add(new EnemyBullet(boss.getX() + 44 + 100, boss.getY() + 30, 4, 4, 0, 0, 1));
                                            StaticData.EnemyBulletList.add(new EnemyBullet(boss.getX() + 24 + 100, boss.getY() + 40, 4, 4, 0, 0, 1));
                                            StaticData.EnemyBulletList.add(new EnemyBullet(boss.getX() + 4 + 100, boss.getY() + 30, 4, 4, 0, 0, 1));
                                            StaticData.EnemyBulletList.add(new EnemyBullet(boss.getX() - 16 + 100, boss.getY() + 20, 4, 4, 0, 0, 1));
                                        }
                                    }
                                    StaticData.EnemyBulletList.add(new EnemyBullet(boss.getX() + 24, boss.getY() + 10, 5, 4, 0, 0, 2));
                                    StaticData.EnemyBulletList.add(new EnemyBullet(boss.getX() + 24, boss.getY() + 10, 5, 4, 0, 0, 3));
                                }
                                if (boss.getExisttime() >= 45 && boss.getExisttime() < 120) {
                                    if (StaticData.Count % 70 == 0 && (int) (100 * Math.random()) > 30) {
                                        StaticData.EnemyBulletList.add(new EnemyBullet(boss.getX() + 0, boss.getY() + 30, 15, 8, 0, 0, 1));
                                        StaticData.EnemyBulletList.add(new EnemyBullet(boss.getX() + 24, boss.getY() + 40, 15, 8, 0, 0, 1));
                                        StaticData.EnemyBulletList.add(new EnemyBullet(boss.getX() + 48, boss.getY() + 30, 15, 8, 0, 0, 1));
                                    }
                                }
                                if (boss.getExisttime() >= 120) {
                                    if (StaticData.Count % 70 == 0 && (int) (100 * Math.random()) > 30) {
                                        StaticData.EnemyBulletList.add(new EnemyBullet(boss.getX() + 0, boss.getY() + 30, 20, 8, 0, 0, 1));
                                        StaticData.EnemyBulletList.add(new EnemyBullet(boss.getX() + 24, boss.getY() + 40, 20, 8, 0, 0, 1));
                                        StaticData.EnemyBulletList.add(new EnemyBullet(boss.getX() + 48, boss.getY() + 30, 20, 8, 0, 0, 1));
                                    }
                                }
                                if (boss.getHeath() <= boss.getHeathMax() * 0.2) {
                                    if (boss.getExisttime() >= 180) {
                                        if (StaticData.Count % 200 == 0) {
                                            StaticData.EnemyBulletList.add(new EnemyBullet(0, 100, 3, 6, 0, 0, 2));
                                            StaticData.EnemyBulletList.add(new EnemyBullet(0, 300, 3, 6, 0, 0, 2));
                                            StaticData.EnemyBulletList.add(new EnemyBullet(0, 500, 3, 6, 0, 0, 2));
                                            StaticData.EnemyBulletList.add(new EnemyBullet(0, 700, 3, 6, 0, 0, 2));
                                            StaticData.EnemyBulletList.add(new EnemyBullet(800, 200, 3, 6, 0, 0, 3));
                                            StaticData.EnemyBulletList.add(new EnemyBullet(800, 400, 3, 6, 0, 0, 3));
                                            StaticData.EnemyBulletList.add(new EnemyBullet(800, 600, 3, 6, 0, 0, 3));
                                            StaticData.EnemyBulletList.add(new EnemyBullet(800, 800, 3, 6, 0, 0, 3));
                                        }
                                    }
                                }
                                if (boss.getHeath() <= boss.getHeathMax() * 0.2) {
                                    if (StaticData.Count % 200 == 0 && boss.getShootStyle() == 0) {
                                        StaticData.EnemyBulletList.add(new EnemyBullet(100, 20, 7, 7, 0, 0, 1));
                                        StaticData.EnemyBulletList.add(new EnemyBullet(200, 20, 7, 7, 0, 0, 1));
                                        StaticData.EnemyBulletList.add(new EnemyBullet(300, 20, 7, 7, 0, 0, 1));
                                        StaticData.EnemyBulletList.add(new EnemyBullet(400, 20, 7, 7, 0, 0, 1));
                                        StaticData.EnemyBulletList.add(new EnemyBullet(500, 20, 7, 7, 0, 0, 1));
                                        StaticData.EnemyBulletList.add(new EnemyBullet(600, 20, 7, 7, 0, 0, 1));
                                        StaticData.EnemyBulletList.add(new EnemyBullet(700, 20, 7, 7, 0, 0, 1));
                                    }
                                    if (StaticData.Count % 200 == 0 && boss.getShootStyle() == 1) {
                                        StaticData.EnemyBulletList.add(new EnemyBullet(50, 20, 7, 7, 0, 0, 1));
                                        StaticData.EnemyBulletList.add(new EnemyBullet(150, 50, 7, 7, 0, 0, 1));
                                        StaticData.EnemyBulletList.add(new EnemyBullet(250, 80, 7, 7, 0, 0, 1));
                                        StaticData.EnemyBulletList.add(new EnemyBullet(350, 110, 7, 7, 0, 0, 1));
                                        StaticData.EnemyBulletList.add(new EnemyBullet(450, 110, 7, 7, 0, 0, 1));
                                        StaticData.EnemyBulletList.add(new EnemyBullet(550, 80, 7, 7, 0, 0, 1));
                                        StaticData.EnemyBulletList.add(new EnemyBullet(650, 50, 7, 7, 0, 0, 1));
                                        StaticData.EnemyBulletList.add(new EnemyBullet(750, 20, 7, 7, 0, 0, 1));
                                    }
                                    if (StaticData.Count % 200 == 0) {
                                        boss.setShootStyle(boss.getShootStyle() + 1);
                                    }
                                    if (boss.getShootStyle() == 2) {
                                        boss.setShootStyle(0);
                                    }
                                    if (StaticData.Count % 150 == 0) {
                                        boss.setShoot2Style(boss.getShoot2Style() + 1);
                                    }
                                    if (boss.getShoot2Style() == 3) {
                                        boss.setShoot2Style(0);
                                    }
                                    StaticData.EnemyList.clear();
                                }
                            } else {
                                if (StaticData.Plane.getY() + 30 <= boss.getY()) {
                                    if (StaticData.Count % 35 == 0 && (int) (100 * Math.random()) > 35) {
                                        StaticData.EnemyBulletList.add(new EnemyBullet(boss.getX() + 64, boss.getY() + 20, 5, -7, 0, 0, 1));
                                        StaticData.EnemyBulletList.add(new EnemyBullet(boss.getX() + 44, boss.getY() + 30, 5, -7, 0, 0, 1));
                                        StaticData.EnemyBulletList.add(new EnemyBullet(boss.getX() + 24, boss.getY() + 40, 5, -7, 0, 0, 1));
                                        StaticData.EnemyBulletList.add(new EnemyBullet(boss.getX() + 4, boss.getY() + 30, 5, -7, 0, 0, 1));
                                        StaticData.EnemyBulletList.add(new EnemyBullet(boss.getX() - 16, boss.getY() + 20, 5, -7, 0, 0, 1));
                                    }
                                }
                            }
                        }
                    } else {
                        if (StaticData.Count % 25 == 0 && (int) (100 * Math.random()) > 10) {
                            StaticData.EnemyBulletList.add(new EnemyBullet(boss.getX() + 24, boss.getY() + 10, 4, 5, 0, 0, 2));
                            StaticData.EnemyBulletList.add(new EnemyBullet(boss.getX() + 24, boss.getY() + 10, 4, 5, 0, 0, 3));
                        }
                    }
                    if (this.isHitBoss(boss, StaticData.Plane)) {
                        if (boss.isRushmode()) {
                            if (StaticData.Count % 5 == 0) {
                                StaticData.Plane.setHeath(StaticData.Plane.getHeath() - 7);
                            }
                        } else {
                            if (StaticData.Count % 5 == 0) {
                                StaticData.Plane.setHeath(StaticData.Plane.getHeath() - 1);
                            }
                        }
                        if (StaticData.Plane.getHeath() <= 0) {
                            StaticData.Plane.dead();
                            return;
                        }
                    }
                    for (int j = 0; j < StaticData.BulletList.size(); j++) {
                        Bullet bullet = StaticData.BulletList.get(j);
                        if (bullet != null) {
                            if (this.isHitBoss(boss, bullet)) {
                                if (bullet.getPenetrate() == 0) {
                                    StaticData.BulletList.remove(bullet);
                                    StaticData.Score += 1;
                                }
                                if (boss.isRushmode()) {
                                    boss.setHeath((int) (boss.getHeath() - bullet.getDamage() * 1.5));
                                } else {
                                    if (boss.getHeath() <= boss.getHeathMax() * 0.2) {
                                        if (bullet.getDamage() > 3) {
                                            boss.setHeath(boss.getHeath() - bullet.getDamage());
                                        } else {
                                            boss.setHeath(boss.getHeath() - 1);
                                        }
                                    } else {
                                        boss.setHeath(boss.getHeath() - bullet.getDamage());
                                    }
                                }
                                if (boss.getHeath() <= 0) {
                                    StaticData.BossList.remove(boss);
                                    boss.setHeath(boss.getHeathMax());
                                    StaticData.Floor = 2;
                                }
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < StaticData.EnemyBulletList.size(); i++) {
                EnemyBullet enemybullet = StaticData.EnemyBulletList.get(i);
                if (enemybullet != null) {
                    if (enemybullet.getStyle() == 1) {
                        enemybullet.move();
                    }
                    if (enemybullet.getStyle() == 2) {
                        enemybullet.move2();
                    }
                    if (enemybullet.getStyle() == 3) {
                        enemybullet.move3();
                    }
                    if (enemybullet.getY() > StaticData.Hight) {
                        if (enemybullet.getRebound() == 1) {
                            StaticData.EnemyBulletList.remove(enemybullet);
                        }
                        if (enemybullet.getRebound() == 2) {
                            enemybullet.setShootspeed(-enemybullet.getShootspeed());
                            if (enemybullet.getY() < 0) {
                                StaticData.EnemyBulletList.remove(enemybullet);
                            }
                        }
                    }
                    if (this.BulletisHitPlane(enemybullet, StaticData.Plane)) {
                        StaticData.Plane.hit(StaticData.Plane,enemybullet.getDamage());
                        StaticData.EnemyBulletList.remove(enemybullet);
                    }
                }
            }
            for (int i = 0; i < StaticData.EnemyList.size(); i++) {
                Enemy enemy = StaticData.EnemyList.get(i);
                Enemy firstenemy = StaticData.EnemyList.get(0);
                if (enemy != null) {
                    enemy.move();
                    if (enemy.getY() > StaticData.Hight) {
                        StaticData.EnemyList.remove(enemy);
                    }
                    if (enemy.getY() <= 700) {
                        if (StaticData.Count % 100 == 0 && (int) (100 * Math.random()) > 40) {
                            StaticData.EnemyBulletList.add(new EnemyBullet(enemy.getX() + 24, enemy.getY() + 40, 6, 4, 0, 0, 1));
                        }
                        if (StaticData.Time <= 5) {
                            if (StaticData.Count % 250 == 0 && (int) (100 * Math.random()) > 80) {
                                StaticData.EnemyBulletList.add(new EnemyBullet(enemy.getX() + 4, enemy.getY() + 30, 7, 2, 0, 0, 1));
                                StaticData.EnemyBulletList.add(new EnemyBullet(enemy.getX() + 24, enemy.getY() + 40, 7, 2, 0, 0, 1));
                                StaticData.EnemyBulletList.add(new EnemyBullet(enemy.getX() + 44, enemy.getY() + 30, 7, 2, 0, 0, 1));
                            }
                        }
                        if (StaticData.Time >= 5 && StaticData.Time < 15) {
                            if (StaticData.Count % 250 == 0 && (int) (100 * Math.random()) > 80) {
                                StaticData.EnemyBulletList.add(new EnemyBullet(enemy.getX() + 4, enemy.getY() + 30, 7, 2, 0, 0, 1));
                                StaticData.EnemyBulletList.add(new EnemyBullet(enemy.getX() + 24, enemy.getY() + 40, 8, 2, 0, 1, 1));
                                StaticData.EnemyBulletList.add(new EnemyBullet(enemy.getX() + 44, enemy.getY() + 30, 7, 2, 0, 0, 1));
                            }
                        }
                        if (StaticData.Time >= 15 && StaticData.Time < 60) {
                            if (StaticData.Count % 250 == 0 && (int) (100 * Math.random()) > 80) {
                                StaticData.EnemyBulletList.add(new EnemyBullet(enemy.getX() + 4, enemy.getY() + 30, 8, 3, 0, 0, 1));
                                StaticData.EnemyBulletList.add(new EnemyBullet(enemy.getX() + 24, enemy.getY() + 40, 11, 3, 0, 1, 1));
                                StaticData.EnemyBulletList.add(new EnemyBullet(enemy.getX() + 44, enemy.getY() + 30, 8, 3, 0, 0, 1));
                            }
                        }
                        if (StaticData.Time >= 60) {
                            if (StaticData.Count % 250 == 0 && (int) (100 * Math.random()) > 80) {
                                StaticData.EnemyBulletList.add(new EnemyBullet(enemy.getX() + 4, enemy.getY() + 30, 10, 4, 0, 1, 1));
                                StaticData.EnemyBulletList.add(new EnemyBullet(enemy.getX() + 24, enemy.getY() + 40, 12, 4, 0, 0, 1));
                                StaticData.EnemyBulletList.add(new EnemyBullet(enemy.getX() + 44, enemy.getY() + 30, 10, 4, 0, 1, 1));
                            }
                        }
                    }
                    if (this.isHitPlane(enemy, StaticData.Plane)) {
                        if (StaticData.Count % 5 == 0) {
                            StaticData.Plane.setHeath(StaticData.Plane.getHeath() - 1);
                            enemy.setHeath(enemy.getHeath() - 1);
                        }
                        if (enemy.getHeath() <= 0) {
                            StaticData.EnemyList.remove(enemy);
                        }
                        if (StaticData.Plane.getHeath() <= 0) {
                            StaticData.Plane.dead();
                            return;
                        }
                    }
                    if (StaticData.BossList.size() > 0) {
                        Boss boss = StaticData.BossList.get(0);
                        if (boss.isRushmode()) {
                            if (this.BossHitEnemy(boss, enemy)) {
                                if (StaticData.Count % 25 == 0) {
                                    enemy.setHeath(enemy.getHeath() - 1);
                                    if(enemy.getHeath() <= 0){
                                        StaticData.EnemyList.remove(enemy);
                                    }
                                }
                            }
                        }
                    }
                    for (int j = 0; j < StaticData.BulletList.size(); j++) {
                        Bullet bullet = StaticData.BulletList.get(j);
                        Bullet firstbullet = StaticData.BulletList.get(0);
                        if (bullet != null) {
                            if (bullet.isTrack()) {
                                int Trackspeed = 2;
                                if (firstbullet.getX() >= firstenemy.getX()) {
                                    firstbullet.setX(firstbullet.getX() - Trackspeed);
                                }
                                if (firstbullet.getX() < firstenemy.getX()) {
                                    firstbullet.setX(firstbullet.getX() + Trackspeed);
                                }
                                if (firstbullet.getY() >= firstenemy.getY()) {
                                    firstbullet.setY(firstbullet.getY() - Trackspeed);
                                }
                                if (firstbullet.getY() < firstenemy.getY()) {
                                    firstbullet.setY(firstbullet.getY() + Trackspeed);
                                }
                            }
                            if (this.isHit(enemy, bullet)) {
                                if (bullet.getPenetrate() == 0) {
                                    StaticData.BulletList.remove(bullet);
                                }
                                enemy.hit(enemy, bullet.getDamage());
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < StaticData.HeathList.size(); i++) {
                Heath heath = StaticData.HeathList.get(i);
                if (heath != null) {
                    if (this.isHitHeath(heath, StaticData.Plane)) {
                        StaticData.HeathList.remove(heath);
                        if (StaticData.Plane.getHeath() >= StaticData.Plane.getHeathMax()) {
                            StaticData.Plane.setHeath(StaticData.Plane.getHeathMax());
                        } else {
                            StaticData.Plane.setHeath(StaticData.Plane.getHeath() + heath.getHeath());
                        }
                    }
                    heath.move();
                    if (heath.getY() > StaticData.Hight) {
                        StaticData.HeathList.remove(heath);
                    }
                }
            }
            for (int i = 0; i < StaticData.ArmorList.size(); i++) {
                Armor armor = StaticData.ArmorList.get(i);
                if (armor != null) {
                    if (this.isHitArmor(armor, StaticData.Plane)) {
                        StaticData.Plane.setArmorModeTime(800);
                        StaticData.Plane.setArmorMode(true);
                        StaticData.ArmorList.remove(armor);
                    }
                    armor.move();
                }
                if (armor.getY() > StaticData.Hight) {
                    StaticData.ArmorList.remove(armor);
                }
            }
            repaint();
            try {
                Thread.sleep(StaticData.GameSpeed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(bj.getBackgroundImage().getImage(), bj.getX(), bj.getY(), null);
        if (StaticData.Plane != null) {
            g.drawImage(StaticData.Plane.getPlaneImage().getImage(), StaticData.Plane.getX(), StaticData.Plane.getY(), null);
        }
        for (Bullet bullet : StaticData.BulletList) {
            if (bullet != null) {
                if (!bullet.isTrack()) {
                    g.drawImage(bullet.getBulletImage().getImage(), bullet.getX(), bullet.getY(), null);
                } else {
                    g.drawImage(bullet.getBulletImage2().getImage(), bullet.getX(), bullet.getY(), null);
                }
            }
        }
        for (EnemyBullet enemyBullet : StaticData.EnemyBulletList) {
            if (enemyBullet != null) {
                if (enemyBullet.getStyle() == 1) {
                    g.drawImage(enemyBullet.getEnemyBulletImage().getImage(), enemyBullet.getX(), enemyBullet.getY(), null);
                }
                if (enemyBullet.getStyle() == 2) {
                    g.drawImage(enemyBullet.getEnemyBullet2Image().getImage(), enemyBullet.getX(), enemyBullet.getY(), null);
                }
                if (enemyBullet.getStyle() == 3) {
                    g.drawImage(enemyBullet.getEnemyBullet3Image().getImage(), enemyBullet.getX(), enemyBullet.getY(), null);
                }
            }
        }
        for (Boss boss : StaticData.BossList) {
            if (boss != null) {
                g.drawImage(boss.BossImage.getImage(), boss.getX(), boss.getY(), null);
            }
        }
        for (Enemy enemy : StaticData.EnemyList) {
            if (enemy != null) {
                g.drawImage(enemy.getEnemyImage().getImage(), enemy.getX(), enemy.getY(), null);
            }
        }
        for (Heath heath : StaticData.HeathList) {
            if (heath != null) {
                g.drawImage(heath.getHeathImage().getImage(), heath.getX(), heath.getY(), null);
            }
        }
        g.setFont(new Font(Font.DIALOG, Font.BOLD, 24));
        g.setColor(Color.white);
        g.drawString("第" + StaticData.Floor + "关", 40, 60);
        g.drawString("金币:" + StaticData.Coin, 640, 60);
        g.drawString("得分:" + StaticData.Score, 40, 100);
        g.drawString("时间:" + StaticData.Time, 40, 140);
        g.drawString("生命:" + StaticData.Plane.getHeath() + "/" + StaticData.Plane.getHeathMax(), 40, 180);
        g.drawString("护盾:" + StaticData.Plane.getArmor() + "/" + StaticData.Plane.getArmorMax(), 40, 220);
        if (StaticData.BossList.size() > 0) {
            Boss boss = StaticData.BossList.get(0);
            g.drawString("Boss剩余血量:" + boss.getHeath() + "/" + boss.getHeathMax(), 40, 260);
            if (boss.getHeath() >= boss.getHeathMax() * 0.85 && boss.getHeath() <= boss.getHeathMax()) {
                g.drawString("Boss第一阶段", 40, 300);
            }
            if (boss.getHeath() >= boss.getHeathMax() * 0.4 && boss.getHeath() <= boss.getHeathMax() * 0.85) {
                g.drawString("Boss第二阶段", 40, 300);
            }
            if (boss.getHeath() >= boss.getHeathMax() * 0.2 && boss.getHeath() <= boss.getHeathMax() * 0.4) {
                g.drawString("Boss第三阶段", 40, 300);
            }
            if (boss.getHeath() <= boss.getHeathMax() * 0.2) {
                g.drawString("Boss第四阶段", 40, 300);
            }
        } else {
            g.drawString("进度:" + StaticData.BossValue + "/" + "5", 40, 260);
        }
    }

    private boolean isHit(Enemy e, Bullet b) {
        Rectangle eRect = new Rectangle(e.getX(), e.getY(), e.getWidth(), e.getHight());
        Rectangle bRect = new Rectangle(b.getX(), b.getY(), b.getWidth(), b.getHight());
        return eRect.intersects(bRect);
    }

    private boolean isHitBoss(Boss bo, Bullet b) {
        Rectangle boRect = new Rectangle(bo.getX(), bo.getY(), bo.getWidth(), bo.getHight());
        Rectangle bRect = new Rectangle(b.getX(), b.getY(), b.getWidth(), b.getHight());
        return boRect.intersects(bRect);
    }

    private boolean isHitPlane(Enemy e, Plane p) {
        Rectangle eRect = new Rectangle(e.getX(), e.getY(), e.getWidth(), e.getHight());
        Rectangle pRect = new Rectangle(p.getX(), p.getY(), p.getWidth(), p.getHight());
        return pRect.intersects(eRect);
    }

    private boolean BulletisHitPlane(EnemyBullet eb, Plane p) {
        Rectangle ebRect = new Rectangle(eb.getX(), eb.getY(), eb.getWidth(), eb.getHight());
        Rectangle pRect = new Rectangle(p.getX(), p.getY(), p.getWidth(), p.getHight());
        return pRect.intersects(ebRect);
    }

    private boolean isHitHeath(Heath h, Plane p) {
        Rectangle hRect = new Rectangle(h.getX(), h.getY(), h.getWidth(), h.getHight());
        Rectangle pRect = new Rectangle(p.getX(), p.getY(), p.getWidth(), p.getHight());
        return hRect.intersects(pRect);
    }

    private boolean isHitArmor(Armor a, Plane p) {
        Rectangle aRect = new Rectangle(a.getX(), a.getY(), a.getWidth(), a.getHight());
        Rectangle pRect = new Rectangle(p.getX(), p.getY(), p.getWidth(), p.getHight());
        return aRect.intersects(pRect);
    }

    private boolean isHitBoss(Boss b, Plane p) {
        Rectangle bRect = new Rectangle(b.getX(), b.getY(), b.getWidth(), b.getHight());
        Rectangle pRect = new Rectangle(p.getX(), p.getY(), p.getWidth(), p.getHight());
        return bRect.intersects(pRect);
    }

    private boolean BossHitEnemy(Boss b, Enemy e) {
        Rectangle bRect = new Rectangle(b.getX(), b.getY(), b.getWidth(), b.getHight());
        Rectangle eRect = new Rectangle(e.getX(), e.getY(), e.getWidth(), e.getHight());
        return bRect.intersects(eRect);
    }

    public void calculatPosition(MouseEvent e) {
        int temX = e.getX();
        int temY = e.getY();
        if (StaticData.Plane != null) {
            if (temX > StaticData.Plane.getWidth() / 2 && temX < StaticData.Width - StaticData.Plane.getWidth() / 2) {
                StaticData.Plane.setX(temX - 39);
            }
            if (temY > StaticData.Plane.getHight() / 2 && temY < StaticData.Hight - StaticData.Plane.getHight() / 2) {
                StaticData.Plane.setY(temY - 60);
            }
        }
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        this.calculatPosition(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        this.calculatPosition(e);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }


    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {

        if (e.getButton() == MouseEvent.BUTTON1) {
            StaticData.Plane.setWildMode(true);
            this.calculatPosition(e);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        StaticData.Plane.setWildMode(false);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
