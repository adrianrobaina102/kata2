package software.ulpgc.katas;

import software.ulpgc.katas.io.EmployeeReader;
import software.ulpgc.katas.io.UrlEmployeeReader;
import software.ulpgc.katas.model.Employee;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class Main {
    static void main(String[] args) throws MalformedURLException, FileNotFoundException {
        URL url = new URL("https://raw.githubusercontent.com/adrianrobaina102/kata2/refs/heads/iteration-2/employees.txt");
        EmployeeReader reader = new UrlEmployeeReader(url);
        List<Employee> listReader = reader.readAll();
        for (Employee employee : listReader) {
            System.out.println(employee);
        }

    }
}
