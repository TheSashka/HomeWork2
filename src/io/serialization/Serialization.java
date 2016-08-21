package io.serialization;

import com.sun.tools.javac.util.ArrayUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Serialization
{
    private File file;
    public Serialization(File file)
    {
        this.file = file;
    }
    public void serializationObject(ArrayList<Movie> arrayList)
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file)))
        {
            oos.writeObject(arrayList);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public ArrayList<Movie> deserializationObject()
    {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file)))
        {
            return (ArrayList<Movie>) ois.readObject();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static void main(String [] args)
    {
        ArrayList<Movie> movies = new ArrayList<>();
        ArrayList<Actor> actors = new ArrayList<>();
        actors.add(new Actor("Вася", "Федечкин", 35));
        actors.add(new Actor("Петр", "Федечкин", 35));
        actors.add(new Actor("Вася", "Федечкин", 35));
        actors.add(new Actor("Вася", "Федечкин", 35));
        actors.add(new Actor("Вася", "Федечкин", 35));
        movies.add(new Movie("Star wars", actors));
        ArrayList<Actor> actors1 = new ArrayList<>();
        actors1.add(new Actor("Петя", "Пупкин", 21));
        actors1.add(new Actor("Петя", "Пупкин", 21));
        actors1.add(new Actor("Петя", "Пупкин", 21));
        actors1.add(new Actor("Петя", "Пупкин", 21));
        actors1.add(new Actor("Петя", "Пупкин", 21));
        movies.add(new Movie("Властелин колец", actors1));

        File file = new File("./src/io/serialization/test.txt");

        Serialization serialization = new Serialization(file);
        serialization.serializationObject(movies);
        ArrayList<Movie> movies1 = serialization.deserializationObject();
        for(int i = 0; i < movies1.size(); i++)
        {
            System.out.println(movies1.get(i).getNameOfMovie());
        }
        ArrayList<Actor> actors2 = new ArrayList<>();
        actors2.add(new Actor("Андрей","Петров", 27));
        actors2.add(new Actor("Андрей","Петров", 27));
        actors2.add(new Actor("Андрей","Петров", 27));
        actors2.add(new Actor("Андрей","Петров", 27));
        actors2.add(new Actor("Андрей","Петров", 27));
        movies1.add(new Movie("Startrek", actors2));

        serialization.serializationObject(movies1);
        movies1 = serialization.deserializationObject();
        for(int i = 0; i < movies1.size(); i++)
        {
            System.out.println(movies1.get(i).getNameOfMovie());
        }
    }
}
