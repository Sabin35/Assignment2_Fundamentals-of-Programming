package markingMetrics.mapper;

import markingMetrics.dto.StudentGradeDTO;
import markingMetrics.entity.Grades;
import markingMetrics.fileService.MetricsService;
import markingMetrics.fileServiceImpl.MetricsServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

public
class GradesMapper {

    public static StudentGradeDTO mapToDTO(Grades grades){
        StudentGradeDTO dto = new StudentGradeDTO (  );
        MetricsService service = new MetricsServiceImpl ();

        dto.setFirstName ( grades.getFirstName () );
        dto.setLastName ( grades.getLastName ( ) );
        dto.setStudent_id ( grades.getStudent_id ( ) );
        dto.setTotal_marks ( service.calculateTotalMarks ( grades ) );

        return dto;
    }

    public static List< StudentGradeDTO> mapToDTOList( List< Grades > gradesList){

        return gradesList
                .stream ()
                .map ( GradesMapper::mapToDTO )
                .collect ( Collectors.toList ( ) );

    }
}
