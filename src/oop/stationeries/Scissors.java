package oop.stationeries;

/**
 * Created by alexandrgribkov on 21.07.16.
 */
public class Scissors extends Stationery
{
    private int length;

    Scissors(String name, int cost, int length)
    {
        super(name, cost);
        this.length = length;
    }

    Scissors()
    {
        name = "Scissors";
        cost = 80;
        length = 150;
    }

}
