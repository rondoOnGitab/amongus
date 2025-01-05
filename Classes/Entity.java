package Classes;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.imageio.ImageIO;

import Classes.CrewmateClasses.Crewmate;
import Client.ClientClasses.MyPanel;

import java.awt.Color;
import java.awt.Rectangle;

public class Entity implements Runnable{
    protected Thread th;

    protected  String nome;

    protected int worldX;
    protected int worldY;
    protected int speed;

    protected MyState state;
    protected KeyHandler kh;
    protected MyPanel gamePanel;

    protected int spriteNum = 1;
    protected int spriteCounter = 0;
    protected BufferedImage up1, up2, up3, down1, down2, down3, left1, left2, left3, right1, right2, right3;
    protected String direction;

    protected final int screenX;
    protected final int screenY;

    protected Rectangle hitBox;
    protected boolean collisionOn = false;

    protected int defaultX = 0;
    protected int defaultY = 0;

    public Entity(int x, int y, int speed, MyPanel gamePanel, KeyHandler kh) {
        this.nome = "";
        this.worldX = x;
        this.worldY = y;
        this.speed = speed;
        this.state = MyState.ALIVE;
        this.direction = "up";
        this.kh = kh;
        this.gamePanel = gamePanel;
        this.hitBox = new Rectangle(0,0,(int)(this.gamePanel.getTileSize()*0.58),(int)(this.gamePanel.getTileSize()*0.58));

        this.screenX = this.gamePanel.getScreenWidth()/2 - (this.gamePanel.getTileSize()/2);
        this.screenY = this.gamePanel.getScreenHeight()/2 - (this.gamePanel.getTileSize()/2);

        getPlayerImage();
    }

    public void run(){
        try
        {
            DatagramSocket socket = new DatagramSocket();

            InetAddress localHost = InetAddress.getLocalHost();

            String mex = "x: "+this.worldX+" y: "+this.worldY+" dir: "+this.direction+" img: "+this.direction+this.spriteNum;

            byte[] buffer = mex.getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            packet.setAddress(localHost);
            packet.setPort(12345);
            socket.send(packet);

            byte[] bufferRisp = new byte[1500]; //1500 per MTU (cerca cos'è)
            DatagramPacket packetRisp = new DatagramPacket(bufferRisp, bufferRisp.length);
            socket.receive(packetRisp);
            String mexRisp = new String(packetRisp.getData(),0,packetRisp.getLength());
            System.out.println(mexRisp);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public void getPlayerImage(){
        try {
            this.up1 = ImageIO.read(new FileInputStream("Images/Walk0001.png"));
            this.up2 = ImageIO.read(new FileInputStream("Images/Walk0007.png"));
            this.up3 = ImageIO.read(new FileInputStream("Images/Walk0005.png"));
            this.down1 = ImageIO.read(new FileInputStream("Images/Walk0001.png"));
            this.down2 = ImageIO.read(new FileInputStream("Images/Walk0007.png"));
            this.down3 = ImageIO.read(new FileInputStream("Images/Walk0005.png"));
            this.right1 = ImageIO.read(new FileInputStream("Images/Walk0001.png"));
            this.right2 = ImageIO.read(new FileInputStream("Images/Walk0007.png"));
            this.right3 = ImageIO.read(new FileInputStream("Images/Walk0005.png"));
            this.left1 = ImageIO.read(new FileInputStream("Images/Walk00013.png"));
            this.left2 = ImageIO.read(new FileInputStream("Images/Walk00014.png"));
            this.left3 = ImageIO.read(new FileInputStream("Images/Walk00015.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update()
    {
        if (this.kh.upPressed == true || this.kh.downPressed == true || this.kh.leftPressed == true || this.kh.rightPressed == true)
        {
            //Controlla quale sia premuto
            if (this.kh.upPressed == true) {
                this.direction = "up";
            } 
            else if (this.kh.downPressed == true) {
                this.direction = "down";                    
            }
            else if (this.kh.leftPressed == true) {
                this.direction = "left";
            }
            else if (this.kh.rightPressed == true) {
                this.direction = "right";
            }
            
            //Fa l'animazione del player
            this.spriteCounter++;
            if (this.spriteCounter > 12) {
                if (this.spriteNum == 1) {
                    this.spriteNum = 2;
                }
                else if (this.spriteNum == 2) {
                    this.spriteNum = 3;
                }
                else if (this.spriteNum == 3) {
                    this.spriteNum = 1;
                }
                this.spriteCounter = 0;
            }

            //Controllo se non sta collidendo, a quel punto muovo
            this.collisionOn = false;
            this.gamePanel.getCollisionDetector().checkTile(this);

            if(!this.collisionOn)
            {
                switch (this.direction) {
                    case "up":
                        this.worldY -= this.speed;                           
                        break;
                    case "down":
                        this.worldY += this.speed;
                        break;
                    case "left":
                        this.worldX -= this.speed;
                        break;
                    case "right":
                        this.worldX += this.speed;
                        break;
                    default:
                        break;
                   }
            }
        } 
    }

    public void draw(Graphics2D g2d){
            
       // g2d.setColor(Color.WHITE);
       // g2d.fillRect(x, y, 48, 48);

       BufferedImage image = null;

       switch (this.direction) {
        case "up":
            if (this.spriteNum == 1) {
                image = up1;
            }
            if (this.spriteNum == 2) {
                image = up3;
            }
            if (this.spriteNum == 3) {
                image = up2;
            }
            break;
        case "down":
            if (this.spriteNum == 1) {
                image = down1;
            }
            if (this.spriteNum == 2) {
                image = down3;
            }
            if (this.spriteNum == 3) {
                image = down2;
            }
            break;
        case "left":
            if (this.spriteNum == 1) {
                image = left1;
            }
            if (this.spriteNum == 2) {
                image = left3;
            }
            if (this.spriteNum == 3) {
                image = left2;
            }
            break;
        case "right":
            if (this.spriteNum == 1) {
                image = right1;
            }
            if (this.spriteNum == 2) {
                image = right3;
            }
            if (this.spriteNum == 3) {
                image = right2;
            }
            break;
        default:
            break;
       }

       g2d.drawImage(image, this.screenX, this.screenY, this.gamePanel.getTileSize(), this.gamePanel.getTileSize(), null);
    }

    //GETTERS & SETTERS

    public boolean isKilled()
    {
       return this.state == MyState.KILLED ? true:false;
    }

    public MyState getState()
    {
        return this.state;
    }

    public int getWorldX() {
        return this.worldX;
    }

    public int getWorldY() {
        return this.worldY;
    }

    public int getScreenX()
    {
        return this.screenX;
    }

    public int getScreenY()
    {
        return this.screenY;
    }

    public Rectangle getHitBox()
    {
        return this.hitBox;
    }

    public String getDirection()
    {
        return this.direction;
    }

    public int getSpeed()
    {
        return this.speed;
    }

    public boolean isColliding()
    {
        return this.collisionOn;
    }

    public int getDeafultX()
    {
        return this.defaultX;
    }

    public int getDeafultY()
    {
        return this.defaultY;
    }

    public void setCollision(boolean state)
    {
        this.collisionOn = state;
    }
}