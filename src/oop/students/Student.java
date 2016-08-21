package oop.students;

/**
 * Created by alexandrgribkov on 21.07.16.
 */
public class Student<T>
{
    private String name;
    private T mark;

    Student(String name, T mark)
    {
        this.name = name;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getMark() {
        return mark;
    }

    public void setMark(T mark) {
        this.mark = mark;
    }
}
