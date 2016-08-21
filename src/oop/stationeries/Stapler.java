package oop.stationeries;

/**
 * Created by alexandrgribkov on 21.07.16.
 */
public class Stapler extends Stationery
{

    private float bracketLength;
    private int maxPage; //Максимальное количество страниц, которое можно скрепить за раз
    Stapler(String name, int cost, float bracketLength, int maxPage)
    {
        super(name, cost);
        this.bracketLength = bracketLength;
        this.maxPage = maxPage;
    }

    Stapler()
    {
        name = "Stapler";
        cost = 150;
        bracketLength = 0.8f;
        maxPage = 25;
    }

}
