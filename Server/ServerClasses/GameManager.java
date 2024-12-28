package Server.ServerClasses;

public class GameManager extends Thread{
    
    private GameState state;
    private CoordinatesHandler ch;

    public GameManager() //Ogni volta che riceve un messaggio fa quello che deve fare è un thread
    {
        this.state = new GameState();
        //this.ch = new CoordinatesHandler(null);
    }

    public void run()
    {
        while(true)
        {   
            if(this.state.isFinished())
            {
                
            }
        }   
    }
}
