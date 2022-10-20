package ExamPreparation.cafe;

import java.util.ArrayList;
import java.util.List;

public class Cafe {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public Cafe(String name, int capacity) {
        this.employees = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    public void addEmployee(Employee employee) {

        if (capacity > employees.size()) {
            employees.add(employee);
        }
    }

    public boolean removeEmployee(String name) {

        for (int i = 0; i < employees.size(); i++) {

            if (employees.get(i).getName().equals(name)) {
                employees.remove(i);
                return true;
            }
        }
        return false;
    }

    public Employee getOldestEmployee() {
        int age = Integer.MIN_VALUE;
        int index = -1;

        for (int i = 0; i < employees.size(); i++) {
            int currentAge = employees.get(i).getAge();

            if (currentAge > age) {
                age = currentAge;
                index = i;
            }
        }
        return employees.get(index);
    }

    public Employee getEmployee(String name) {

        for (Employee employee : employees) {

            if (employee.getName().equals(name)) {
                return employee;
            }
        }
        return null;
    }

    public int getCount() {
        return employees.size();
    }

    public String report() {
        StringBuilder result = new StringBuilder("Employees working at Cafe " + name + ":\n");

        for (Employee employee : employees) {
            result.append(employee).append("\n");
        }
        return result.toString();
    }
}
