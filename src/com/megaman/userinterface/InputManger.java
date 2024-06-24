/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.megaman.userinterface;

import java.awt.event.KeyEvent;

/**
 *
 * @author Huy
 */
public class InputManger {
    // Lớp viết để xử lý cho game
    
    public GamePanel gamePanel;
    
    public InputManger(GamePanel gamepanel ){
        this.gamePanel = gamepanel;
    }
    
    public void processKeyPressd(int keyCode){
        
            switch(keyCode){
            case KeyEvent.VK_UP -> {
                System.out.println("UP");
                break;
            }
            
            case KeyEvent.VK_DOWN -> {
                System.out.println("Down");
                break;
            }  
            
            case KeyEvent.VK_LEFT -> {
                
                gamePanel.megaman.setSpeedX(-5);
                break;
            }  
            
            case KeyEvent.VK_RIGHT -> {
                gamePanel.megaman.setSpeedX(5);
                break;
            }
            
            case KeyEvent.VK_ENTER -> {
                System.out.println("enter");
                break;
            }
            
            case KeyEvent.VK_SPACE -> {
                System.out.println("space");
                break;
            }
            
            case KeyEvent.VK_A -> {
                System.out.println("A");
                break;
            }
            
            
            
        
        }
    }
    
    public void processKeyReleased(int keyCode){
        
            switch(keyCode){
            case KeyEvent.VK_UP -> {
                System.out.println("Released UP");
                break;
            }
            
            case KeyEvent.VK_DOWN -> {
                System.out.println("Released Down");
                break;
            }  
            
            case KeyEvent.VK_LEFT -> {
                gamePanel.megaman.setSpeedX(0);
                break;
            }  
            
            case KeyEvent.VK_RIGHT -> {
                gamePanel.megaman.setSpeedX(0);
                break;
            }
            
            case KeyEvent.VK_ENTER -> {
                System.out.println("Released enter");
                break;
            }
            
            case KeyEvent.VK_SPACE -> {
                System.out.println("Released space");
                break;
            }
            
            case KeyEvent.VK_A -> {
                System.out.println("Released A");
                break;
            }
        }
    }
    
}
