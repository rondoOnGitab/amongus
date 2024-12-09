package Classes;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{

    public boolean upPressed,downPressed,rightPressed,leftPressed;

    @Override
    public void keyPressed(KeyEvent e)
    {
        //Utilizzato per il movimento

        int code = e.getKeyCode();

        if(code==KeyEvent.VK_W)
        {
            upPressed=true;
        }
        if(code==KeyEvent.VK_S)
        {
            downPressed=true;
        }
        if(code==KeyEvent.VK_D)
        {
            rightPressed=true;
        }
        if(code==KeyEvent.VK_A)
        {
            leftPressed=true;
        }
        
    }


    @Override
    public void keyReleased(KeyEvent e)
    {
        //Utilizzato per il movimento

        int code = e.getKeyCode();

        if(code==KeyEvent.VK_W)
        {
            upPressed=false;
        }
        if(code==KeyEvent.VK_S)
        {
            downPressed=false;
        }
        if(code==KeyEvent.VK_D)
        {
            rightPressed=false;
        }
        if(code==KeyEvent.VK_A)
        {
            leftPressed=false;
        } 
    }

    
    /*Viene chiamato quando un carattere viene digitato. Invocato solo per i tasti che producono un carattere 
    È utile per gestire l'input di caratteri di testo, come in un campo di testo (Ora come ora non è utile)*/
    @Override
    public void keyTyped(KeyEvent e)
    {
        
    }
    
}

