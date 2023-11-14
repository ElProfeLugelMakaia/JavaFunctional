import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.*;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class MainStream {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Oscar", "Systems"));
        employees.add(new Employee("Liliana", "Systems"));
        employees.add(new Employee("Fernanda", "Systems"));
        employees.add(new Employee("Manuel", "RH"));
        employees.add(new Employee("Rebeca", "Systems"));
        employees.add(new Employee("Oscar", "Systems"));

        print(employees);

        List<String> res = employees
                .stream()
                    .filter(e -> e.department.equals("Systems"))
                    .sorted()
                    .map(e -> e.name)
                    .distinct()
                .collect(Collectors.toList());

        print(res);


    }

    public static void prevVersion(List<Employee> employees){
        List<Employee> resultado = new ArrayList<>();

        for (Employee e :
                employees) {
            if (e.department.equals("Systems")) {
                resultado.add(e);
            }
        }
        print(resultado);

        List<Employee> distinctRes = new ArrayList<>();

        for (Employee e :
                resultado) {
            if (!exists(distinctRes, e.name)) {
                distinctRes.add(e);
            }
        }
        print(distinctRes);
    }

    public static void print(List employees) {
        for (Object e :
                employees) {
            System.out.print(e + ", ");
        }
        System.out.println("");
    }

    public static boolean exists(List<Employee> employees, String name) {
        for (Employee e :
                employees) {
            if (e.name.equals(name)) return true;
        }
        return false;
    }

}

class Employee implements Comparable<Employee>{
    public String name;
    public String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    @Override
    public String toString() {
        return name + "(" + department + ")";
    }

    @Override
    public int compareTo(Employee e) {
        return this.name.compareTo(e.name);
    }
}