package software.ulpgc.katas.control;

import software.ulpgc.katas.model.Iris;
import software.ulpgc.katas.model.Species;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class IrisAnalyzer {
    private final List<Iris> listIris;

    public IrisAnalyzer(List<Iris> listIris) {
        this.listIris = listIris;
    }
    public Map<Species, Long> calculateSpeciesFrequency()
    {
        return listIris.stream()
                .filter(iris -> iris.species() != null)
                .collect(Collectors.groupingBy(
                Iris::species,
                Collectors.counting()
        ));
    }
    public Map<Species, Double>  calculateAverageSepalLengthBySpecies()
    {
        return listIris.stream()
                .filter(iris -> iris.species() != null)
                .collect(
                Collectors.groupingBy(
                        Iris::species,
                        Collectors.averagingDouble(Iris::sepalLength)));
    }
}
