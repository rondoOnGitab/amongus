package Classes;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import Client.ClientClasses.MyPanel;

import java.awt.Color;

public class Entity {
    protected  String nome;
    protected int x;
    protected int y;
    protected int speed;
    protected MyState state;
    protected KeyHandler kh;
    protected MyPanel panel;

    public int spriteNum = 1;
    public int spriteCounter = 0;

    public Entity(int x, int y, int speed, MyPanel panel, KeyHandler kh) {
        this.nome = "";
        this.x = x;
        this.y = y;
        this.speed = speed;
        //this.state = MyState.ALIVE;
        this.direction = "up";
        this.kh = kh;
        this.panel = panel;

        getPlayerImage();
    }

    public BufferedImage up1, up2, up3, down1, down2, down3, left1, left2, left3, right1, right2, right3;
    public String direction;

    public void getPlayerImage(){
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/Images/Walk0001.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/Images/Walk0007.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/Images/Walk0005.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/Images/Walk0001.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/Images/Walk0007.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/Images/Walk0005.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/Images/Walk0001.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/Images/Walk0007.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/Images/Walk0005.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/Images/Walk00013.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/Images/Walk00014.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/Images/Walk00015.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update()
    {
        if (kh.upPressed == true || kh.downPressed == true || 
            kh.leftPressed == true || kh.rightPressed == true) {
                if (kh.upPressed == true) {
                    direction = "up";
                    y -= speed;
                } 
                else if (kh.downPressed == true) {
                    direction = "down";
                    y += speed;
                }
                else if (kh.leftPressed == true) {
                    direction = "left";
                    x -= speed;
                }
                else if (kh.rightPressed == true) {
                    direction = "right";
                    x += speed;
                }
        
                spriteCounter++;
                if (spriteCounter > 12) {
                    if (spriteNum == 1) {
                        spriteNum = 2;
                    }
                    else if (spriteNum == 2) {
                        spriteNum = 3;
                    }
                    else if (spriteNum == 3) {
                        spriteNum = 1;
                    }
                    spriteCounter = 0;
                }
        } 
    }

    public void draw(Graphics2D g2d){
        
       // g2d.setColor(Color.WHITE);
       // g2d.fillRect(x, y, 48, 48);

       BufferedImage image = null;

       switch (direction) {
        case "up":
            if (spriteNum == 1) {
                image = up1;
            }
            if (spriteNum == 2) {
                image = up3;
            }
            if (spriteNum == 3) {
                image = up2;
            }
            break;
        case "down":
            if (spriteNum == 1) {
                image = down1;
            }
            if (spriteNum == 2) {
                image = down3;
            }
            if (spriteNum == 3) {
                image = down2;
            }
            break;
        case "left":
            if (spriteNum == 1) {
                image = left1;
            }
            if (spriteNum == 2) {
                image = left3;
            }
            if (spriteNum == 3) {
                image = left2;
            }
            break;
        case "right":
            if (spriteNum == 1) {
                image = right1;
            }
            if (spriteNum == 2) {
                image = right3;
            }
            if (spriteNum == 3) {
                image = right2;
            }
            break;
        default:
            break;
       }

       g2d.drawImage(image, x, y, 48, 48, null);
    }
}
