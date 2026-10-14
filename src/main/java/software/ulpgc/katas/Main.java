package software.ulpgc.katas;

import software.ulpgc.katas.io.StreamVideoGameSummaryWriter;
import software.ulpgc.katas.io.UrlVideoGameLoader;
import software.ulpgc.katas.io.VideoGameLoader;
import software.ulpgc.katas.io.VideoGameSummaryWriter;
import software.ulpgc.katas.model.Genre;
import software.ulpgc.katas.model.GenreStats;
import software.ulpgc.katas.model.VideoGame;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        URL url  = new URL("https://raw.githubusercontent.com/adrianrobaina102/kata2/refs/heads/master/videojuegos.csv");
        VideoGameLoader loader = new UrlVideoGameLoader(url);
        List<VideoGame> games = loader.load();
        Map<Genre, Integer> genreCount = new HashMap<>();
        for (VideoGame game : games) {
            Genre genre = game.genre();
            genreCount.put(genre, genreCount.getOrDefault(genre, 0) + 1);
        }
        GenreStats genreStats = new GenreStats(genreCount);
        VideoGameSummaryWriter writer = new StreamVideoGameSummaryWriter(System.out);
        writer.write(genreStats);
    }
}
