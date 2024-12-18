package Server.ServerClasses;

import java.util.ArrayList;

import Classes.*;
import Classes.CrewmateClasses.*;
import Classes.ImpostorClasses.*;

public class GameState {
    
    private ArrayList<Entity> players;

    public GameState()
    {
        this.players = new ArrayList<Entity>();
    }

    public boolean checkTasks()
    {
        for (Entity e : this.players)
        {
            //Controlla sia crewmate se lo è guarda che ha finito tutte le task se tutti le hanno finite isGameOver = true
            //La GameManager (thread) si occupa poi di far finire il gioco
            if(e instanceof Crewmate)
            {
                if(!((Crewmate)e).isAllTasksCompleted())
                    return false;
            }
        }

       return true;
    }

    public boolean checkKilled()
    {
        for (Entity e : this.players)
        {
            //Controlla sia crewmate se lo è guarda se è morto se nImp == nCrew isGameOver = true
            //La GameManager (thread) si occupa poi di far finire il gioco
        }

        return true;
    }

    public synchronized boolean isFinished()
    {
        return true;
    }
}
