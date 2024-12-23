package Map;

import java.awt.image.BufferedImage;

public class Tile{
    
    private BufferedImage image;
    private boolean collision;

    public Tile(boolean collision)
    {
        this.collision = collision;
    }

    public BufferedImage getImage()
    {
        return this.image;
    }

    public void setImage(BufferedImage img)
    {
        this.image = img;
    }

    public boolean isSolid()
    {
        return this.collision;
    }

    public void setCollision(boolean collision)
    {
        this.collision = collision;
    }
}
