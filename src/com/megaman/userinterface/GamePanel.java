/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.megaman.userinterface;

import com.megaman.effect.Animation;
import com.megaman.effect.CacheDataLoader;
import com.megaman.effect.FrameImage;
import com.megaman.gameobject.Megaman;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Huy
 */
public class GamePanel extends JPanel implements Runnable, KeyListener {
    
    private Thread thread;
    
    private boolean isRunning;
    
    private InputManger inputManger;
    
    private BufferedImage bufImage;
    private Graphics2D bufG2D;
    
    Megaman megaman = new Megaman(300,300,100,100,0.1f); 
    
    //-FrameImage frame1;
    //-Animation anim1;
    
    
    
    public GamePanel(){
        
        inputManger = new InputManger(this);
        
        bufImage = new BufferedImage(GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT,BufferedImage.TYPE_INT_ARGB);
        
        //-frame1 = CacheDataLoader.getInstance().getFrameImage("idleshoot1");
        //-anim1 = CacheDataLoader.getInstance().getAnimation("robotRbullet");
        //-anim1.flipAllImage();
        
    }
    
    @Override
    public void paint (Graphics g){
        
        g.drawImage(bufImage, 0, 0, this);
    
        //g.setColor(Color.white);
        //g.fillRect(0, 0, GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT);
        
        
        //-frame1.draw(g2,130,130 );
        
        //-anim1.draw(300, 300, g2);
        
        
    }
    
    public void UpDateGame(){
        megaman.update();
        
    }
    
    public void RenderGame(){
        if(bufImage == null){
            bufImage = new BufferedImage(GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT,BufferedImage.TYPE_INT_ARGB);
            
        }
        
        if(bufImage != null){
            bufG2D =  (Graphics2D) bufImage.getGraphics();
        }
        
        if(bufG2D != null){
            
            bufG2D.setColor(Color.white);
            bufG2D.fillRect(0, 0, GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT);
            
            //draw object game here 
            megaman.draw(bufG2D);
            
            //test vẽ vật thể lên khung hình
            //bufG2D.setColor(Color.red);
            //bufG2D.fillRect(40, 50, 100, 100);
            
        }
    }
    
    //star thread 
    public void starGame(){
        isRunning = true;
        if(thread == null){
        thread = new Thread(this);
        thread.start();
        }
    }
    
    @Override
    public void run() {
        // tốc độ khung hình 
        long FPS = 80;
        long period = 1000*1000000/FPS;
        long beginTime;
        long sleepTime;
        
        beginTime = System.nanoTime();
        while(isRunning){
            
            //System.out.println("a = " + a++);
            UpDateGame();
            RenderGame();
            repaint();
            
            //-anim1.Update(System.nanoTime());
            //-repaint();
            
            long deltaTime = System.nanoTime() - beginTime;
            sleepTime = period - deltaTime;
            
            
            try {
                if(sleepTime  > 0)
                    Thread.sleep(sleepTime/1000000);
                else Thread.sleep(period/2000000);
            } catch (InterruptedException ex) {}
            
            beginTime = System.nanoTime();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    
    
    }

    @Override
    public void keyPressed(KeyEvent e) {  //callback method
    
        inputManger.processKeyPressd(e.getKeyCode());
    }
            

    @Override
    public void keyReleased(KeyEvent e) {
    
        inputManger.processKeyReleased(e.getKeyCode());
    }
}
