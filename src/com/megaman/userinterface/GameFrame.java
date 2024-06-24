/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.megaman.userinterface;

import com.megaman.effect.CacheDataLoader;
import java.awt.Toolkit;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Huy
 */
public class GameFrame extends JFrame {
    public static final int SCREEN_WIDTH = 1000;
    public static final int SCREEN_HEIGHT = 600;
    
    GamePanel gamePanel;
    
    public GameFrame(){
    
        Toolkit toolkit = this.getToolkit();
        Dimension dimension = toolkit.getScreenSize();
        //hàm setBounds dùng để set cái khung hiển thị màn hình
        this.setBounds((dimension.width - SCREEN_WIDTH)/2,(dimension.height - SCREEN_HEIGHT)/2,SCREEN_WIDTH, SCREEN_HEIGHT);
        //dừng game bằng nút EXIT
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        try {
            CacheDataLoader.getInstance().LoadData();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        gamePanel = new GamePanel();
        add(gamePanel);
        gamePanel.starGame();
        
        this.addKeyListener(gamePanel);
        
    }
    
    public void starGame(){
        gamePanel.starGame();
    }
    
    public static void main(String args []){
        
        GameFrame gameFrame = new GameFrame();
        // hiện frame
        gameFrame.setVisible(true);
        gameFrame.starGame(); 
    }
}
