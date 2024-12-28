package Server.ServerClasses;

import Classes.*;
import Client.ClientClasses.GUIHandler;

import java.util.ArrayList;

public class CoordinatesHandler
{
    GUIHandler gh;
    ArrayList<Entity> players;

    public CoordinatesHandler(GUIHandler gh, ArrayList<Entity> players)
    {
        this.gh = gh;
        this.players = players;
    }

    //Controlla le coordinate di player X le manda al GUIHandler.java
    // per sapere il player scorro la lista di player controllo dalla socket l'ip e la port per capire se è il personaggio corretto
}