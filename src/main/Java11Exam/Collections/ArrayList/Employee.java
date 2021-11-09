package main.Java11Exam.Collections.ArrayList;

public class Employee implements Comparable<Employee>{
    public String name;
    public int age;
    public String country;
    public Employee(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }
    @Override
    public int compareTo(Employee o) {
        return this.name.compareTo(o.name);
    }
}
