package software.ulpgc.katas.io;

import software.ulpgc.katas.model.Iris;
import software.ulpgc.katas.model.Species;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

public interface IrisSummaryWriter {
    void write(Map<Species, ?> summary) throws IOException;
}
