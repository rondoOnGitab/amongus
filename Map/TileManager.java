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
        this.mapTilesNum = new int [this.gamePanel.getMaxScreenCol()][this.gamePanel.getMaxScreenRow()];

        getTileImage();
        loadMap();
    }

    public void getTileImage()
    {
        try {
            this.tiles[0] = new Tile();
            this.tiles[0].setImage(ImageIO.read(new FileInputStream("Images/Map/Grass.png")));

            this.tiles[1] = new Tile();
            this.tiles[1].setImage(ImageIO.read(new FileInputStream("Images/Map/Wall.png")));

            this.tiles[2] = new Tile();
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

            while(col < this.gamePanel.getMaxScreenCol() && row < this.gamePanel.getMaxScreenRow())
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
         
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while(col < this.gamePanel.getMaxScreenCol() && row < this.gamePanel.getMaxScreenRow())
        {
            int tileNum = this.mapTilesNum[col][row];

            g2d.drawImage(this.tiles[tileNum].getImage(),x,y,this.gamePanel.getTileSize(),this.gamePanel.getTileSize(),null);
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
    }
}