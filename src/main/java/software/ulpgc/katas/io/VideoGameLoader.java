package software.ulpgc.katas.io;

import software.ulpgc.katas.model.VideoGame;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface VideoGameLoader {
    List<VideoGame> load() throws IOException;
}
