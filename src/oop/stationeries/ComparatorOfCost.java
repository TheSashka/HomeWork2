package oop.stationeries;

import java.util.Comparator;

public class ComparatorOfCost implements Comparator<Stationery> {
    @Override
    public int compare(Stationery o1, Stationery o2) {
        if(o1.getCost() < o2.getCost())
        {
            return -1;
        }
        else if(o1.getCost() == o2.getCost())
        {
            return 0;
        }
        else
        {
            return 1;
        }
    }
}
