package software.ulpgc.katas.io;

import software.ulpgc.katas.model.Gender;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Map;

public class StreamEmployeeSummaryWriter implements EmployeeSummaryWriter {
    private final OutputStream outputStream;

    public StreamEmployeeSummaryWriter(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void write(Map<Gender, Long> summary) throws IOException {
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);
        write(summary, writer);
    }
    private void write(Map<Gender, Long> summary, OutputStreamWriter writer) throws IOException {
        writer.write(summary.toString() + "\n");
        writer.flush();
    }
}
