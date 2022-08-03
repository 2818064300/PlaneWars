package com.lie.PlaneWars.common;

import com.lie.PlaneWars.StaticData;
import com.lie.PlaneWars.entity.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Global {
    public static void update() {
        if (StaticData.Plane.getHeath() >= StaticData.PlaneHeathMax) {
            StaticData.Plane.setHeath(StaticData.PlaneHeathMax);
        }
        if (StaticData.Count % 250 == 0) {
            try {
                Save();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if (StaticData.Plane.getArmorDelay() < 400) {
            StaticData.Plane.setArmorDelay(StaticData.Plane.getArmorDelay() + 1);
        }
        if (StaticData.Plane.getArmorDelay() > 400) {
            StaticData.Plane.setArmorDelay(400);
        }
        if (StaticData.Count % 30 == 0) {
            if (StaticData.Plane.getArmor() >= StaticData.Plane.getArmorMax()) {
                StaticData.Plane.setArmor(StaticData.Plane.getArmorMax());
            } else {
                if (StaticData.Plane.getArmorDelay() == 400) {
                    StaticData.Plane.setArmor(StaticData.Plane.getArmor() + 1);
                }
            }
        }
        if (StaticData.Plane.getArmorModeTime() > 0) {
            StaticData.Plane.setArmorModeTime(StaticData.Plane.getArmorModeTime() - 1);
        }
        if (StaticData.Plane.getArmorModeTime() <= 0) {
            StaticData.Plane.setArmorMode(false);
            StaticData.Plane.setArmorModeTime(0);
        }
        Refresh();
    }

    public static void Refresh() {
        if (StaticData.Count % 1500 == 0) {
            int tempX = (int) (Math.random() * StaticData.Width);
            int tempY = 0;
            if (StaticData.HeathList.size() < 1) {
                if (tempX > 20 && tempX < StaticData.Width - 20) {
                    StaticData.HeathList.add(new Heath(tempX, tempY, 10));
                }
            }
        }
        if (StaticData.Count % 2500 == 0) {
            int tempX = (int) (Math.random() * StaticData.Width);
            int tempY = 0;
            if (StaticData.ArmorList.size() < 1) {
                if (tempX > 20 && tempX < StaticData.Width - 20) {
                    if (!StaticData.Plane.isArmorMode()) {
                        StaticData.ArmorList.add(new Armor(tempX, tempY, 800));
                    }
                }
            }
        }
        if (StaticData.Floor == 1) {
            int tempX = (int) (Math.random() * StaticData.Width);
            int tempY = 40;
            if (StaticData.BossList.size() < 1) {
                if (StaticData.BossValue == 5 || StaticData.BossHeath < 1500) {
                    if (tempX > 50 && tempX < StaticData.Width - 50) {
                        StaticData.BossList.add(new Boss(tempX, tempY, 1500));
                    } else {
                        StaticData.BossList.add(new Boss(StaticData.Width / 2, tempY, 1500));
                    }
                    if (StaticData.BossValue == 5) {
                        StaticData.BossValue = 0;
                    }
                }
            }
        }
        if (StaticData.Time <= 5) {
            if (StaticData.Count % 250 == 0) {
                int tempX = (int) (Math.random() * StaticData.Width);
                int tempY = -40;
                if (tempX > 20 && tempX < StaticData.Width - 20) {
                    StaticData.EnemyList.add(new Enemy(tempX, tempY, 5, 10));
                }
            }
        }
        if (StaticData.Time >= 5 && StaticData.Time < 25) {
            if (StaticData.Count % 200 == 0) {
                int tempX = (int) (Math.random() * StaticData.Width);
                int tempY = -40;
                if (tempX > 20 && tempX < StaticData.Width - 20) {
                    StaticData.EnemyList.add(new Enemy(tempX, tempY, 7, 15));
                }
            }
        }
        if (StaticData.Time >= 25 && StaticData.Time < 50) {
            if (StaticData.Count % 150 == 0) {
                int tempX = (int) (Math.random() * StaticData.Width);
                int tempY = -40;
                if (tempX > 20 && tempX < StaticData.Width - 20) {
                    StaticData.EnemyList.add(new Enemy(tempX, tempY, 7, 20));
                }
            }
        }
        if (StaticData.Time >= 50 && StaticData.Time < 120) {
            if (StaticData.Count % 125 == 0) {
                int tempX = (int) (Math.random() * StaticData.Width);
                int tempY = -40;
                if (tempX > 20 && tempX < StaticData.Width - 20) {
                    StaticData.EnemyList.add(new Enemy(tempX, tempY, 7, 20));
                }
            }
        }
        if (StaticData.Time >= 120 && StaticData.Time < 180) {
            if (StaticData.Count % 100 == 0) {
                int tempX = (int) (Math.random() * StaticData.Width);
                int tempY = -40;
                if (tempX > 20 && tempX < StaticData.Width - 20) {
                    StaticData.EnemyList.add(new Enemy(tempX, tempY, 10, 25));
                }
            }
        }
        if (StaticData.Time >= 180) {
            if (StaticData.Count % 80 == 0) {
                int tempX = (int) (Math.random() * StaticData.Width);
                int tempY = -40;
                if (tempX > 20 && tempX < StaticData.Width - 20) {
                    StaticData.EnemyList.add(new Enemy(tempX, tempY, 15, 30));
                }
            }
        }
        if (StaticData.Floor == 2) {
            if (StaticData.Count % 200 == 0) {
                int tempX = 800;
                int tempY = (int) (Math.random() * StaticData.Width);
                if (tempY > 20 && tempY < StaticData.Hight - 20) {
                    //第二层敌人
                }
            }
        }
        if (StaticData.Count % StaticData.ShootSpeed == 0) {
            if (StaticData.Plane.isWildMode()) {
                if (StaticData.Score < 350) {
                    if (StaticData.Score >= 15) {
                        if (StaticData.Plane.getHeath() >= 5) {
                            StaticData.BulletList.add(new Bullet(StaticData.Plane.getX() + 28, StaticData.Plane.getY() - 25, 3, 5, 0, 0, false));
                            StaticData.BulletList.add(new Bullet(StaticData.Plane.getX() + 18, StaticData.Plane.getY() - 15, 2, 5, 0, 0, false));
                            StaticData.BulletList.add(new Bullet(StaticData.Plane.getX() + 38, StaticData.Plane.getY() - 15, 2, 5, 0, 0, false));
                            StaticData.ShootSpeed = 20;
                            StaticData.GameSpeed = 10;
                            StaticData.Score -= 15;
                        } else {
                            StaticData.BulletList.add(new Bullet(StaticData.Plane.getX() + 28, StaticData.Plane.getY() - 25, 3, 5, 0, 0, false));
                            StaticData.BulletList.add(new Bullet(StaticData.Plane.getX() + 8, StaticData.Plane.getY() - 15, 3, 5, 0, 0, false));
                            StaticData.BulletList.add(new Bullet(StaticData.Plane.getX() + 48, StaticData.Plane.getY() - 15, 3, 5, 0, 0, false));
                            StaticData.BulletList.add(new Bullet(StaticData.Plane.getX() - 12, StaticData.Plane.getY() - 5, 2, 5, 0, 0, false));
                            StaticData.BulletList.add(new Bullet(StaticData.Plane.getX() + 68, StaticData.Plane.getY() - 5, 2, 5, 0, 0, false));
                            StaticData.ShootSpeed = 20;
                            StaticData.GameSpeed = 10;
                            StaticData.Score -= 15;
                        }
                    } else {
                        StaticData.BulletList.add(new Bullet(StaticData.Plane.getX() + 28, StaticData.Plane.getY() - 20, 5, 5, 0, 0, false));
                        StaticData.ShootSpeed = 20;
                        StaticData.GameSpeed = 10;
                    }
                } else {
                    if (StaticData.Score >= 45) {
                        if (StaticData.Plane.getHeath() >= 5) {
                            StaticData.BulletList.add(new Bullet(StaticData.Plane.getX() + 28, StaticData.Plane.getY() - 50, 2, 5, 0, 0, false));
                            StaticData.BulletList.add(new Bullet(StaticData.Plane.getX() + 43, StaticData.Plane.getY() - 40, 2, 5, 0, 0, false));
                            StaticData.BulletList.add(new Bullet(StaticData.Plane.getX() + 13, StaticData.Plane.getY() - 40, 2, 5, 0, 0, false));
                            StaticData.BulletList.add(new Bullet(StaticData.Plane.getX() + 20, StaticData.Plane.getY() - 25, 1, 5, 0, 0, false));
                            StaticData.BulletList.add(new Bullet(StaticData.Plane.getX() + 36, StaticData.Plane.getY() - 25, 1, 5, 0, 0, false));
                            StaticData.BulletList.add(new Bullet(StaticData.Plane.getX() + 28, StaticData.Plane.getY() - 5, 1, 5, 0, 0, false));
                            StaticData.BulletList.add(new Bullet(StaticData.Plane.getX() + 48, StaticData.Plane.getY() - 5, 1, 5, 0, 0, false));
                            StaticData.BulletList.add(new Bullet(StaticData.Plane.getX() + 68, StaticData.Plane.getY(), 1, 5, 0, 0, false));
                            StaticData.BulletList.add(new Bullet(StaticData.Plane.getX() + 8, StaticData.Plane.getY() - 5, 1, 5, 0, 0, false));
                            StaticData.BulletList.add(new Bullet(StaticData.Plane.getX() - 12, StaticData.Plane.getY(), 1, 5, 0, 0, false));
                            StaticData.ShootSpeed = 20;
                            StaticData.GameSpeed = 10;
                            StaticData.Score -= 45;
                        }
                    } else {
                        StaticData.BulletList.add(new Bullet(StaticData.Plane.getX() + 28, StaticData.Plane.getY() - 20, 5, 5, 0, 0, false));
                        StaticData.ShootSpeed = 20;
                        StaticData.GameSpeed = 10;
                    }
                }
            } else {
                StaticData.BulletList.add(new Bullet(StaticData.Plane.getX() + 28, StaticData.Plane.getY() - 20, 5, 5, 0, 0, false));
                StaticData.ShootSpeed = 20;
                StaticData.GameSpeed = 10;
            }
        }
    }
    public static void Save() throws IOException {
        int bossTime = 0;
        int bossHeath = 1500;
        int bossHeathMax = 1500;
        if (StaticData.BossList.size() > 0) {
            bossTime = StaticData.BossList.get(0).getExisttime();
            bossHeath = StaticData.BossList.get(0).getHeath();
            bossHeathMax = StaticData.BossList.get(0).getHeathMax();
        }
        //读取存档
        FileOutputStream fos = new FileOutputStream("data\\save.properties");
        Properties pro = new Properties();
        pro.setProperty("Time", "" + StaticData.Time);
        pro.setProperty("Coin", "" + StaticData.Coin);
        pro.setProperty("Floor", "" + StaticData.Floor);
        pro.setProperty("PlaneHeath", "" + StaticData.Plane.getHeath());
        pro.setProperty("PlaneHeathMax", "" + StaticData.Plane.getHeathMax());
        pro.setProperty("PlaneArmor", "" + StaticData.Plane.getArmor());
        pro.setProperty("PlaneArmorMax", "" + StaticData.Plane.getArmorMax());
        pro.setProperty("BossHeath", "" + bossHeath);
        pro.setProperty("BossHeathMax", "" + bossHeathMax);
        pro.setProperty("BossTime", "" + bossTime);
        pro.store(fos, "测试数据");
    }
}
