package Classes;

public class Entity {
    protected  String nome;
    protected int x;
    protected int y;
    protected int speed;
    protected MyState state;

    public Entity(int x, int y){
        this.nome = "";
        this.x = 0;
        this.y = 0;
        this.speed = 0;
        this.state = MyState.ALIVE;
    }
}
