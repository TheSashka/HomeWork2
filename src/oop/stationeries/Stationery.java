package oop.stationeries;

public abstract class Stationery
{
    protected String name;
    protected int cost;

    public Stationery()
    {

    }

    @Override
    public String toString()
    {
        return "Stationery{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }

    public Stationery(String name, int cost)
    {
        this.name = name;
        this.cost = cost;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
