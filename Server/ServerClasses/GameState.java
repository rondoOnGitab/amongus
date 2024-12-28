package Server.ServerClasses;

import java.util.ArrayList;

import Classes.*;
import Classes.CrewmateClasses.*;
import Classes.ImpostorClasses.*;

public class GameState { //Non è un thread è un gestore
    
    private ArrayList<Entity> players;
    private final int nImpo;
    private final int nCrew;

    public GameState()
    {
        this.players = new ArrayList<Entity>();
        this.nImpo = this.numberOfImposters();
        this.nCrew = this.players.size()-this.nImpo;
    }

    public synchronized boolean checkTasks()
    {
        for (Entity e : this.players)
        {
            if(e instanceof Crewmate)
            {
                if(!((Crewmate)e).isAllTasksCompleted())
                    return false;
            }
        }

       return true;
    }

    public synchronized boolean checkKilled()
    {
        int killedCrewmates = 0;
    
        for (Entity e : this.players)
        {
            if (e instanceof Crewmate) 
            {
                Crewmate crewmate = (Crewmate) e;
    
                if (crewmate.isKilled()) {
                    killedCrewmates++;
                }
            }
        }

        if ((this.nCrew-killedCrewmates) <= this.nImpo)
            return true;
    
        return false;
    }
    

    public synchronized boolean isFinished()
    {
        return this.checkKilled() || this.checkTasks() ? true:false;
    }

    private int numberOfImposters()
    {
        int counter = 0;

        for (Entity e : this.players)
        {
            if(e instanceof Impostor)
                counter++;
        }          

        return counter;
    }
}
