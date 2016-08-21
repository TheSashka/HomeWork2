package oop.students;

import java.util.ArrayList;
import java.util.Random;

public class Groups
{
    private ArrayList<Group<Discipline, Double>> groups;

    Groups()
    {
        groups = new ArrayList<>();
    }

    public void addGroup(Group<Discipline, Double> group)
    {
        groups.add(group);
    }

    public ArrayList<Group<Discipline, Double>> findGroupWithStudent(String name)
    {
        ArrayList<Group<Discipline, Double>> temp = new ArrayList<Group<Discipline, Double>>();
        for (int i = 0; i < groups.size(); i++)
        {
            if(groups.get(i).isStudent(name))
            {
                temp.add(groups.get(i));
            }
        }
        return temp;
    }

    public String compareRatings(String name, ArrayList<Group<Discipline, Double>> groups)
    {
        if(groups.size() == 0)
        {
            return "Массив пустой";
        }
        double max = 0.0, min = Double.MAX_VALUE, avg = 0.0;
        for(int i = 0; i < groups.size(); i++)
        {
            double var =  Double.parseDouble(groups.get(i).findStudent(name).getMark().toString());
            if(max < var)
            {
                max = var;
            }
            if(min > var)
            {
                min = var;
            }
            avg+=var;
        }
        avg/=groups.size();

        return "Имя студента " + name + "\tМаксимальная оценка: " + max + "\tМинимальная оценка: " + min + "\tСредний балл: " + avg;
    }

    public ArrayList<Student<Integer>> generateGroup(String[] firstName, String[] lastName)
    {
        ArrayList<Student<Integer>> temp = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        for(int i = 0; i < random.nextInt(7)+3; i++)
        {
            builder.append(firstName[random.nextInt(firstName.length)]).append("\t");
            builder.append(lastName[random.nextInt(lastName.length)]);
            temp.add(new Student<>(builder.toString(), random.nextInt(5)+1));
            builder.delete(0, builder.length());
        }

        return temp;
    }


    public static void main(String [] args)
    {
        String [] lastNameMale  = { "Петров", "Васильев", "Смирнов", "Антропов", "Овечкин"};
        String [] firstNameMale = { "Вася", "Петя", "Антон", "Максим", "Сергей"};
        String [] firstNameFemale = {"Аня", "Лера", "Настя", "Маша", "Елена"};
        String [] lastNameFemale = {"Петров", "Смирнова", "Рыбакова", "Новикова", "Осипова"};

        Groups groups = new Groups();


        Group<Discipline, Double> group1 = new Group<>();
        group1.setDiscipline(Discipline.MATHEMATICS);
        group1.addStudent(groups.generateGroup(firstNameMale, lastNameMale));
        group1.addStudent(groups.generateGroup(firstNameFemale, lastNameFemale));

        Group<Discipline, Double> group2 = new Group<>();
        group2.setDiscipline(Discipline.CHEMISTRY);
        group2.addStudent(groups.generateGroup(firstNameMale, lastNameMale));
        group2.addStudent(groups.generateGroup(firstNameFemale, lastNameFemale));

        Group<Discipline, Double> group3 = new Group<>();
        group3.setDiscipline(Discipline.LITERATURE);
        group3.addStudent(groups.generateGroup(firstNameMale, lastNameMale));
        group3.addStudent(groups.generateGroup(firstNameFemale, lastNameFemale));

        Group<Discipline, Double> group4 = new Group<>();
        group4.setDiscipline(Discipline.PHYSICS);
        group4.addStudent(groups.generateGroup(firstNameMale, lastNameMale));
        group4.addStudent(groups.generateGroup(firstNameFemale, lastNameFemale));



        groups.addGroup(group1);
        groups.addGroup(group2);
        groups.addGroup(group3);
        groups.addGroup(group4);
        String name = group1.getStudentByIndex(0).getName();
        ArrayList<Group<Discipline, Double>> groupArrayList = groups.findGroupWithStudent(name);
        System.out.println(groups.compareRatings(name, groupArrayList));
        System.out.println(groupArrayList.size());

    }
}
