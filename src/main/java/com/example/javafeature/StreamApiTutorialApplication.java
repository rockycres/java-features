package com.dailycodebuffer.streamapi;

import com.example.javafeature.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class StreamApiTutorialApplication {

    static List<Employee> employees = new ArrayList<>();
    static {
        employees.add(
                new Employee("Shabbir", "Dawoodi", 5000.0, List.of("Project 1","Project 2"))
        );

        employees.add(
                new Employee("Nikhil", "Gupta", 1000.0, List.of("Project 1","Project 3"))
        );

        employees.add(
                new Employee("Shivam", "Kumar", 5500.0, List.of("Project 3","Project 4"))
        );

    }

    public static void main(String[] args) {
        //SpringApplication.run(StreamApiTutorialApplication.class, args);

        //foreach
        employees.stream()
                .forEach(employee -> System.out.println(employee));


        //map
        //collect
        List<String> nameList = employees.stream().map(employee -> employee.getFirstName()).collect(Collectors.toList());
        System.out.println(nameList);


        //filter
        //findFirst

        Employee emp = employees.stream().filter(employee -> employee.getFirstName().startsWith("S")).findFirst().orElse(null);
        System.out.println(emp);




        //flatMap
        List<String> projectList = employees.stream().map(employee -> employee.getProjects()).flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(projectList);

        //short Circuit operations

        List<Employee> employeeList = employees.stream().skip(1).limit(2).collect(Collectors.toList());
        System.out.println(employeeList);




        //sorting

        List<Employee> sortedList = employees.stream().sorted(Comparator.comparing(Employee::getSalary)).collect(Collectors.toList());
        System.out.println(sortedList);


        //min or max

        Employee lowestSalEmp = employees.stream().min(Comparator.comparing(Employee::getSalary)).orElse(null);
        System.out.println(lowestSalEmp);


        //reduce
        Double totalSal = employees.stream().map(e -> e.getSalary()).reduce( 0.0,  Double::sum);
        System.out.println(lowestSalEmp);




    }

}


