package software.ulpgc.katas;

import software.ulpgc.katas.io.IrisReader;
import software.ulpgc.katas.io.UrlIrisReader;
import software.ulpgc.katas.model.Iris;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Main {
    static void main() throws MalformedURLException {
        URL url = new URL("https://raw.githubusercontent.com/mwaskom/seaborn-data/master/iris.csv");
        IrisReader reader = new UrlIrisReader(url);
        List<Iris> listIris =  reader.readAll();
        for (Iris iris : listIris) {
            System.out.println(iris);
        }
    }
}
