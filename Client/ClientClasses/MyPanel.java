package Client.ClientClasses;

import Classes.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.security.Key;

import javax.swing.*;


public class MyPanel extends JPanel implements Runnable{
    
    final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    final int screenWidth = (int)screenSize.getWidth();
    final int screenHeight = (int)screenSize.getHeight();

    final int pxTileSize = 16;
    final int scale = 3;
    final int tileSize = scale*pxTileSize;

    final int maxScreenCol = (int)screenWidth/tileSize;
    final int maxScreenRow = (int)screenHeight/tileSize;

    final int FPS = 60;

    KeyHandler kh = new KeyHandler();

    Thread gameThread;

    Entity player;

    public MyPanel()
    {
        this.setPreferredSize(this.screenSize);
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(kh);
        this.setFocusable(true);

        player = new Entity(100, 100, 2, this, this.kh);
    }

    public void startGameThread()
    {
        this.gameThread = new Thread(this);
        this.gameThread.start();
    }

    @Override
    public void run(){

        double drawInterval = 1000000000/this.FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null)
        {
            currentTime = System.nanoTime();
            delta+= (currentTime-lastTime) / drawInterval;
            lastTime=currentTime;

            if(delta>=1){
                update();   //update dei dati/info
                repaint();  //update effettivo a schermo (ridisegna lo schermo con gli update)
                delta--;
            }
        }

    }
    public void update()
    {
        player.update();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D)g;

        player.draw(g2d);

        g2d.dispose();
    }
}