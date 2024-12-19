package Map;

import Map.Tile;

import java.awt.Graphics2D;
import java.util.HashMap;

import Client.ClientClasses.MyPanel;

public class TileManager {
    
    private MyPanel gamePanel;
    private HashMap<String,Tile> tiles;
    private int mapTilesNum[][];

    public TileManager(MyPanel gamePanel)
    {
        this.gamePanel = gamePanel;
        this.tiles = new HashMap<String,Tile>();
        //this.mapTilesNum = new int [this.gamePanel.maxScreenCol][this.gamePanel.maxScreenRow];
    }

    public void getTileImage()
    {
        try {
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2d)
    {
       // g2d.drawImage();
    }

}
