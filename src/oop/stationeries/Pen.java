package oop.stationeries;

public class Pen extends Stationery
{
    protected float diameterStylus;

    public Pen(String name, float diameterStylus, int cost)
    {
        super(name, cost);
        this.diameterStylus = diameterStylus;
    }

    public Pen()
    {
        name = "Pen";
        diameterStylus = 0.5f;
        cost = 30;
    }

    public Pen(String name)
    {
        this.name = name;
        diameterStylus = 0.5f;
        cost = 30;
    }

    public float getDiameterStylus() {
        return diameterStylus;
    }

    public void setDiameterStylus(float diameterStylus) {
        this.diameterStylus = diameterStylus;
    }

    @Override
    public int hashCode()
    {
        return (31 * cost + ((null == name) ? 0 : name.hashCode()));
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null)
        {
            return false;
        }
        if(this == obj)
        {
            return true;
        }
        if(this.getClass() != obj.getClass())
        {
            return false;
        }
        return name.equals(((Pen) obj).name) && cost == ((Pen) obj).cost &&
                diameterStylus == ((Pen) obj).diameterStylus;

    }

    @Override
    public String toString()
    {
        return getClass().getName() + "@\tName: " + name + "\tDiameter stylus: " +
                diameterStylus + "\tCost: " + cost;
    }
}
