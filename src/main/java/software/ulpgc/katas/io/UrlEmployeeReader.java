package software.ulpgc.katas.io;

import software.ulpgc.katas.model.Employee;
import software.ulpgc.katas.model.Gender;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class UrlEmployeeReader implements EmployeeReader {
    private final URL url;

    public UrlEmployeeReader(URL url) {
        this.url = url;
    }

    @Override
    public List<Employee> readAll() {
        try {
            return readAll(url.openStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Employee> readAll(InputStream inputStream) {
        try (Reader reader = new InputStreamReader(inputStream)) {
            return readAll(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private List<Employee> readAll(Reader reader) throws IOException {
        return readAll(reader.readAllLines());
    }
    private List<Employee> readAll(List<String> lines) {
        List<Employee> employees = new ArrayList<>();
        lines.stream().skip(1).forEach(line -> employees.add(readAll(line)));
        return employees;
    }
    private Employee readAll(String line) {
        return readAll(line.split("/"));
    }
    private Employee readAll(String[] fields) {
        return new Employee(fields[0], genderOf(fields[1]));
    }
    private Gender genderOf(String field) {
        return field.isEmpty() ? null: Gender.valueOf(field);
    }
}
