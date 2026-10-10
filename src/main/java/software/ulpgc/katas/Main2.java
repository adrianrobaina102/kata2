package software.ulpgc.katas;

import software.ulpgc.katas.io.FileVideoGameLoader;
import software.ulpgc.katas.io.StreamVideoGameSummaryWriter;
import software.ulpgc.katas.io.VideoGameLoader;
import software.ulpgc.katas.io.VideoGameSummaryWriter;
import software.ulpgc.katas.model.Genre;
import software.ulpgc.katas.model.VideoGame;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main2 {
    public static void main(String[] args) throws IOException {
        File file = new File("videojuegos.csv");
        VideoGameLoader loader = new FileVideoGameLoader(file);
        List<VideoGame> games = loader.load();

        System.out.println("¡Éxito! Se han cargado " + games.size() + " juegos desde tu disco duro.\n");

        Map<Genre, Integer> genreFrequencies = new HashMap<>();
        for (VideoGame game : games) {
            Genre genre = game.genre();
            genreFrequencies.put(genre, genreFrequencies.getOrDefault(genre, 0) + 1);
        }

        GenreStats genreStats = new GenreStats(genreFrequencies);
        VideoGameSummaryWriter writer = new StreamVideoGameSummaryWriter(System.out);
        writer.write(genreStats);
    }
}