package io.serialization;

import java.io.Serializable;


public class Actor implements Serializable
{
    private String firstName;
    private String lastName;
    private int older;

    public Actor(String firstName, String lastName, int older)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.older = older;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getOlder() {
        return older;
    }

    public void setOlder(int older) {
        this.older = older;
    }
}
