package markingMetrics.fileService;

import markingMetrics.dto.StudentGradeDTO;
import markingMetrics.entity.Grades;

import java.util.List;

public
interface MetricsService {

    double calculateTotalMarks( Grades grades );

    List < StudentGradeDTO > getTenHighScorers(List<Grades> gradesList);

    List<StudentGradeDTO> getTenLowScorers(List<Grades> gradesList);

}
