package software.ulpgc.katas.io;

import software.ulpgc.katas.GenreStats;

import java.io.IOException;

public interface VideoGameSummaryWriter {
    void write(GenreStats genreStats) throws IOException;
}
