package Classes;

public class Task {
    protected String nome;
    protected int points;
    protected boolean isCompleted;

    public Task(String nome, int points)
    {
        this.nome = nome;
        this.points = points;
        this.isCompleted = false;
    }

    public boolean isCompleted()
    {
        return this.isCompleted;
    }

    public void completeTask()
    {
        this.isCompleted = true;
    }
}
