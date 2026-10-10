package software.ulpgc.katas.io;

import software.ulpgc.katas.model.Genre;
import software.ulpgc.katas.model.VideoGame;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class UrlVideoGameLoader implements VideoGameLoader {
    private final URL url;

    public UrlVideoGameLoader(URL url) {
        this.url = url;
    }

    @Override
    public List<VideoGame> load() {
        try {
            return load(url.openStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
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
        List<VideoGame> videoGames = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            videoGames.add(load(lines.get(i)));
        }
        return videoGames;
    }
    private VideoGame load(String line) {
        return load(line.split(","));
    }
    private  VideoGame load(String[] lines) {
        return new VideoGame(lines[1], lines[2], genreOf(lines[4]));
    }
    private Genre genreOf(String line) {
        return line.isEmpty() ? null : Genre.valueOf(line);
    }
}
