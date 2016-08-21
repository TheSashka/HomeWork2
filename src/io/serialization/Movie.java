package io.serialization;

import java.io.Serializable;
import java.util.ArrayList;

public class Movie implements Serializable
{
    private String nameOfMovie;
    private ArrayList<Actor> actors;

    public Movie(String nameOfMovie, ArrayList<Actor> actors) {
        this.nameOfMovie = nameOfMovie;
        this.actors = actors;
    }

    public String getNameOfMovie() {
        return nameOfMovie;
    }

    public void setNameOfMovie(String nameOfMovie) {
        this.nameOfMovie = nameOfMovie;
    }

}
