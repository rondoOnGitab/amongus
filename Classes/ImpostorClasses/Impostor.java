package Classes.ImpostorClasses;

import Classes.*;
import Classes.CrewmateClasses.*;
import Client.ClientClasses.MyPanel;

public class Impostor extends Entity{
    
     public Impostor(int x, int y,int speed,MyPanel gamePanel, KeyHandler kh){
        super(x, y,speed,gamePanel,kh);
    }

    public void kill(Crewmate crewmate)
    {
        crewmate.killed();
    }
}
