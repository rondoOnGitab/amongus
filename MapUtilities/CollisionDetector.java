package MapUtilities;

import Classes.*;
import Classes.CrewmateClasses.*;
import Classes.ImpostorClasses.*;
import Client.ClientClasses.MyPanel;

public class CollisionDetector {
    
    MyPanel gamePanel;

    public CollisionDetector(MyPanel gamePanel)
    {
        this.gamePanel = gamePanel;
    }

    public void checkTile(Entity e)
    {
        //Coordinate assolute della mappa
        int entityLeftWorldX = e.getWorldX()+e.getHitBox().x;
        int entityRightWorldX = e.getWorldX()+e.getHitBox().x+e.getHitBox().width;
        int entityTopWorldY = e.getWorldY()+e.getHitBox().y;
        int entityBottomWorldY = e.getWorldY()+e.getHitBox().y+e.getHitBox().height;

        //Coordinate assolute della matrice della mappa (dei tile)
        int entityLeftCol = entityLeftWorldX/this.gamePanel.getTileSize();
        int entityRightCol = entityRightWorldX/this.gamePanel.getTileSize();
        int entityTopRow = entityTopWorldY/this.gamePanel.getTileSize();
        int entityBottomRow = entityBottomWorldY/this.gamePanel.getTileSize();

        //Si controllano le 2 caselle nella direzione in cui stiamo andando per capire se stiamo collidendo o meno
        int tileN1,tileN2;

        switch (e.getDirection()) {
            case "up":
                entityTopRow = (entityTopWorldY-e.getSpeed())/this.gamePanel.getTileSize();
                tileN1 = this.gamePanel.getTileManager().getMapTileNumByIndexes(entityLeftCol,entityTopRow);
                tileN2 = this.gamePanel.getTileManager().getMapTileNumByIndexes(entityRightCol,entityTopRow);
                
                //Se uno dei 2 tile è 'collidabile' allora l'entity sta collidendo e lo settiamo a true se è vero a false se non lo è
                e.setCollision(this.gamePanel.getTileManager().getTileByIndex(tileN1).getCollision() || this.gamePanel.getTileManager().getTileByIndex(tileN2).getCollision());
                break;
            case "down":
                entityBottomRow = (entityBottomWorldY+e.getSpeed())/this.gamePanel.getTileSize();
                tileN1 = this.gamePanel.getTileManager().getMapTileNumByIndexes(entityLeftCol,entityBottomRow);
                tileN2 = this.gamePanel.getTileManager().getMapTileNumByIndexes(entityRightCol,entityBottomRow);
                
                e.setCollision(this.gamePanel.getTileManager().getTileByIndex(tileN1).getCollision() || this.gamePanel.getTileManager().getTileByIndex(tileN2).getCollision());
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX-e.getSpeed())/this.gamePanel.getTileSize();
                tileN1 = this.gamePanel.getTileManager().getMapTileNumByIndexes(entityLeftCol,entityTopRow);
                tileN2 = this.gamePanel.getTileManager().getMapTileNumByIndexes(entityLeftCol,entityBottomRow);
                
                e.setCollision(this.gamePanel.getTileManager().getTileByIndex(tileN1).getCollision() || this.gamePanel.getTileManager().getTileByIndex(tileN2).getCollision());
                break;
            case "right":
                entityRightCol = (entityRightWorldX+e.getSpeed())/this.gamePanel.getTileSize();
                tileN1 = this.gamePanel.getTileManager().getMapTileNumByIndexes(entityRightCol,entityTopRow);
                tileN2 = this.gamePanel.getTileManager().getMapTileNumByIndexes(entityRightCol,entityBottomRow);
                
                e.setCollision(this.gamePanel.getTileManager().getTileByIndex(tileN1).getCollision() || this.gamePanel.getTileManager().getTileByIndex(tileN2).getCollision());
                break;
            default:
                break;
        }
    }
}
