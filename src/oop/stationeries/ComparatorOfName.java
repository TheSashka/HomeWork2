package oop.stationeries;

import java.util.Comparator;

/**
 * Created by alexandrgribkov on 22.07.16.
 */
public class ComparatorOfName implements Comparator<Stationery>
{
    @Override
    public int compare(Stationery o1, Stationery o2)
    {
        if(o1.getName().codePointAt(0) < o2.getName().codePointAt(0))
        {
            return -1;
        }
        else if(o1.getName().codePointAt(0) == o2.getName().codePointAt(0))
        {
            return 0;
        }
        else
        {
            return 1;
        }
    }
}
