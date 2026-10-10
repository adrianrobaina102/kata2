package software.ulpgc.katas.io;

import software.ulpgc.katas.model.Genre;
import software.ulpgc.katas.model.VideoGame;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileVideoGameLoader implements VideoGameLoader {
    private final File file;
    public FileVideoGameLoader(File file) {
        this.file = file;
    }
    @Override
    public List<VideoGame> load() {
        try {
            return load(file.toPath());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private List<VideoGame> load(Path path) throws IOException {
        return load(Files.readAllLines(path));
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
