package com.lie.PlaneWars;

import com.lie.PlaneWars.swing.GameFrame;
import com.lie.PlaneWars.swing.LoginFrame;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        FileReader reader = null;
        try {
            reader = new FileReader("./data//save.properties");
            Properties pro = new Properties();
            pro.load(reader);
            com.lie.PlaneWars.StaticData.Time = Integer.parseInt(pro.getProperty("Time"));
            com.lie.PlaneWars.StaticData.Coin = Integer.parseInt(pro.getProperty("Coin"));
            com.lie.PlaneWars.StaticData.Floor = Integer.parseInt(pro.getProperty("Floor"));
            com.lie.PlaneWars.StaticData.PlaneHeath = Integer.parseInt(pro.getProperty("PlaneHeath"));
            com.lie.PlaneWars.StaticData.PlaneHeathMax = Integer.parseInt(pro.getProperty("PlaneHeathMax"));
            com.lie.PlaneWars.StaticData.PlaneArmor = Integer.parseInt(pro.getProperty("PlaneArmor"));
            com.lie.PlaneWars.StaticData.PlaneArmorMax = Integer.parseInt(pro.getProperty("PlaneArmorMax"));
            com.lie.PlaneWars.StaticData.BossHeath = Integer.parseInt(pro.getProperty("BossHeath"));
            com.lie.PlaneWars.StaticData.BossHeathMax = Integer.parseInt(pro.getProperty("BossHeathMax"));
            com.lie.PlaneWars.StaticData.BossTime = Integer.parseInt(pro.getProperty("BossTime"));
            new LoginFrame(960 - StaticData.Width / 2, 700 - StaticData.Hight / 2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
