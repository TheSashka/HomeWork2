package oop.students;

import java.util.ArrayList;

public class Group<Discipline, T>
{
    private Discipline discipline;
    private ArrayList<Student> students;

    Group()
    {
        students = new ArrayList<>();
    }

    public Discipline getDiscipline()
    {
        return discipline;
    }

    public void setDiscipline(Discipline discipline)
    {
        this.discipline = discipline;
    }


    public void addStudent(Student<T> student)
    {
        students.add(student);
    }

    public void addStudent(String name, T mark)
    {
        students.add(new Student<>(name, mark));
    }

    public void addStudent(ArrayList<Student<Integer>> students)
    {
        this.students.addAll(students);
    }

    public Student getStudentByIndex(int index)
    {
        return students.get(index);
    }

    public int getSize()
    {
        return students.size();
    }



    public boolean isStudent(String name)
    {
        for (int i = 0; i < students.size(); i++)
        {
            if(students.get(i).getName().equals(name))
            {
                return true;
            }
        }
        return false;
    }

    public Student findStudent(String name)
    {
        for (int i = 0; i < students.size(); i++)
        {
            if(name.equals(students.get(i).getName()))
            {
                return students.get(i);
            }
        }
        return null;
    }


}
