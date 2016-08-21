package oop.stationeries;

/**
 * Created by alexandrgribkov on 21.07.16.
 */
public class HolePuncher extends Stationery
{
    private int maxPage;

    public HolePuncher(String name, int cost, int maxPage)
    {
        super(name, cost);
        this.maxPage = maxPage;
    }

    public HolePuncher()
    {
        name = "HolePuncher";
        cost = 150;
        maxPage = 8;
    }
}
