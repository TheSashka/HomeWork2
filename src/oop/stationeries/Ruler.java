package oop.stationeries;

/**
 * Created by alexandrgribkov on 21.07.16.
 */
public class Ruler extends Stationery
{
    private int length;

    public Ruler(int length)
    {
        name = "Ruler";
        cost = 45;
        this.length = length;
    }
    public Ruler(String name, int cost, int length)
    {
        super(name, cost);
        this.length = length;
    }

    public Ruler()
    {
        this(30);
    }
}
