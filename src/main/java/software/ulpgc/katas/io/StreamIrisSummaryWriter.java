package software.ulpgc.katas.io;

import software.ulpgc.katas.model.Iris;
import software.ulpgc.katas.model.Species;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Map;

public class StreamIrisSummaryWriter implements IrisSummaryWriter {
    private final OutputStream outputStream;

    public StreamIrisSummaryWriter(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void write(Map<Species, ?> summary) throws IOException {
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);
        write(summary, writer);
    }
    private void write(Map<Species, ?> summary, OutputStreamWriter writer) throws IOException {
        writer.write(summary.toString() + "\n");
        writer.flush();
    }
}
