package markingMetrics.display;

import markingMetrics.dto.StudentGradeDTO;
import markingMetrics.entity.Grades;
import markingMetrics.fileService.MetricsService;
import markingMetrics.fileServiceImpl.MetricsServiceImpl;
import markingMetrics.mapper.GradesMapper;

import java.util.List;

public
class DisplayService {

    public
    void displayMenu ( ) {
        System.out.println ( "==================== WELCOME TO THE APPLICATION ====================" );
        System.out.println ( "======= Please choose an option from below e.g. (1/2/3) ============" );
        System.out.println ( "1 || Get Total marks of all students." );
        System.out.println ( "2 || Get Students within threshold." );
        System.out.println ( "3 || Get Top ten scorers." );
        System.out.println ( "4 || Get bottom tem scorers." );
        System.out.println ( "5 || Exit. :( " );
        System.out.println ( "===============================X====================================" );
        System.out.println ( );
    }

    public
    void displayTotalMarks ( List < Grades > gradesList ) {

        List < StudentGradeDTO > dtoList = GradesMapper.mapToDTOList ( gradesList );

        System.out.println ( "==========================TOTAL MARKS===============================" );
        System.out.println ( "=========== Student Name || Student ID  || TotalMarks ==============" );
        dtoList.forEach ( this::displayDTOData );
        System.out.println ( "===============================X====================================" );
        System.out.println ( );
    }

    public
    void displayTotalMarksThreshold ( List < Grades > gradesList , double threshold ) {

        List < StudentGradeDTO > dtoList = GradesMapper.mapToDTOList ( gradesList );

        System.out.println ( "======================TOTAL MARKS (THRESHOLD)=======================" );
        System.out.println ( "=========== Student Name || Student ID  || TotalMarks ==============" );
        dtoList.forEach ( dto -> {
            if ( dto.getTotal_marks ( ) <= threshold ) {

                displayDTOData ( dto );
            }
        } );
        System.out.println ( "===============================X====================================" );
        System.out.println ( );

    }

    public
    void displayTopTenScorers ( List < Grades > gradesList ) {

        MetricsService service = new MetricsServiceImpl ( );
        List < StudentGradeDTO > topTenScorers = service.getTenHighScorers ( gradesList );

        System.out.println ( "==========================TOP TEN SCORERS===========================" );
        System.out.println ( "=========== Student Name || Student ID  || TotalMarks ==============" );
        topTenScorers.forEach ( this::displayDTOData );
        System.out.println ( "===============================X====================================" );

    }

    public
    void displayBottomTenScorers ( List < Grades > gradesList ) {
        MetricsService service = new MetricsServiceImpl ( );
        List < StudentGradeDTO > bottomTenScorers = service.getTenLowScorers ( gradesList );

        System.out.println ( "========================BOTTOM TEN SCORERS==========================" );
        System.out.println ( "=========== Student Name || Student ID  || TotalMarks ==============" );
        bottomTenScorers.forEach ( this::displayDTOData );
        System.out.println ( "===============================X====================================" );
        System.out.println ( );

    }

    public void displayGoodBye(){
        System.out.println ( "=============THANK YOU FOR USING THE APPLICATION====================" );
        System.out.println ( "=========== HOPE YOU HAVE A WONDERFUL DAY AHEAD!!! =================" );
        System.out.println ( "=====================THANK YOU, GOODBYE!!===========================" );
    }

    private
    void displayDTOData ( StudentGradeDTO dto ) {

        String studentName = dto.getFirstName ( ) + " " + dto.getLastName ( );
        System.out.print ( studentName );
        System.out.print ( " ".repeat ( 10 ) );
        System.out.print ( dto.getStudent_id ( ) );
        System.out.print ( " ".repeat ( 10 ) );
        System.out.println ( dto.getTotal_marks ( ) );

    }
}
