package software.ulpgc.katas;

import software.ulpgc.katas.io.FileIrisReader;
import software.ulpgc.katas.model.Iris;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main2 {
    static void main(String[] args) throws IOException {
        File file = new File("iris.csv");
        FileIrisReader reader = new FileIrisReader(file);
        List<Iris> listIris = reader.readAll();
        for (Iris iris : listIris) {
            System.out.println(iris);
        }

    }
}
