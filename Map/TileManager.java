package Map;

import Map.Tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.HashMap;

import javax.imageio.ImageIO;

import Client.ClientClasses.MyPanel;

public class TileManager {
    
    private MyPanel gamePanel;
    private Tile[] tiles;
    private int mapTilesNum[][];

    public TileManager(MyPanel gamePanel)
    {
        this.gamePanel = gamePanel;

        this.tiles = new Tile[10];
        this.mapTilesNum = new int [this.gamePanel.getMaxWorldCol()][this.gamePanel.getMaxWorldRow()];

        getTileImage();
        loadMap();
    }

    public void getTileImage()
    {
        try {
            this.tiles[0] = new Tile(false);
            this.tiles[0].setImage(ImageIO.read(new FileInputStream("Images/Map/Grass.png")));

            this.tiles[1] = new Tile(true);
            this.tiles[1].setImage(ImageIO.read(new FileInputStream("Images/Map/Wall.png")));

            this.tiles[2] = new Tile(true);
            this.tiles[2].setImage(ImageIO.read(new FileInputStream("Images/Map/Wall2.png")));
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public void loadMap()
    {
        try
        {
            FileReader fr = new FileReader("Map/Map.txt");
            BufferedReader br = new BufferedReader(fr);

            int col = 0;
            int row = 0;

            while(col < this.gamePanel.getMaxWorldCol() && row < this.gamePanel.getMaxWorldRow())
            {
                String line = br.readLine();

                while(col < this.gamePanel.getMaxScreenCol())
                {
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);

                    this.mapTilesNum[col][row] = num;
                    col++;
                }

                if(col == this.gamePanel.getMaxScreenCol())
                {
                    col = 0;
                    row++;
                }
            }
            br.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void draw(Graphics2D g2d)
    {
         
        int worldCol = 0;
        int worldRow = 0;

        while(worldCol < this.gamePanel.getMaxWorldCol() && worldRow < this.gamePanel.getMaxWorldRow())
        {
            int tileNum = this.mapTilesNum[worldCol][worldRow];

            int worldX = worldCol * this.gamePanel.getTileSize();
            int worldY = worldRow * this.gamePanel.getTileSize();
            int screenX = worldX - this.gamePanel.getPlayer().getWorldX() + this.gamePanel.getPlayer().getScreenX();
            int screenY = worldY - this.gamePanel.getPlayer().getWorldY() + this.gamePanel.getPlayer().getScreenY();

            g2d.drawImage(this.tiles[tileNum].getImage(), screenX, screenY,this.gamePanel.getTileSize(),this.gamePanel.getTileSize(),null);
            worldCol++;

            if(worldCol == this.gamePanel.getMaxScreenCol())
            {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}