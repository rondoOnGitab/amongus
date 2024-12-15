package Server.ServerClasses;

import java.util.ArrayList;

import Classes.*;

public class GameState {
    
    private ArrayList<Entity> players;
    private boolean isGameOver;

    public GameState()
    {
        this.players = new ArrayList<Entity>();
        this.isGameOver = false;
    }

    public void checkTasks()
    {
        for (Entity e : this.players)
        {
            //Controlla sia crewmate se lo è guarda che ha finito tutte le task se tutti le hanno finite isGameOver = true
            //La GameManager (thread) si occupa poi di far finire il gioco
            if(e instanceof Crewmate)
            {
                if(!((Crewmate)e).isAllTasksCompleted())
                    return;
            }
        }

        this.isGameOver = true;
    }

    public void checkKilled()
    {
        for (Entity e : this.players)
        {
            //Controlla sia crewmate se lo è guarda se è morto se nImp == nCrew isGameOver = true
            //La GameManager (thread) si occupa poi di far finire il gioco
        }

        this.isGameOver = true;
    }
}
