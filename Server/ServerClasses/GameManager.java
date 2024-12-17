package Server.ServerClasses;

public class GameManager extends Thread{
    
    private GameState state;

    public GameManager()
    {
        this.state = new GameState();
    }

    public void run()
    {
        while(true)
        {
            if(this.state.checkKilled())
            {

            }
            if(this.state.checkTasks())
            {

            }

        }   
    }

}
