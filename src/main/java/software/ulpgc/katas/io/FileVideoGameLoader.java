package software.ulpgc.katas.io;

import software.ulpgc.katas.model.Genre;
import software.ulpgc.katas.model.VideoGame;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileVideoGameLoader implements VideoGameLoader {
    private final File file;
    public FileVideoGameLoader(File file) {
        this.file = file;
    }
    @Override
    public List<VideoGame> load() throws IOException {
        try (InputStream inputStream = new FileInputStream(file)) {
            return load(inputStream);
        }
    }
    private List<VideoGame> load(InputStream inputStream) throws IOException {
        try(Reader reader = new InputStreamReader(inputStream)) {
            return  load(reader);
        }
    }
    private List<VideoGame> load(Reader reader) throws IOException {
        return load(reader.readAllLines());
    }
    private List<VideoGame> load(List<String> lines) {
        List<VideoGame> videogames = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            videogames.add(load(lines.get(i)));
        }
        return videogames;
    }
    private VideoGame load(String line) {
        return load(line.split(","));
    }
    private VideoGame load(String[] lines) {
        return new VideoGame(lines[1], lines[2], Genre.valueOf(lines[4]));
    }

}
