package Map;

import java.awt.image.BufferedImage;

public class Tile{
    
    private BufferedImage image;
    private boolean collision = false;

    public Tile()
    {
        
    }

    public BufferedImage getImage()
    {
        return this.image;
    }

    public void setImage(BufferedImage img)
    {
        this.image = img;
    }
}