package main.Java11Exam.Collections.ArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnderstandingComparableInterface {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Xu", 0, "China"));
        list.add(new Employee("Mia", 50, "USA"));
        list.add(new Employee("Xuing", 5, "Chill"));
        list.add(new Employee("Xuingg", 3, "USA"));

        Collections.sort(list);
        list.forEach(e -> System.out.println(e.name));

        System.out.println("Comparator by age");
        Collections.sort(list, new AgeComparator());
        for (Employee employee : list) {
            System.out.println(employee.age);
        }

        System.out.println("Comparator by name");
        Collections.sort(list, new NameComparator());
        for (Employee employee : list) {
            System.out.println(employee.name);
        }

        Collections.sort(list, (o1, o2) -> o1.name.compareTo(o2.name));

        list.forEach(o -> System.out.print(o.name));

        list.stream().filter(o -> o.age >= 50).map(e -> e.name).forEach(System.out::print);
        list.stream().filter(o->o.country.equals("USA")).map(e->e.name).forEach(System.out::println);

    }
}
