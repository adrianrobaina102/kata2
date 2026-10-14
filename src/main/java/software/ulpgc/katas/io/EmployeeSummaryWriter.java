package software.ulpgc.katas.io;

import software.ulpgc.katas.model.Gender;

import java.io.IOException;
import java.util.Map;

public interface EmployeeSummaryWriter {
    void write(Map<Gender, Long> summary) throws IOException;
}
