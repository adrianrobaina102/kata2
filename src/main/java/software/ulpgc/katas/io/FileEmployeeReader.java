package software.ulpgc.katas.io;

import software.ulpgc.katas.model.Employee;
import software.ulpgc.katas.model.Gender;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileEmployeeReader implements EmployeeReader {
    private final File file;
    public FileEmployeeReader(File file) {
        this.file = file;
    }
    @Override
    public List<Employee> readAll() {
        try {
            return readAll(file.toPath());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    private List<Employee> readAll(Path path) throws IOException {
        return readAll(Files.readAllLines(path));
    }
    private List<Employee> readAll(List<String> lines) {
        List<Employee> employees = new ArrayList<>();
        lines.stream().skip(1).forEach(line -> employees.add(readAll(line)));
        return employees;
    }
    private Employee readAll(String line) { return readAll(line.split("/"));}
    private Employee readAll(String[] fields) {
        return new Employee(fields[0], genderOf(fields[1]));
    }
    private Gender genderOf(String field) {
        return field.isEmpty() ? null : Gender.valueOf(field);
    }
}
