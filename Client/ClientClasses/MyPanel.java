package Client.ClientClasses;

import Classes.*;
import Map.TileManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.security.Key;

import javax.swing.*;


public class MyPanel extends JPanel implements Runnable{
    
    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    private final int screenWidth = (int)screenSize.getWidth();
    private final int screenHeight = (int)screenSize.getHeight();

    private final int originalTileSize = 16; //grandezza degli sprite, dei tile
    private final int scale = 6; //ordine per cui lo moltiplichiamo
    private final int tileSize = scale*originalTileSize; // cambiamo uno tra originalTileSize o scale per avere una grandezza migliore

    private final int maxScreenCol = (int)screenWidth/tileSize; //20 col con scale x6
    private final int maxScreenRow = (int)screenHeight/tileSize;//11 row con scale x6

    private final int FPS = 60;

    private TileManager tileManager = new TileManager(this);

    private KeyHandler kh = new KeyHandler();

    private Thread gameThread;

    private Entity player;

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

        tileManager.draw(g2d);

        player.draw(g2d);

        g2d.dispose();
    }

    public int getTileSize()
    {
        return this.tileSize;
    }

    public int getMaxScreenCol()
    {
        return this.maxScreenCol;
    }

    public int getMaxScreenRow()
    {
        return this.maxScreenRow;
    }
}