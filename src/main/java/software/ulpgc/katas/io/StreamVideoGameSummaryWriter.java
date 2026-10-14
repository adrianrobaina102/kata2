package software.ulpgc.katas.io;

import software.ulpgc.katas.model.GenreStats;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class StreamVideoGameSummaryWriter implements VideoGameSummaryWriter {
    private final OutputStream outputStream;
    public StreamVideoGameSummaryWriter(OutputStream outputStream) {
        this.outputStream = outputStream;
    }
    @Override
    public void write(GenreStats genreStats) throws IOException {
        write(genreStats.getGenreCount().toString());
    }
    private void write(String genreStats) throws IOException {
        write(genreStats, new OutputStreamWriter(outputStream));
    }
    private void write(String genreStats, OutputStreamWriter writer) throws IOException {
        writer.write(genreStats);
        writer.flush();
    }
}
