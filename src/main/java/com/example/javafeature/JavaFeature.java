package com.example.javafeature;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaFeature {

    static List<String> nameList = List.of("Santhosh", "Sekar","Developer");

    public static void main(String[] args) {


        optionalMethods();


        findFunctions();



        List<List<String>> consolidatedList = new ArrayList<>();

        consolidatedList.add(nameList);



        List<Employee> employeeList = List.of(new Employee("dev1", 2, 20),
                new Employee("dev2", 3, 10));

        List<Employee> originalList =
                nameList.stream().map(s -> createEmployee(s)).collect(Collectors.toList());

        employeeList.stream().sorted(Comparator.comparing(Employee::age)).forEach( System.out::println);


        List<List<Employee>> consolidatedEmployeeList = new ArrayList<>();

        consolidatedEmployeeList.add(employeeList);
        consolidatedEmployeeList.add(originalList);


        List<Employee> list = consolidatedEmployeeList.stream().flatMap(e -> e.stream()).collect(Collectors.toList());

        List<String> empNameList = consolidatedEmployeeList.stream().flatMap(e -> e.stream()).map(e -> e.empName()).collect(Collectors.toList());


        String[][] array = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

        List<String> list1 = Stream.of(array).flatMap(Stream::of).collect(Collectors.toList());



        Optional<Integer> sumOfLineItems = consolidatedEmployeeList.stream()
                .flatMap(e -> e.stream())    //  Stream<LineItem>
                .map(e -> e.age())                       //  Stream<BigDecimal>
                .reduce((age1, age2) -> age1+age2 );


        List<Integer> ageList = consolidatedEmployeeList.stream()
                .flatMap(e -> e.stream())    //  Stream<LineItem>
                .map(e -> e.age()).collect(Collectors.toList());                       //  Stream<BigDecimal>


        Comparator<Employee> employeeAgeComparator
                = Comparator.comparingInt(Employee::age);

        Arrays.sort(ageList, employeeAgeComparator);
    }

    private static void optionalMethods() {

        Optional<String> optional = Optional.of(null);

        System.out.println(optional.isEmpty());

        System.out.println(optional.isPresent());

        System.out.println(optional.get());

        System.out.println(optional.orElseGet( () ->"Empty"));

        optional.ifPresent(s -> s.concat("ss"));


    }


    private static void findFunctions() {

        String searchString  = nameList.stream().filter(d -> d.startsWith("s")).findFirst().orElseGet( () -> "NOT_FOUND");

        List<String> filteredDataList  = nameList.stream().filter(d -> d.startsWith("s")).collect(Collectors.toList());

        List<String> data2  = nameList.stream().filter(d -> d.startsWith("s")).collect(Collectors.toList());

    }

    private static Employee createEmployee(String empName) {
        return new Employee(empName , 1, 10);
    }

    public record Employee (String empName, int empId, int age){

    }

}
