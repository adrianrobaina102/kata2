package software.ulpgc.katas.io;

import software.ulpgc.katas.model.GenreStats;

import java.io.IOException;

public interface VideoGameSummaryWriter {
    void write(GenreStats genreStats) throws IOException;
}
