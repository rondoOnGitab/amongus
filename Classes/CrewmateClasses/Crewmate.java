package Classes.CrewmateClasses;

import Classes.*;
import Client.ClientClasses.MyPanel;

import java.util.ArrayList;

public class Crewmate extends Entity{

    private ArrayList<Task> tasks;

    public Crewmate(int x, int y,int speed,MyPanel gamePanel, KeyHandler kh){
        super(x, y,speed,gamePanel,kh);
        this.worldX = x;
        this.worldY = y;

        this.tasks = initializeTasks();
    }

    private ArrayList<Task> initializeTasks()
    {
        return new ArrayList<Task>(); // Implementare la logica por aggiungere per ogni categoria il numero scelto di task
    }

    public boolean isAllTasksCompleted()
    {
        for (Task t : this.tasks)
        {
            if(!t.isCompleted())
                return false;
        }

        return true;
    }

    public void killed()
    {
        this.state = MyState.KILLED;
    }

    public int getX(){
        return this.worldX;
    }

    public int getY(){
        return this.worldY;
    }
}
