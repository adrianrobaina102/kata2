package software.ulpgc.katas.io;

import software.ulpgc.katas.model.Iris;
import software.ulpgc.katas.model.Species;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileIrisReader implements IrisReader{
    private final File file;

    public FileIrisReader(File file) {
        this.file = file;
    }

    @Override
    public List<Iris> readAll() {
        try{
            return readAll(file.toPath());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private List<Iris> readAll(Path path) throws IOException {
        return readAll(Files.readAllLines(path));
    }
    private List<Iris> readAll(List<String> fields){
        List<Iris> iris = new ArrayList<>();
        for (int i = 1; i < fields.size(); i++) iris.add(readAll(fields.get(i)));
        return iris;
    }
    private Iris readAll(String field){
        return readAll(field.split(","));
    }
    private Iris readAll(String[] fields){
        return new Iris(Double.parseDouble(fields[0]), speciesOf(fields[4]));
    }

    private Species speciesOf(String field) {
        return field.isEmpty() ? null : Species.valueOf(field.trim().toUpperCase());
    }
}
