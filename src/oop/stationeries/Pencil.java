package oop.stationeries;


public class Pencil extends Pen
{
    public Pencil(String name, float diameterStylus, int cost)
    {
        super(name, diameterStylus, cost);
    }

    public Pencil()
    {
        this("Pencil");
    }

    public Pencil(String name)
    {
        this.name = name;
        diameterStylus = 0.5f;
        cost = 15;
    }
}
