package software.ulpgc.katas;

import software.ulpgc.katas.control.IrisAnalyzer;
import software.ulpgc.katas.io.FileIrisReader;
import software.ulpgc.katas.io.IrisSummaryWriter;
import software.ulpgc.katas.io.StreamIrisSummaryWriter;
import software.ulpgc.katas.model.Iris;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class Main2 {
    static void main(String[] args) throws IOException {
        File file = new File("iris.csv");
        FileIrisReader reader = new FileIrisReader(file);
        List<Iris> listIris = reader.readAll();

        IrisAnalyzer analyzer = new IrisAnalyzer(listIris);

        IrisSummaryWriter consoleWriter = new StreamIrisSummaryWriter(System.out);
        consoleWriter.write(analyzer.calculateSpeciesFrequency());
        consoleWriter.write(analyzer.calculateAverageSepalLengthBySpecies());

        try (FileOutputStream fos = new FileOutputStream("iris_stats.txt")) {
            IrisSummaryWriter fileWriter = new StreamIrisSummaryWriter(fos);
            fileWriter.write(analyzer.calculateSpeciesFrequency());
            fileWriter.write(analyzer.calculateAverageSepalLengthBySpecies());
            System.out.println("Estadísticas guardadas en iris_stats.txt");
        }

    }
}
