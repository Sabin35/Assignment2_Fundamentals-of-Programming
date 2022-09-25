package markingMetrics.fileServiceImpl;

import markingMetrics.dto.StudentGradeDTO;
import markingMetrics.entity.Grades;
import markingMetrics.fileService.MetricsService;
import markingMetrics.mapper.GradesMapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public
class MetricsServiceImpl implements MetricsService {


    @Override
    public
    double calculateTotalMarks ( Grades grades ) {

        return grades.getA1 ( )+ grades.getA2 ( )+ grades.getA3 ( );

    }

    @Override
    public
    List < StudentGradeDTO > getTenHighScorers ( List < Grades > gradesList ) {

        List<StudentGradeDTO> studentGradeDTOS = GradesMapper.mapToDTOList ( gradesList );
        studentGradeDTOS.sort ( Comparator.comparingDouble ( StudentGradeDTO::getTotal_marks ) );

        int size = studentGradeDTOS.size ();

        List<StudentGradeDTO> responseDTO = new ArrayList <> (  );

        for (int i =1; i <= 10; i++){

            responseDTO.add ( studentGradeDTOS.get ( size - i ) );

        }

        return responseDTO;
    }

    @Override
    public
    List < StudentGradeDTO > getTenLowScorers ( List < Grades > gradesList ) {

        List<StudentGradeDTO> studentGradeDTOS = GradesMapper.mapToDTOList ( gradesList );
        studentGradeDTOS.sort ( Comparator.comparingDouble ( StudentGradeDTO::getTotal_marks ) );

        List<StudentGradeDTO> responseDTO = new ArrayList <> (  );

        for (int i =1; i <= 10; i++){

            responseDTO.add ( studentGradeDTOS.get ( i ) );

        }

        return responseDTO;
    }


}
