package software.ulpgc.katas.io;

import software.ulpgc.katas.model.Iris;
import software.ulpgc.katas.model.Species;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileIrisReader implements IrisReader{
    private final File file;

    public FileIrisReader(File file) {
        this.file = file;
    }

    @Override
    public List<Iris> readAll() {
        try(InputStream inputStream = new FileInputStream(file)){
            return readAll(inputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private List<Iris> readAll(InputStream inputStream) throws IOException {
        try(Reader reader = new InputStreamReader(inputStream)){
            return readAll(reader);
        }
    }

    private List<Iris> readAll(Reader reader) throws IOException {
        return readAll(reader.readAllLines());
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
