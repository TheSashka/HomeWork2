package oop.nuclearboat;

/**
 * Created by alexandrgribkov on 21.07.16.
 */
public class NuclearBoat
{
    private int weight;
    private int countRockets;
    private String name;
    private int x, y, deep;
    NuclearBoat()
    {
        weight = 20000;
        countRockets = 25;
        name = "Комсомолец";
        x = 500;
        y = 500;
        deep = 250;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDeep() {
        return deep;
    }

    class NuclearBoatEngine
    {
        private int countOfHP;
        private String typeOfEngine;
        private double engineDiplacement;

        NuclearBoatEngine()
        {

            countOfHP = 1000;
            typeOfEngine = "Diesel";
            engineDiplacement = 15.0;
        }

        public void move(int x, int y)
        {
            NuclearBoat.this.x += x;
            NuclearBoat.this.y += y;
        }

        public void toDeeper(int deep)
        {
            NuclearBoat.this.deep += deep;
        }

    }
    public static void main(String [] args)
    {
        NuclearBoat nuclearBoat = new NuclearBoat();
        nuclearBoat.new NuclearBoatEngine().move(10,15);
        nuclearBoat.new NuclearBoatEngine().toDeeper(35);
        System.out.println(nuclearBoat.getX());
        System.out.println(nuclearBoat.getY());
        System.out.println(nuclearBoat.getDeep());
    }
}
