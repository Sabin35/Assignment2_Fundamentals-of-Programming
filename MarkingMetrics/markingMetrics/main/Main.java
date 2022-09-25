package markingMetrics.main;

import markingMetrics.display.DisplayService;
import markingMetrics.entity.Grades;
import markingMetrics.fileService.FileHandler;
import markingMetrics.fileServiceImpl.FileHandlerImpl;
import java.util.InputMismatchException;


import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;

public
class Main {
    public static
    void main ( String[] args ) throws FileNotFoundException {


        DisplayService displayService = new DisplayService ( );

        FileHandler fileHandler = new FileHandlerImpl ( );
        List < Grades > grades = fileHandler.readMarksFromFile ( );

        boolean flag = true;

        while (flag) {
            try {
                Scanner sc = new Scanner ( System.in );
                displayService.displayMenu ( );

                int key = sc.nextInt ( );

                switch (key) {
                    case 1:
                        displayService.displayTotalMarks ( grades );
                        break;

                    case 2:
                        System.out.println ( );
                        System.out.print ( "Please enter the threshold for the total marks: " );
                        double threshold = sc.nextDouble ( );

                        if ( threshold > 100 ) {

                            System.out.println ( "The marks cannot exceed max limit of 100." );

                        } else {

                            System.out.println ( );

                            displayService.displayTotalMarksThreshold ( grades , threshold );

                        }
                        break;

                    case 3:
                        displayService.displayTopTenScorers ( grades );
                        break;

                    case 4:
                        displayService.displayBottomTenScorers ( grades );
                        break;

                    case 5:
                        displayService.displayGoodBye ( );
                        flag = false;
                        sc.close();
                        break;

                    default:
                        System.out.println ( "ERROR :: Invalid Input provided available (1/2/3/4/5)" );

                }
            } catch (InputMismatchException e) {

                System.out.println ( "ERROR OCCURRED :: Invalid Input Provided Please provide a valid Input" );


            } catch (Exception e) {

                System.out.println ( "ERROR OCCURRED :: " + e.getMessage ( ) );

            }

        }

    }
}