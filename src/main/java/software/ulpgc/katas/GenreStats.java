package software.ulpgc.katas;

import software.ulpgc.katas.model.Genre;

import java.util.HashMap;
import java.util.Map;

public class GenreStats {
    private final Map<Genre, Integer> genreCount;

    public GenreStats(Map<Genre, Integer> genreCount) {
        this.genreCount = Map.copyOf(genreCount);
    }
    public Map<Genre, Integer> getGenreCount() {
        return genreCount;
    }
}
