package Classes.CrewmateClasses;

import Classes.*;
import java.util.ArrayList;

public class Crewmate extends Entity{

    private ArrayList<Task> tasks;

    public Crewmate(int x, int y){
        super(x, y);
        this.x = x;
        this.y = y;

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

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
}
