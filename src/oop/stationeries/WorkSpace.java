package oop.stationeries;

import java.util.ArrayList;
import java.util.Comparator;

public class WorkSpace
{
    public int costOfStationeries(ArrayList<Stationery> stationeries)
    {
        int sum = 0;
        for(int i = 0; i < stationeries.size(); i++)
        {
            sum+= stationeries.get(i).getCost();
        }
        return sum;
    }

    public void showStationeries(ArrayList<Stationery> stationeries)
    {
        for(int i = 0; i < stationeries.size(); i++)
        {
            System.out.println(stationeries.get(i).toString());
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        Comparator<Stationery> stationeryComparatorCost = new ComparatorOfCost();
        Comparator<Stationery> stationeryComparatorName = new ComparatorOfName();
        Comparator<Stationery> stationeryComparatorCostAndName = new ComparatorOfCostAndName();
        ArrayList<Stationery> stationeries = new ArrayList<>();

        stationeries.add(new Pen());
        stationeries.add(new Pencil());
        stationeries.add(new HolePuncher());
        stationeries.add(new Ruler());
        stationeries.add(new Scissors());
        stationeries.add(new Stapler());
        stationeries.sort(stationeryComparatorCost);

        WorkSpace workSpace = new WorkSpace();
        System.out.println(workSpace.costOfStationeries(stationeries));
        workSpace.showStationeries(stationeries);
        stationeries.sort(stationeryComparatorName);
        workSpace.showStationeries(stationeries);
        stationeries.sort(stationeryComparatorCostAndName);
        workSpace.showStationeries(stationeries);
    }
}
