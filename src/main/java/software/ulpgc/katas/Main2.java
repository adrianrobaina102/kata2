package software.ulpgc.katas;

import software.ulpgc.katas.io.EmployeeAnalyzer;
import software.ulpgc.katas.io.EmployeeReader;
import software.ulpgc.katas.io.FileEmployeeReader;
import software.ulpgc.katas.model.Employee;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class Main2 {
    static void main(String args[]) throws FileNotFoundException {
        File file = new File("employees.txt");
        EmployeeReader reader = new FileEmployeeReader(file);
        List<Employee> employees = reader.readAll();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        EmployeeAnalyzer analyzer = new EmployeeAnalyzer(employees);
        System.out.println(analyzer.countByGender());
    }
}
