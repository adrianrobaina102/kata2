package software.ulpgc.katas.control;

import software.ulpgc.katas.model.Employee;
import software.ulpgc.katas.model.Gender;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class EmployeeAnalyzer {
    private final List<Employee> employees;
    public EmployeeAnalyzer(List<Employee> employees) {
        this.employees = employees;
    }
    public Map<Gender, Long> countByGender() {
        return employees.stream()
                .filter(employee -> employee.gender() != null)
                .collect(Collectors.groupingBy(
                Employee::gender,
                Collectors.counting()
        ));
    }
}
