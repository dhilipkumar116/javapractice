package com.javapractice;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee implements Comparable<Employee> {

    int id;
    String name;
    double salary;
    int age;

    public Employee(int id, String name, double salary, int age) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public int compareTo(Employee otherEmployee) {
        return Integer.compare(this.id,otherEmployee.id);
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', salary=" + salary + ", age=" + age + "}";
    }
}


class NameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return  e1.name.compareTo(e2.name);
    }
}

class SalaryComparator implements Comparator<Employee> {
    @Override
    public  int compare(Employee e1, Employee e2) {
        return  Double.compare(e1.salary, e2.salary);
    }
}




public class _01_ComparatorAndComparable {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(3, "Alice", 75000, 30));
        employees.add(new Employee(1, "Bob", 50000, 25));
        employees.add(new Employee(2, "Charlie", 60000, 28));
        employees.add(new Employee(4, "David", 75000, 35));

        // 🔹 Sorting using Comparable (Default Sorting by ID)
        Collections.sort(employees);
        System.out.println("Sorted by ID (Using Comparable): " + employees);

        // 🔹 Sorting by Name (Alphabetically)
        employees.sort(new NameComparator());
        System.out.println("Sorted by Name: " + employees);

//        // 🔹 Search by Name (Alphabetically)
//        Employee nameResult = searchByName(employees, "Alice");
//        System.out.println(nameResult != null ? "Found by Name: " + nameResult : "Employee not found.");

    }

    public  static List<Employee> searchByName (List<Employee> employees, String name) {
        return  employees.stream().filter((emp) -> emp.name.equalsIgnoreCase(name)).toList();
    }
}
