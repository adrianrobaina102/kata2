package software.ulpgc.katas;

import software.ulpgc.katas.control.EmployeeAnalyzer;
import software.ulpgc.katas.io.*;
import software.ulpgc.katas.model.Employee;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class Main2 {
    static void main(String args[]) throws IOException {
        File file = new File("employees.txt");
        EmployeeReader reader = new FileEmployeeReader(file);
        List<Employee> employees = reader.readAll();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        EmployeeAnalyzer analyzer = new EmployeeAnalyzer(employees);
        EmployeeSummaryWriter writer = new StreamEmployeeSummaryWriter(System.out);
        EmployeeSummaryWriter fileWriter = new StreamEmployeeSummaryWriter(new FileOutputStream("stats.txt"));
        fileWriter.write(analyzer.countByGender());
        writer.write(analyzer.countByGender());
    }
}
