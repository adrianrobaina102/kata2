package software.ulpgc.katas;

import software.ulpgc.katas.io.UrlVideoGameLoader;
import software.ulpgc.katas.io.VideoGameLoader;
import software.ulpgc.katas.model.VideoGame;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        URL url  = new URL("https://raw.githubusercontent.com/adrianrobaina102/kata2/refs/heads/master/videojuegos.csv");
        VideoGameLoader loader = new UrlVideoGameLoader(url);
        List<VideoGame> games = loader.load();
        for (VideoGame game : games) {
            System.out.println(game);
        }
    }
}
