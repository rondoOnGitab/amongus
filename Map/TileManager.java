package Map;

import Map.Tile;

import java.awt.Graphics2D;
import java.io.FileInputStream;
import java.util.HashMap;

import javax.imageio.ImageIO;

import Client.ClientClasses.MyPanel;

public class TileManager {
    
    private MyPanel gamePanel;
    private Tile[] tiles;
    private int mapTilesNum[][];

    public TileManager(MyPanel gamePanel)
    {
        this.gamePanel = this.gamePanel;
        this.tiles = new Tile[10];
        //this.mapTilesNum = new int [this.this.gamePanel.maxScreenCol][this.this.gamePanel.maxScreenRow];

        getTileImage();
    }

    public void getTileImage()
    {
        try {
            this.tiles[0] = new Tile();
            this.tiles[0].setImage(ImageIO.read(new FileInputStream("Images/Map/New Piskel.png")));
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2d)
    {
        /* 
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while(col < this.gamePanel.getMaxScreenCol() && row < this.gamePanel.getMaxScreenRow())
        {
            g2d.drawImage(this.tiles[0].getImage(),x,y,this.gamePanel.getTileSize(),this.gamePanel.getTileSize(),null);
            col++;
            x += this.gamePanel.getTileSize();

            if(col == this.gamePanel.getMaxScreenCol())
            {
                col = 0;
                x = 0;
                row++;
                y += this.gamePanel.getTileSize();
            }
        }
        */
        /* 
        if(this.tiles[0].getImage() != null)
        {
            g2d.drawImage(this.tiles[0].getImage(),0,0,null); //Cosi funziona 
        }
        */
        /* 
        if(this.tiles[0].getImage() != null)
        {
            g2d.drawImage(this.tiles[0].getImage(),x,y,this.gamePanel.getTileSize(),this.gamePanel.getTileSize(),null); 
            //Cosi non funziona una sega del cazzo
        }
        */
    }

}
