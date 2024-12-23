package Classes;

import java.awt.Rectangle;

import Client.ClientClasses.MyPanel;

public class EventHandler {
    MyPanel gamePanel;
    Rectangle eventRect;
    int eventRectDefaultX, eventRectDefaultY;

    public EventHandler (MyPanel gamePanel) {
        this.gamePanel = gamePanel;

        eventRect = new Rectangle();
        eventRect.x = 23;
        eventRect.y = 23;
        eventRect.width = 2;
        eventRect.height = 2;
        eventRectDefaultX = eventRect.x;
        eventRectDefaultY = eventRect.y;
    }

    public void checkEvent(){
        
    }

    public boolean hit(int eventCol, int eventRow, String reqDirection){
        boolean hit = false;

        gamePanel.getPlayer().getHitBox().x = gamePanel.getPlayer().worldX + gamePanel.getPlayer().getHitBox().x;
        gamePanel.getPlayer().getHitBox().y = gamePanel.getPlayer().worldY + gamePanel.getPlayer().getHitBox().y;
        eventRect.x = eventCol*gamePanel.getTileSize() + eventRect.x;
        eventRect.y = eventRow*gamePanel.getTileSize() + eventRect.y;

        if (gamePanel.getPlayer().getHitBox().intersects(eventRect)) {
            if (gamePanel.getPlayer().getDirection().contentEquals(reqDirection) || reqDirection.contentEquals("any")) {
                hit = true;
            }
        }

        gamePanel.getPlayer().getHitBox().x = gamePanel.getPlayer().getHitBoxx();
        gamePanel.getPlayer().getHitBox().y = gamePanel.getPlayer().getHitBoxy();
        eventRect.x = eventRectDefaultX;
        eventRect.y = eventRectDefaultY;

        return hit;
    }
}
