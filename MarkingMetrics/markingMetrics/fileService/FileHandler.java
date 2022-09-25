package markingMetrics.fileService;

import markingMetrics.entity.Grades;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public
interface FileHandler {

    List< Grades > readMarksFromFile ( );

    String readUnitFromFile() throws IOException;
}
