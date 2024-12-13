package Classes;

public class Crewmate extends Entity{
    public Crewmate(int x, int y){
        super(x, y);
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
}
