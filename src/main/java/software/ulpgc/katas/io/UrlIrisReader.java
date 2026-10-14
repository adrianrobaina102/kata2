package software.ulpgc.katas.io;

import software.ulpgc.katas.model.Iris;
import software.ulpgc.katas.model.Species;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class UrlIrisReader implements IrisReader {
    private final URL url;
    public UrlIrisReader(URL url) {
        this.url = url;
    }
    @Override
    public List<Iris> readAll() {
        try {
            return readAll(url.openStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Iris> readAll(InputStream inputStream) throws IOException {
        try (Reader reader = new InputStreamReader(inputStream)) {
            return readAll(reader);
        }
    }
    private List<Iris> readAll(Reader reader) throws IOException {
        return readAll(reader.readAllLines());
    }
    private List<Iris> readAll(List<String> fields) {
        List<Iris> irisList = new ArrayList<>();
        for (int i = 1; i < fields.size(); i++) {
            irisList.add(readAll(fields.get(i)));
        }
        return irisList;
    }
    private Iris readAll(String field) {
        return readAll(field.split(","));
    }
    private Iris readAll(String[] fields) {
        return new Iris(Double.parseDouble(fields[0]), speciesOf(fields[4]));
    }
    private Species speciesOf(String field){
        return field.isEmpty() ? null : Species.valueOf(field.trim().toUpperCase());
    }
}
