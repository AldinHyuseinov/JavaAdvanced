package DefiningClasses.CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int linesOfInfo = Integer.parseInt(scanner.nextLine());
        Map<String, List<Employee>> employeesAndDepartments = new HashMap<>();

        for (int i = 0; i < linesOfInfo; i++) {
            String[] info = scanner.nextLine().split(" ");
            double salary = Double.parseDouble(info[1]);
            Employee employee;

            if (info.length == 6) {
                employee = new Employee(info[0], salary, info[2], info[3], info[4], Integer.parseInt(info[5]));
            } else if (info.length == 4) {
                employee = new Employee(info[0], salary, info[2], info[3]);
            } else {

                if (info[4].matches("\\d+")) {
                    employee = new Employee(info[0], salary, info[2], info[3], Integer.parseInt(info[4]));
                } else {
                    employee = new Employee(info[0], salary, info[2], info[3], info[4]);
                }
            }

            if (!employeesAndDepartments.containsKey(info[3])) {
                employeesAndDepartments.put(info[3], new ArrayList<>());
            }
            employeesAndDepartments.get(info[3]).add(employee);
        }
        double highestAvg = Double.MIN_VALUE;
        String department = "";

        for (Map.Entry<String, List<Employee>> entry : employeesAndDepartments.entrySet()) {
            double avg = 0;

            for (Employee employee : entry.getValue()) {
                avg += employee.getSalary();
            }
            avg /= entry.getValue().size();

            if (highestAvg < avg) {
                highestAvg = avg;
                department = entry.getKey();
            }
        }
        System.out.println("Highest Average Salary: " + department);
        employeesAndDepartments.get(department).stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).forEach(employee -> System.out.printf("%s %.2f %s %d%n", employee.name, employee.salary, employee.email, employee.age));
    }
}
