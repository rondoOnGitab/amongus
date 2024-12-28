package Client.ClientClasses;

import Server.ServerClasses.CoordinatesHandler;

public class GUIHandler extends Thread{
    
    private MyPanel gamePanel;
    private CoordinatesHandler ch;

    public GUIHandler(MyPanel gamePanel)
    {
        this.gamePanel = gamePanel;
        this.ch = new CoordinatesHandler(this,this.gamePanel.getPlayers());
    }

    public void run()
    {
        while(true)
        {
            
        }
    }
}
