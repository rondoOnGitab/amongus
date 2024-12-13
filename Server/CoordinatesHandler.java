package Server;

import Client.GUIHandler;

public class CoordinatesHandler extends Thread
{
    GUIHandler gh;
    public CoordinatesHandler(GUIHandler gh)
    {
        this.gh = gh;
    }

    public void run()
    {
        while(true)
        {
            //Controlla le coordinate di player X le manda al GUIHandler.java
            // per sapere il player scorro la lista di player controllo dalla socket l'ip e la port per capire se è il personaggio corretto
        }
    }
}